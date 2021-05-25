package d.a.d0.a.c;

import com.baidu.prologue.service.network.Request;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes2.dex */
public final class e {

    /* loaded from: classes2.dex */
    public static class a implements d.a.d0.d.a.k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f39602a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f39603b;

        public a(File file, b bVar) {
            this.f39602a = file;
            this.f39603b = bVar;
        }

        @Override // d.a.d0.d.a.k
        public void a(Throwable th) {
        }

        @Override // d.a.d0.d.a.k
        public void b(long j, InputStream inputStream) {
            try {
                e.c(inputStream, this.f39602a);
                if (this.f39603b != null) {
                    this.f39603b.a();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0022 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    public static int a(File file) {
        int a2;
        int i2 = 0;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i3 = 0;
                while (i2 < length) {
                    File file2 = listFiles[i2];
                    if (file2.isFile()) {
                        a2 = file2.delete();
                    } else {
                        a2 = a(file2);
                    }
                    i3 += a2;
                    i2++;
                }
                i2 = i3;
            }
            if (!file.delete()) {
                g gVar = g.f39604a;
                gVar.e("FileUtil", "delete dir " + file.getAbsolutePath() + " failed.");
            }
        }
        return i2;
    }

    public static void b(File file, String str, b bVar) {
        Request.c cVar = new Request.c(d.a.d0.a.b.b.a(), str);
        cVar.m();
        cVar.l().d(new a(file, bVar));
    }

    public static void c(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ReadableByteChannel newChannel = Channels.newChannel(inputStream);
        FileChannel channel = fileOutputStream.getChannel();
        long j = 4194304;
        long j2 = 0;
        while (j > 0) {
            try {
                j = channel.transferFrom(newChannel, j2, 4194304L);
                j2 += j;
            } finally {
                k.a(fileOutputStream);
            }
        }
    }
}
