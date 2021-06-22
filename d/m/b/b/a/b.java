package d.m.b.b.a;

import com.baidu.android.common.others.lang.StringUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final FileFilter f70381a = new a();

    /* loaded from: classes7.dex */
    public static class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, String> d2 = d();
            jSONObject.put("core", e());
            jSONObject.put("hw", c(d2, "Hardware"));
            jSONObject.put("max", b("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            jSONObject.put("min", b("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"));
            jSONObject.put("ft", c(d2, "Features"));
        } catch (Throwable unused) {
        }
        String jSONObject2 = jSONObject.toString();
        return jSONObject2 == null ? StringUtil.EMPTY_ARRAY : jSONObject2.trim();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
        if (r1 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String str2 = null;
        try {
            fileReader = new FileReader(str);
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    str2 = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Throwable unused4) {
                bufferedReader = null;
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
            fileReader = null;
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
        }
        return str2 == null ? "0" : str2.trim();
    }

    public static String c(HashMap<String, String> hashMap, String str) {
        String str2;
        try {
            str2 = hashMap.get(str);
        } catch (Throwable unused) {
            str2 = null;
        }
        return str2 == null ? "" : str2.trim();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
        if (r2 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap<String, String> d() {
        FileReader fileReader;
        HashMap<String, String> hashMap = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        } else {
                            String[] split = readLine.split(":", 2);
                            if (split.length >= 2) {
                                String trim = split[0].trim();
                                String trim2 = split[1].trim();
                                if (hashMap.get(trim) == null) {
                                    hashMap.put(trim, trim2);
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                }
                bufferedReader2.close();
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            fileReader = null;
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
            return hashMap;
        }
    }

    public static int e() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(f70381a).length;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
