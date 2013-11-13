package org.msgpack.unpacker;

import com.baidu.zeus.bouncycastle.DERTags;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private int f2979a = 0;
    private byte[] b = new byte[DERTags.TAGGED];
    private int[] c = new int[DERTags.TAGGED];

    public m() {
        this.b[0] = 0;
    }

    public void a(int i) {
        this.f2979a++;
        this.b[this.f2979a] = 1;
        this.c[this.f2979a] = i;
    }

    public void b(int i) {
        this.f2979a++;
        this.b[this.f2979a] = 2;
        this.c[this.f2979a] = i * 2;
    }

    public void a() {
        if (this.c[this.f2979a] <= 0) {
            if (this.b[this.f2979a] == 1) {
                throw new MessageTypeException("Array is end but readArrayEnd() is not called");
            }
            if (this.b[this.f2979a] == 2) {
                throw new MessageTypeException("Map is end but readMapEnd() is not called");
            }
        }
    }

    public void b() {
        int[] iArr = this.c;
        int i = this.f2979a;
        iArr[i] = iArr[i] - 1;
    }

    public void c() {
        this.f2979a--;
    }

    public int d() {
        return this.f2979a;
    }

    public int e() {
        return this.c[this.f2979a];
    }

    public boolean f() {
        return this.b[this.f2979a] == 1;
    }

    public boolean g() {
        return this.b[this.f2979a] == 2;
    }
}
