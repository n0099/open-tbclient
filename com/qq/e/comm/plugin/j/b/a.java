package com.qq.e.comm.plugin.j.b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes15.dex */
abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final InputStream f12158a;

    /* renamed from: b  reason: collision with root package name */
    protected final File f12159b;
    protected final c c;
    protected String d;

    public a(InputStream inputStream, File file, c cVar) {
        this.f12158a = inputStream;
        this.f12159b = file;
        this.c = cVar;
    }

    public int a() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.f12159b, true);
            try {
                int a2 = a(fileOutputStream);
                try {
                    fileOutputStream.close();
                    return a2;
                } catch (Throwable th) {
                    return a2;
                }
            } catch (SocketException e) {
                this.d = "UnknowSocketExceptionWhileDoPartitionRW:" + e.getMessage();
                return 4194304;
            } catch (SocketTimeoutException e2) {
                this.d = "SocketTimeoutExceptionWhileDoPartitionRW:" + e2.getMessage();
                return 16777216;
            } catch (IOException e3) {
                this.d = "UnknowIOExceptionWhileDoPartitionRW:" + e3.getMessage();
                return 2;
            }
        } catch (IOException e4) {
            this.d = "UnKnownExceptionWhileCreateOutputStreamForPartitionFile:" + e4.getMessage();
            return 2;
        }
    }

    protected abstract int a(FileOutputStream fileOutputStream) throws IOException;

    public String b() {
        return this.d;
    }
}
