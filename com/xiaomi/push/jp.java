package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes7.dex */
public class jp extends js {
    protected InputStream a;

    /* renamed from: a  reason: collision with other field name */
    protected OutputStream f783a;

    protected jp() {
        this.a = null;
        this.f783a = null;
    }

    public jp(OutputStream outputStream) {
        this.a = null;
        this.f783a = null;
        this.f783a = outputStream;
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        if (this.a == null) {
            throw new jt(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.a.read(bArr, i, i2);
            if (read < 0) {
                throw new jt(4);
            }
            return read;
        } catch (IOException e) {
            throw new jt(0, e);
        }
    }

    @Override // com.xiaomi.push.js
    public void a(byte[] bArr, int i, int i2) {
        if (this.f783a == null) {
            throw new jt(1, "Cannot write to null outputStream");
        }
        try {
            this.f783a.write(bArr, i, i2);
        } catch (IOException e) {
            throw new jt(0, e);
        }
    }
}
