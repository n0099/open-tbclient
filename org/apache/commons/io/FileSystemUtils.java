package org.apache.commons.io;

import cn.jingling.lib.file.Shared;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
/* loaded from: classes.dex */
public class FileSystemUtils {
    private static final String DF;
    private static final int INIT_PROBLEM = -1;
    private static final FileSystemUtils INSTANCE = new FileSystemUtils();
    private static final int OS;
    private static final int OTHER = 0;
    private static final int POSIX_UNIX = 3;
    private static final int UNIX = 2;
    private static final int WINDOWS = 1;

    static {
        String property;
        int i = 3;
        String str = "df";
        try {
            property = System.getProperty("os.name");
        } catch (Exception e) {
            i = -1;
        }
        if (property == null) {
            throw new IOException("os.name not found");
        }
        String lowerCase = property.toLowerCase(Locale.ENGLISH);
        if (lowerCase.indexOf("windows") != -1) {
            i = 1;
        } else if (lowerCase.indexOf("linux") != -1 || lowerCase.indexOf("mpe/ix") != -1 || lowerCase.indexOf("freebsd") != -1 || lowerCase.indexOf("irix") != -1 || lowerCase.indexOf("digital unix") != -1 || lowerCase.indexOf("unix") != -1 || lowerCase.indexOf("mac os x") != -1) {
            i = 2;
        } else if (lowerCase.indexOf("sun os") != -1 || lowerCase.indexOf("sunos") != -1 || lowerCase.indexOf("solaris") != -1) {
            str = "/usr/xpg4/bin/df";
        } else if (lowerCase.indexOf("hp-ux") == -1 && lowerCase.indexOf("aix") == -1) {
            i = 0;
        }
        OS = i;
        DF = str;
    }

    @Deprecated
    public static long freeSpace(String str) {
        return INSTANCE.freeSpaceOS(str, OS, false, -1L);
    }

    public static long freeSpaceKb(String str) {
        return freeSpaceKb(str, -1L);
    }

    public static long freeSpaceKb(String str, long j) {
        return INSTANCE.freeSpaceOS(str, OS, true, j);
    }

    public static long freeSpaceKb() {
        return freeSpaceKb(-1L);
    }

    public static long freeSpaceKb(long j) {
        return freeSpaceKb(new File(".").getAbsolutePath(), j);
    }

    long freeSpaceOS(String str, int i, boolean z, long j) {
        if (str == null) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        switch (i) {
            case 0:
                throw new IllegalStateException("Unsupported operating system");
            case 1:
                return z ? freeSpaceWindows(str, j) / FileUtils.ONE_KB : freeSpaceWindows(str, j);
            case 2:
                return freeSpaceUnix(str, z, false, j);
            case 3:
                return freeSpaceUnix(str, z, true, j);
            default:
                throw new IllegalStateException("Exception caught when determining operating system");
        }
    }

    long freeSpaceWindows(String str, long j) {
        String normalize = FilenameUtils.normalize(str, false);
        String str2 = (normalize.length() <= 0 || normalize.charAt(0) == '\"') ? normalize : "\"" + normalize + "\"";
        List<String> performCommand = performCommand(new String[]{"cmd.exe", "/C", "dir /a /-c " + str2}, Shared.INFINITY, j);
        for (int size = performCommand.size() - 1; size >= 0; size--) {
            String str3 = performCommand.get(size);
            if (str3.length() > 0) {
                return parseDir(str3, str2);
            }
        }
        throw new IOException("Command line 'dir /-c' did not return any info for path '" + str2 + "'");
    }

    long parseDir(String str, String str2) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int length = str.length() - 1;
        while (true) {
            if (length < 0) {
                i = length;
                i2 = 0;
                break;
            } else if (Character.isDigit(str.charAt(length))) {
                i2 = length + 1;
                i = length;
                break;
            } else {
                length--;
            }
        }
        while (true) {
            if (i < 0) {
                i3 = 0;
                break;
            }
            char charAt = str.charAt(i);
            if (!Character.isDigit(charAt) && charAt != ',' && charAt != '.') {
                i3 = i + 1;
                break;
            }
            i--;
        }
        if (i < 0) {
            throw new IOException("Command line 'dir /-c' did not return valid info for path '" + str2 + "'");
        }
        StringBuilder sb = new StringBuilder(str.substring(i3, i2));
        while (i4 < sb.length()) {
            if (sb.charAt(i4) == ',' || sb.charAt(i4) == '.') {
                sb.deleteCharAt(i4);
                i4--;
            }
            i4++;
        }
        return parseBytes(sb.toString(), str2);
    }

    long freeSpaceUnix(String str, boolean z, boolean z2, long j) {
        StringTokenizer stringTokenizer;
        if (str.length() == 0) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        String str2 = z ? "-k" : "-";
        if (z2) {
            str2 = str2 + "P";
        }
        List<String> performCommand = performCommand(str2.length() > 1 ? new String[]{DF, str2, str} : new String[]{DF, str}, 3, j);
        if (performCommand.size() < 2) {
            throw new IOException("Command line '" + DF + "' did not return info as expected for path '" + str + "'- response was " + performCommand);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(performCommand.get(1), " ");
        if (stringTokenizer2.countTokens() < 4) {
            if (stringTokenizer2.countTokens() == 1 && performCommand.size() >= 3) {
                stringTokenizer = new StringTokenizer(performCommand.get(2), " ");
            } else {
                throw new IOException("Command line '" + DF + "' did not return data as expected for path '" + str + "'- check path is valid");
            }
        } else {
            stringTokenizer2.nextToken();
            stringTokenizer = stringTokenizer2;
        }
        stringTokenizer.nextToken();
        stringTokenizer.nextToken();
        return parseBytes(stringTokenizer.nextToken(), str);
    }

    long parseBytes(String str, String str2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong < 0) {
                throw new IOException("Command line '" + DF + "' did not find free space in response for path '" + str2 + "'- check path is valid");
            }
            return parseLong;
        } catch (NumberFormatException e) {
            throw new IOExceptionWithCause("Command line '" + DF + "' did not return numeric data as expected for path '" + str2 + "'- check path is valid", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    List<String> performCommand(String[] strArr, int i, long j) {
        BufferedReader bufferedReader;
        InputStream inputStream;
        OutputStream outputStream;
        InputStream inputStream2;
        Process process;
        OutputStream outputStream2;
        InputStream inputStream3;
        Process process2;
        InputStream inputStream4 = null;
        ArrayList arrayList = new ArrayList(20);
        try {
            Thread start = ThreadMonitor.start(j);
            process = openProcess(strArr);
            try {
                inputStream2 = process.getInputStream();
                try {
                    outputStream = process.getOutputStream();
                    try {
                        inputStream = process.getErrorStream();
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
                            try {
                                for (String readLine = bufferedReader.readLine(); readLine != null && arrayList.size() < i; readLine = bufferedReader.readLine()) {
                                    arrayList.add(readLine.toLowerCase(Locale.ENGLISH).trim());
                                }
                                process.waitFor();
                                ThreadMonitor.stop(start);
                                if (process.exitValue() != 0) {
                                    throw new IOException("Command line returned OS error code '" + process.exitValue() + "' for command " + Arrays.asList(strArr));
                                }
                                if (arrayList.isEmpty()) {
                                    throw new IOException("Command line did not return any info for command " + Arrays.asList(strArr));
                                }
                                IOUtils.closeQuietly(inputStream2);
                                IOUtils.closeQuietly(outputStream);
                                IOUtils.closeQuietly(inputStream);
                                IOUtils.closeQuietly((Reader) bufferedReader);
                                if (process != null) {
                                    process.destroy();
                                }
                                return arrayList;
                            } catch (InterruptedException e) {
                                e = e;
                                inputStream4 = inputStream;
                                outputStream2 = outputStream;
                                inputStream3 = inputStream2;
                                process2 = process;
                                try {
                                    throw new IOExceptionWithCause("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j, e);
                                } catch (Throwable th) {
                                    th = th;
                                    process = process2;
                                    inputStream2 = inputStream3;
                                    outputStream = outputStream2;
                                    inputStream = inputStream4;
                                    IOUtils.closeQuietly(inputStream2);
                                    IOUtils.closeQuietly(outputStream);
                                    IOUtils.closeQuietly(inputStream);
                                    IOUtils.closeQuietly((Reader) bufferedReader);
                                    if (process != null) {
                                        process.destroy();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                IOUtils.closeQuietly(inputStream2);
                                IOUtils.closeQuietly(outputStream);
                                IOUtils.closeQuietly(inputStream);
                                IOUtils.closeQuietly((Reader) bufferedReader);
                                if (process != null) {
                                }
                                throw th;
                            }
                        } catch (InterruptedException e2) {
                            e = e2;
                            bufferedReader = null;
                            inputStream4 = inputStream;
                            outputStream2 = outputStream;
                            inputStream3 = inputStream2;
                            process2 = process;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = null;
                        }
                    } catch (InterruptedException e3) {
                        e = e3;
                        bufferedReader = null;
                        outputStream2 = outputStream;
                        inputStream3 = inputStream2;
                        process2 = process;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                        inputStream = null;
                    }
                } catch (InterruptedException e4) {
                    e = e4;
                    bufferedReader = null;
                    outputStream2 = null;
                    inputStream3 = inputStream2;
                    process2 = process;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                    inputStream = null;
                    outputStream = null;
                }
            } catch (InterruptedException e5) {
                e = e5;
                bufferedReader = null;
                outputStream2 = null;
                inputStream3 = null;
                process2 = process;
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
                inputStream = null;
                outputStream = null;
                inputStream2 = null;
            }
        } catch (InterruptedException e6) {
            e = e6;
            bufferedReader = null;
            outputStream2 = null;
            inputStream3 = null;
            process2 = null;
        } catch (Throwable th7) {
            th = th7;
            bufferedReader = null;
            inputStream = null;
            outputStream = null;
            inputStream2 = null;
            process = null;
        }
    }

    Process openProcess(String[] strArr) {
        return Runtime.getRuntime().exec(strArr);
    }
}
