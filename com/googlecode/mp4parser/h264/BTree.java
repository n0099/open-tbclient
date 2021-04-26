package com.googlecode.mp4parser.h264;
/* loaded from: classes6.dex */
public class BTree {
    public BTree one;
    public Object value;
    public BTree zero;

    public void addString(String str, Object obj) {
        BTree bTree;
        if (str.length() == 0) {
            this.value = obj;
            return;
        }
        if (str.charAt(0) == '0') {
            if (this.zero == null) {
                this.zero = new BTree();
            }
            bTree = this.zero;
        } else {
            if (this.one == null) {
                this.one = new BTree();
            }
            bTree = this.one;
        }
        bTree.addString(str.substring(1), obj);
    }

    public BTree down(int i2) {
        if (i2 == 0) {
            return this.zero;
        }
        return this.one;
    }

    public Object getValue() {
        return this.value;
    }
}
