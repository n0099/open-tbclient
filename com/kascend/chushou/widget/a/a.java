package com.kascend.chushou.widget.a;

import com.kascend.chushou.constants.ParserRet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements d<ParserRet> {
    private final LinkedList<Integer> a = new LinkedList<>();
    private long b = 1;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kascend.chushou.widget.a.d
    /* renamed from: c */
    public long B(ParserRet parserRet) {
        boolean z;
        if (!d(parserRet)) {
            this.b = 1L;
            return this.b * 1000;
        }
        Iterator<Integer> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().intValue() > 0) {
                z = true;
                break;
            }
        }
        if (z) {
            this.b = 1L;
        } else {
            this.b++;
        }
        this.b = a(this.b);
        return this.b * 1000;
    }

    @Override // com.kascend.chushou.widget.a.d
    public long a() {
        return B(null);
    }

    @Override // com.kascend.chushou.widget.a.d
    public void b() {
        this.b = 1L;
        this.a.clear();
    }

    @Override // com.kascend.chushou.widget.a.d
    public void c() {
        if (this.a.size() < 3) {
            this.a.add(1);
            return;
        }
        this.a.removeFirst();
        this.a.addLast(1);
    }

    private boolean d(ParserRet parserRet) {
        if (parserRet == null || !(parserRet.mData instanceof List)) {
            return this.a.size() >= 3;
        }
        if (this.a.size() < 3) {
            this.a.add(Integer.valueOf(e(parserRet)));
        } else {
            this.a.removeFirst();
            this.a.addLast(Integer.valueOf(e(parserRet)));
        }
        return this.a.size() >= 3;
    }

    private long a(long j) {
        if (j < 1) {
            return 1L;
        }
        if (j > 5) {
            return 5L;
        }
        return j;
    }

    private int e(ParserRet parserRet) {
        return ((List) parserRet.mData).size();
    }
}
