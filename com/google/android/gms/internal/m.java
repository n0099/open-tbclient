package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataBuffer;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class m extends DataBuffer {
    private boolean b;
    private ArrayList c;

    public m(k kVar) {
        super(kVar);
        this.b = false;
    }

    private int a(int i) {
        n.a(i >= 0 && i < this.c.size(), "Position " + i + " is out of bounds for this buffer");
        return ((Integer) this.c.get(i)).intValue();
    }

    private int c(int i) {
        if (i < 0 || i == this.c.size()) {
            return 0;
        }
        return i == this.c.size() + (-1) ? this.a.d() - ((Integer) this.c.get(i)).intValue() : ((Integer) this.c.get(i + 1)).intValue() - ((Integer) this.c.get(i)).intValue();
    }

    private void d() {
        synchronized (this) {
            if (!this.b) {
                int d = this.a.d();
                this.c = new ArrayList();
                if (d > 0) {
                    this.c.add(0);
                    String c = c();
                    String c2 = this.a.c(c, 0, this.a.a(0));
                    int i = 1;
                    while (i < d) {
                        String c3 = this.a.c(c, i, this.a.a(i));
                        if (c3.equals(c2)) {
                            c3 = c2;
                        } else {
                            this.c.add(Integer.valueOf(i));
                        }
                        i++;
                        c2 = c3;
                    }
                }
                this.b = true;
            }
        }
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public int a() {
        d();
        return this.c.size();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final Object b(int i) {
        d();
        return b(a(i), c(i));
    }

    protected abstract Object b(int i, int i2);

    protected abstract String c();
}
