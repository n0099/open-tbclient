package d.b.h0.r.y;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/* loaded from: classes3.dex */
public class r {
    public static boolean a(File file, String str) {
        ZipFile zipFile;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        File file2 = new File(str);
        if (file2.exists() || file2.mkdirs()) {
            boolean z = true;
            ZipFile zipFile2 = null;
            InputStream inputStream2 = null;
            zipFile2 = null;
            try {
                try {
                    zipFile = new ZipFile(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry nextElement = entries.nextElement();
                        String name = nextElement.getName();
                        if (name == null || !name.contains("__MACOSX/")) {
                            File file3 = new File(str, name);
                            if (nextElement.isDirectory()) {
                                file3.mkdirs();
                            } else {
                                inputStream = zipFile.getInputStream(nextElement);
                                try {
                                    fileOutputStream = new FileOutputStream(file3);
                                    try {
                                        try {
                                            byte[] bArr = new byte[1024];
                                            while (true) {
                                                int read = inputStream.read(bArr);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, 0, read);
                                            }
                                            fileOutputStream.flush();
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e3) {
                                                    e3.printStackTrace();
                                                }
                                            }
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e4) {
                                                e4.printStackTrace();
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            e.printStackTrace();
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e6) {
                                                    e6.printStackTrace();
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e7) {
                                                    e7.printStackTrace();
                                                }
                                            }
                                            z = false;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream2 = inputStream;
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (IOException e8) {
                                                e8.printStackTrace();
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e9) {
                                                e9.printStackTrace();
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    fileOutputStream = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = null;
                                }
                            }
                        }
                    } catch (Exception e11) {
                        e = e11;
                        inputStream = null;
                        fileOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
                return z;
            } catch (Exception e13) {
                e = e13;
                zipFile2 = zipFile;
                e.printStackTrace();
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                        return false;
                    } catch (IOException e14) {
                        e14.printStackTrace();
                        return false;
                    }
                }
                return false;
            } catch (Throwable th5) {
                th = th5;
                zipFile2 = zipFile;
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException e15) {
                        e15.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return false;
    }

    public static boolean b(String str, String str2) {
        return a(new File(str), str2);
    }

    public static void c(String str, String str2, ZipOutputStream zipOutputStream) throws Exception {
        if (zipOutputStream == null) {
            return;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            ZipEntry zipEntry = new ZipEntry(str2);
            FileInputStream fileInputStream = new FileInputStream(file);
            zipOutputStream.putNextEntry(zipEntry);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    zipOutputStream.closeEntry();
                    return;
                }
            }
        } else if (file.isDirectory()) {
            String[] list = file.list();
            if (list.length <= 0) {
                zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                zipOutputStream.closeEntry();
            }
            for (int i = 0; i < list.length; i++) {
                c(str, str2 + File.separator + list[i], zipOutputStream);
            }
        }
    }

    public static boolean d(String str, String str2) {
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        } catch (IOException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                d.b.b.e.p.m.f(zipOutputStream);
                return false;
            }
            c(file.getParent(), file.getName(), zipOutputStream);
            zipOutputStream.finish();
            zipOutputStream.close();
            d.b.b.e.p.m.f(zipOutputStream);
            return true;
        } catch (FileNotFoundException e5) {
            e = e5;
            zipOutputStream2 = zipOutputStream;
            e.printStackTrace();
            d.b.b.e.p.m.f(zipOutputStream2);
            return false;
        } catch (IOException e6) {
            e = e6;
            zipOutputStream2 = zipOutputStream;
            e.printStackTrace();
            d.b.b.e.p.m.f(zipOutputStream2);
            return false;
        } catch (Exception e7) {
            e = e7;
            zipOutputStream2 = zipOutputStream;
            e.printStackTrace();
            d.b.b.e.p.m.f(zipOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            d.b.b.e.p.m.f(zipOutputStream2);
            throw th;
        }
    }
}
