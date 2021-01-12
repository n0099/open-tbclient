package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class w {
    private static volatile w c;

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f7603a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f7604b = false;
    private Context d;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.utils.w.1.a():java.util.List<java.lang.String>] */
    static /* synthetic */ Context a(w wVar) {
        return wVar.d;
    }

    public static String a(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && str.contains("?")) {
                    str = str.split("\\?")[0];
                    if (str.endsWith("/")) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
            } catch (Throwable th) {
            }
        }
        return a(context).a(str);
    }

    static w a(Context context) {
        if (c == null) {
            synchronized (w.class) {
                if (c == null) {
                    c = new w(context);
                }
            }
        }
        return c;
    }

    private w(Context context) {
        if (context != null && this.d == null) {
            this.d = context.getApplicationContext();
            a();
        }
        this.d = context;
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String d = d(str);
        if (TextUtils.isEmpty(d)) {
            return null;
        }
        return b(d);
    }

    private static String b(String str) {
        int indexOf = str.indexOf(47);
        int indexOf2 = str.indexOf(59);
        if (indexOf < 0) {
            return null;
        }
        String lowerCase = str.substring(0, indexOf).trim().toLowerCase(Locale.ENGLISH);
        if (c(lowerCase)) {
            String lowerCase2 = (indexOf2 < 0 ? str.substring(indexOf + 1) : str.substring(indexOf + 1, indexOf2)).trim().toLowerCase(Locale.ENGLISH);
            if (c(lowerCase2)) {
                StringBuilder sb = new StringBuilder(lowerCase.length() + lowerCase2.length() + 1);
                sb.append(lowerCase);
                sb.append('/');
                sb.append(lowerCase2);
                return sb.toString();
            }
            return null;
        }
        return null;
    }

    private static boolean a(char c2) {
        return c2 > ' ' && c2 < 127 && "()<>@,;:/[]?=\\\"".indexOf(c2) < 0;
    }

    private static boolean c(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!a(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private String d(String str) {
        String str2;
        String e = e(str);
        if (e.isEmpty()) {
            return null;
        }
        a();
        if (this.f7603a == null || this.f7603a.isEmpty()) {
            return null;
        }
        String str3 = e;
        do {
            str2 = this.f7603a.get(str3);
            if (str2 == null) {
                str3 = e(str3);
            }
            if (str2 != null) {
                return str2;
            }
        } while (!str3.isEmpty());
        return str2;
    }

    private static String e(String str) {
        int indexOf;
        if (str == null || str.isEmpty() || (indexOf = str.indexOf(46)) < 0 || indexOf >= str.length() - 1) {
            return "";
        }
        return str.substring(indexOf + 1);
    }

    private void a() {
        if (this.d != null && !this.f7604b) {
            synchronized (this) {
                if (!this.f7604b) {
                    List list = (List) AccessController.doPrivileged(new PrivilegedAction<List<String>>() { // from class: com.bytedance.sdk.openadsdk.utils.w.1
                        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                            jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
                            	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
                            	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
                            	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
                            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
                            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
                            */
                        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [228=4] */
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.security.PrivilegedAction
                        /* renamed from: a */
                        public java.util.List<java.lang.String> run() {
                            /*
                                r5 = this;
                                r2 = 0
                                java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L6b
                                r0.<init>()     // Catch: java.lang.Throwable -> L6b
                                com.bytedance.sdk.openadsdk.utils.w r1 = com.bytedance.sdk.openadsdk.utils.w.this     // Catch: java.lang.Throwable -> L6b
                                android.content.Context r1 = com.bytedance.sdk.openadsdk.utils.w.a(r1)     // Catch: java.lang.Throwable -> L6b
                                android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L6b
                                java.lang.String r3 = "tt_mime_type.pro"
                                java.io.InputStream r3 = r1.open(r3)     // Catch: java.lang.Throwable -> L6b
                                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6f
                                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L6f
                                r4.<init>(r3)     // Catch: java.lang.Throwable -> L6f
                                r1.<init>(r4)     // Catch: java.lang.Throwable -> L6f
                            L21:
                                java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L31
                                if (r2 == 0) goto L41
                                boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L31
                                if (r4 != 0) goto L21
                                r0.add(r2)     // Catch: java.lang.Throwable -> L31
                                goto L21
                            L31:
                                r0 = move-exception
                            L32:
                                java.util.List r0 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> L69
                                if (r3 == 0) goto L3b
                                r3.close()     // Catch: java.lang.Throwable -> L5e
                            L3b:
                                if (r1 == 0) goto L40
                                r1.close()     // Catch: java.lang.Throwable -> L60
                            L40:
                                return r0
                            L41:
                                if (r3 == 0) goto L46
                                r3.close()     // Catch: java.lang.Throwable -> L5c
                            L46:
                                if (r1 == 0) goto L40
                                r1.close()     // Catch: java.lang.Throwable -> L4c
                                goto L40
                            L4c:
                                r1 = move-exception
                                goto L40
                            L4e:
                                r0 = move-exception
                                r1 = r2
                                r3 = r2
                            L51:
                                if (r3 == 0) goto L56
                                r3.close()     // Catch: java.lang.Throwable -> L62
                            L56:
                                if (r1 == 0) goto L5b
                                r1.close()     // Catch: java.lang.Throwable -> L64
                            L5b:
                                throw r0
                            L5c:
                                r2 = move-exception
                                goto L46
                            L5e:
                                r2 = move-exception
                                goto L3b
                            L60:
                                r1 = move-exception
                                goto L40
                            L62:
                                r2 = move-exception
                                goto L56
                            L64:
                                r1 = move-exception
                                goto L5b
                            L66:
                                r0 = move-exception
                                r1 = r2
                                goto L51
                            L69:
                                r0 = move-exception
                                goto L51
                            L6b:
                                r0 = move-exception
                                r1 = r2
                                r3 = r2
                                goto L32
                            L6f:
                                r0 = move-exception
                                r1 = r2
                                goto L32
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.w.AnonymousClass1.run():java.util.List");
                        }
                    });
                    this.f7603a = new HashMap(list.size());
                    String str = "";
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        String str2 = str + ((String) it.next());
                        if (str2.endsWith(IStringUtil.WINDOWS_FOLDER_SEPARATOR)) {
                            str = str2.substring(0, str2.length() - 1);
                        } else {
                            f(str2);
                            str = "";
                        }
                    }
                    if (!str.isEmpty()) {
                        f(str);
                    }
                    this.f7604b = true;
                }
            }
        }
    }

    private void f(String str) {
        String trim = str.trim();
        if (!trim.isEmpty() && trim.charAt(0) != '#') {
            String replaceAll = trim.replaceAll("\\s*#.*", "");
            if (replaceAll.indexOf(61) > 0) {
                Matcher matcher = Pattern.compile("\\btype=(\"\\p{Graph}+?/\\p{Graph}+?\"|\\p{Graph}+/\\p{Graph}+\\b)").matcher(replaceAll);
                if (matcher.find()) {
                    String substring = matcher.group().substring("type=".length());
                    if (substring.charAt(0) == '\"') {
                        substring = substring.substring(1, substring.length() - 1);
                    }
                    Matcher matcher2 = Pattern.compile("\\bexts=(\"[\\p{Graph}|\\p{Blank}]+?\"|\\p{Graph}+\\b)").matcher(replaceAll);
                    if (matcher2.find()) {
                        String substring2 = matcher2.group().substring("exts=".length());
                        if (substring2.charAt(0) == '\"') {
                            substring2 = substring2.substring(1, substring2.length() - 1);
                        }
                        String[] split = substring2.split("[\\p{Blank}|\\p{Punct}]+");
                        for (String str2 : split) {
                            a(str2, substring);
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            String[] split2 = replaceAll.split("\\s+");
            for (int i = 1; i < split2.length; i++) {
                a(split2[i], split2[0]);
            }
        }
    }

    private void a(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty() && !this.f7603a.containsKey(str)) {
            this.f7603a.put(str, str2);
        }
    }
}
