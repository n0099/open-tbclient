package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes12.dex */
public class jp extends js {

    /* renamed from: a  reason: collision with root package name */
    protected InputStream f5006a;

    /* renamed from: a  reason: collision with other field name */
    protected OutputStream f780a;

    protected jp() {
        this.f5006a = null;
        this.f780a = null;
    }

    public jp(OutputStream outputStream) {
        this.f5006a = null;
        this.f780a = null;
        this.f780a = outputStream;
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        if (this.f5006a == null) {
            throw new jt(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.f5006a.read(bArr, i, i2);
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
        if (this.f780a == null) {
            throw new jt(1, "Cannot write to null outputStream");
        }
        try {
            this.f780a.write(bArr, i, i2);
        } catch (IOException e) {
            throw new jt(0, e);
        }
    }
}
