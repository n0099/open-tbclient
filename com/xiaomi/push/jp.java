package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes12.dex */
public class jp extends js {

    /* renamed from: a  reason: collision with root package name */
    protected InputStream f5008a;

    /* renamed from: a  reason: collision with other field name */
    protected OutputStream f782a;

    protected jp() {
        this.f5008a = null;
        this.f782a = null;
    }

    public jp(OutputStream outputStream) {
        this.f5008a = null;
        this.f782a = null;
        this.f782a = outputStream;
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        if (this.f5008a == null) {
            throw new jt(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.f5008a.read(bArr, i, i2);
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
        if (this.f782a == null) {
            throw new jt(1, "Cannot write to null outputStream");
        }
        try {
            this.f782a.write(bArr, i, i2);
        } catch (IOException e) {
            throw new jt(0, e);
        }
    }
}
