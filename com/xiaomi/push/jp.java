package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes6.dex */
public class jp extends js {

    /* renamed from: a  reason: collision with root package name */
    protected InputStream f14481a;

    /* renamed from: a  reason: collision with other field name */
    protected OutputStream f862a;

    protected jp() {
        this.f14481a = null;
        this.f862a = null;
    }

    public jp(OutputStream outputStream) {
        this.f14481a = null;
        this.f862a = null;
        this.f862a = outputStream;
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        if (this.f14481a == null) {
            throw new jt(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.f14481a.read(bArr, i, i2);
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
        if (this.f862a == null) {
            throw new jt(1, "Cannot write to null outputStream");
        }
        try {
            this.f862a.write(bArr, i, i2);
        } catch (IOException e) {
            throw new jt(0, e);
        }
    }
}
