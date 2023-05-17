package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.baidu.android.util.io.ZipUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
/* loaded from: classes9.dex */
public final class bk {

    /* loaded from: classes9.dex */
    public static class a extends ZipOutputStream {
        public Map<String, Integer> aps;

        public a(OutputStream outputStream) {
            super(outputStream);
            this.aps = new HashMap();
        }

        @Override // java.util.zip.ZipOutputStream
        public final void putNextEntry(ZipEntry zipEntry) {
            ZipEntry zipEntry2;
            Integer num;
            String name = zipEntry.getName();
            Integer num2 = this.aps.get(name);
            if (num2 == null || num2.intValue() <= 0) {
                zipEntry2 = zipEntry;
                num = 1;
            } else {
                zipEntry2 = new ZipEntry(zipEntry.getName().replaceFirst("\\.", "(" + num2 + ")."));
                num = Integer.valueOf(num2.intValue() + 1);
            }
            this.aps.put(name, num);
            super.putNextEntry(zipEntry2);
        }
    }

    public static void a(ZipOutputStream zipOutputStream, File file, String str, byte[] bArr) {
        BufferedInputStream bufferedInputStream;
        File[] listFiles;
        if (zipOutputStream == null || file == null) {
            com.kwad.sdk.core.e.b.e(ZipUtils.TAG, "", new IOException("(dozip:179) I/O Object got NullPointerException"));
        } else if (!file.exists()) {
            com.kwad.sdk.core.e.b.e(ZipUtils.TAG, file.toString(), new FileNotFoundException("(doZip:142)Target File is missing"));
        } else {
            BufferedInputStream bufferedInputStream2 = null;
            String eb = TextUtils.isEmpty(str) ? eb(file.getName()) : str + File.separator + eb(file.getName());
            if (!file.isFile()) {
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                for (File file2 : listFiles) {
                    a(zipOutputStream, file2, eb, bArr);
                }
                return;
            }
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (IOException e) {
                e = e;
            }
            try {
                zipOutputStream.putNextEntry(new ZipEntry(eb));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, bArr.length);
                    if (-1 == read) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        return;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
            } catch (IOException e2) {
                e = e2;
                bufferedInputStream2 = bufferedInputStream;
                com.kwad.sdk.core.e.b.e(ZipUtils.TAG, "error doZip", e);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                throw e;
            }
        }
    }

    public static boolean a(File[] fileArr, File file) {
        if (file == null) {
            return false;
        }
        a aVar = null;
        try {
            try {
                byte[] bArr = new byte[4096];
                a aVar2 = new a(new BufferedOutputStream(new FileOutputStream(file, false)));
                for (int i = 0; i <= 0; i++) {
                    try {
                        a(aVar2, fileArr[0], null, bArr);
                    } catch (IOException e) {
                        e = e;
                        aVar = aVar2;
                        com.kwad.sdk.core.e.b.e(ZipUtils.TAG, "error zip", e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        aVar = aVar2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                        throw th;
                    }
                }
                aVar2.flush();
                aVar2.closeEntry();
                com.kwad.sdk.crash.utils.b.closeQuietly(aVar2);
                return true;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static String eb(String str) {
        return ((!TextUtils.isEmpty(str) || str.length() <= 1) && !TextUtils.isEmpty(str) && str.charAt(0) == '.') ? str.substring(1) : str;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x009b */
    /* JADX DEBUG: Multi-variable search result rejected for r6v5, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6 */
    public static boolean unZip(InputStream inputStream, String str) {
        BufferedInputStream bufferedInputStream;
        ZipInputStream zipInputStream;
        FileOutputStream fileOutputStream;
        Closeable closeable;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        ZipInputStream zipInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    zipInputStream = new ZipInputStream(bufferedInputStream);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                    return true;
                }
                String name = nextEntry.getName();
                if (!name.contains("../")) {
                    if (nextEntry.isDirectory()) {
                        new File(str + "/" + name).mkdirs();
                    } else {
                        File file2 = new File(str + "/" + name);
                        if (!file2.getParentFile().exists()) {
                            file2.getParentFile().mkdirs();
                        }
                        try {
                            fileOutputStream = new FileOutputStream(file2);
                            while (true) {
                                try {
                                    try {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        zipInputStream2 = fileOutputStream;
                                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream2);
                                        throw th;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    com.kwad.sdk.core.e.b.e(ZipUtils.TAG, "error unZip when write", e);
                                    closeable = fileOutputStream;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                    zipInputStream.closeEntry();
                                }
                            }
                            fileOutputStream.flush();
                            fileOutputStream.getFD().sync();
                            closeable = fileOutputStream;
                        } catch (IOException e4) {
                            e = e4;
                            fileOutputStream = 0;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                        zipInputStream.closeEntry();
                    }
                }
            }
        } catch (IOException e5) {
            e = e5;
            zipInputStream2 = zipInputStream;
            com.kwad.sdk.core.e.b.e(ZipUtils.TAG, "error unZip", e);
            com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream2);
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
            return false;
        } catch (Throwable th5) {
            th = th5;
            zipInputStream2 = zipInputStream;
            com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream2);
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
            throw th;
        }
    }

    public static boolean zip(File file, File file2) {
        return a(new File[]{file}, file2);
    }

    public static void zipFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(".zip")) {
            return;
        }
        if (zip(file, new File(absolutePath + ".zip"))) {
            file.delete();
        }
    }
}
