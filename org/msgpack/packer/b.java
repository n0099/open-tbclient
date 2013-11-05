package org.msgpack.packer;

import com.baidu.zeus.bouncycastle.DERTags;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f2850a = 0;
    private byte[] b = new byte[DERTags.TAGGED];
    private int[] c = new int[DERTags.TAGGED];

    public b() {
        this.b[0] = 0;
    }

    public void a(int i) {
        this.f2850a++;
        this.b[this.f2850a] = 1;
        this.c[this.f2850a] = i;
    }

    public void b(int i) {
        this.f2850a++;
        this.b[this.f2850a] = 2;
        this.c[this.f2850a] = i * 2;
    }

    public void a() {
        if (this.c[this.f2850a] <= 0) {
            if (this.b[this.f2850a] == 1) {
                throw new MessageTypeException("Array is end but writeArrayEnd() is not called");
            }
            if (this.b[this.f2850a] == 2) {
                throw new MessageTypeException("Map is end but writeMapEnd() is not called");
            }
        }
    }

    public void b() {
        int[] iArr = this.c;
        int i = this.f2850a;
        iArr[i] = iArr[i] - 1;
    }

    public void c() {
        this.f2850a--;
    }

    public int d() {
        return this.f2850a;
    }

    public int e() {
        return this.c[this.f2850a];
    }

    public boolean f() {
        return this.b[this.f2850a] == 1;
    }

    public boolean g() {
        return this.b[this.f2850a] == 2;
    }
}
