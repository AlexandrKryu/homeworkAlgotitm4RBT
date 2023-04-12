package org.example;

class RBNode {
    public Integer key;
    public boolean red;
    public RBNode p, left, right;

    public RBNode(int key, boolean red) {
        this.key = key;
        this.red = red;
        this.p = this.left = this.right = RBTree.nil;
    }

    public RBNode find(int key) {
        if (key < this.key && this.left != RBTree.nil) return this.left.find(key);
        else if (key > this.key && this.right != RBTree.nil) return this.right.find(key);
        else return this;
    }

    public void find50(Counter qtty, int from, RBTree result) {
        if (qtty.getValue() >= 50) return;

        if (this.left != RBTree.nil) {
            this.left.find50(qtty, from, result);
        }

        if (this.key > from && qtty.getValue() < 50) {
            result.add(this.key);
            qtty.increment();
        }

        if (this.right != RBTree.nil) {
            this.right.find50(qtty, from, result);
        }
    }

    public RBNode min() {
        if (this.left != RBTree.nil) return this.left.min();
        else return this;
    }

    public RBNode max() {
        if (this.right != RBTree.nil) return this.right.max();
        else return this;
    }

    public RBNode predecessor() {
        if (this.left != RBTree.nil) return this.left.max();
        else return this;
    }

    public RBNode successor() {
        if (this.right != RBTree.nil) return this.right.min();
        else return this;
    }

    public int size() {
        int size = 1;
        if (this.right != RBTree.nil) size += this.right.size();
        if (this.left != RBTree.nil) size += this.left.size();
        return size;
    }

    public int depth() {
        if (this.p != RBTree.nil) return 1 + this.p.depth();
        else return 0;
    }

    public int height() {
        if (this.left != RBTree.nil && this.right != RBTree.nil) {
            return 1 + Math.max(this.left.height(), this.right.height());
        }
        else if (this.left != RBTree.nil) {
            return 1 + this.left.height();
        }
        else if (this.right != RBTree.nil) {
            return 1 + this.right.height();
        }
        else return 0;
    }

    public void inorderWalk() {
        if (this.left != RBTree.nil) this.left.inorderWalk();
        System.out.println(this.key);
        if (this.right != RBTree.nil) this.right.inorderWalk();
    }

    public String toString() {
        return this.key.toString();
    }

    public void graph() {
        if (this.red) { // coloring
            System.out.println("\t" + this.key + " [style = filled, fillcolor = red];");
        } else {
            System.out.println("\t" + this.key + " [style = filled, fillcolor = black, fontcolor = white];");
        }

        if (this.left != RBTree.nil) {
            System.out.println("\t" + this.key + " -> " + this.left.key + " [label = \" left\"];");
            this.left.graph();
        }
        else {
            System.out.println("\t" + this.key + " -> nil [label = \" left\"];");
        }

        if (this.right != RBTree.nil) {
            System.out.println("\t" + this.key + " -> " + this.right.key + " [label = \" right\"];");
            this.right.graph();
        }
        else {
            System.out.println("\t" + this.key + " -> nil [label = \" right\"];");
        }
    }
}