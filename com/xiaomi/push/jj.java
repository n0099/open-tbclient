package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class jj extends jm {
    protected InputStream a;

    /* renamed from: a  reason: collision with other field name */
    protected OutputStream f794a;

    protected jj() {
        this.a = null;
        this.f794a = null;
    }

    public jj(OutputStream outputStream) {
        this.a = null;
        this.f794a = null;
        this.f794a = outputStream;
    }

    @Override // com.xiaomi.push.jm
    public int a(byte[] bArr, int i, int i2) {
        if (this.a == null) {
            throw new jn(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.a.read(bArr, i, i2);
            if (read < 0) {
                throw new jn(4);
            }
            return read;
        } catch (IOException e) {
            throw new jn(0, e);
        }
    }

    @Override // com.xiaomi.push.jm
    public void a(byte[] bArr, int i, int i2) {
        if (this.f794a == null) {
            throw new jn(1, "Cannot write to null outputStream");
        }
        try {
            this.f794a.write(bArr, i, i2);
        } catch (IOException e) {
            throw new jn(0, e);
        }
    }
}
