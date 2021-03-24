package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes7.dex */
public class ji extends jl {

    /* renamed from: a  reason: collision with root package name */
    public InputStream f40883a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f813a;

    public ji() {
        this.f40883a = null;
        this.f813a = null;
    }

    public ji(OutputStream outputStream) {
        this.f40883a = null;
        this.f813a = null;
        this.f813a = outputStream;
    }

    @Override // com.xiaomi.push.jl
    public int a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.f40883a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new jm(4);
            } catch (IOException e2) {
                throw new jm(0, e2);
            }
        }
        throw new jm(1, "Cannot read from null inputStream");
    }

    @Override // com.xiaomi.push.jl
    public void a(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.f813a;
        if (outputStream == null) {
            throw new jm(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e2) {
            throw new jm(0, e2);
        }
    }
}
