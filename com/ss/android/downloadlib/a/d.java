package com.ss.android.downloadlib.a;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    private static b qbK;
    private static c qbL;

    public static com.ss.android.socialbase.downloader.downloader.i aaU(String str) {
        if (qbK == null) {
            qbK = new b(j.i());
        }
        return new a(qbK, str);
    }

    public static com.ss.android.socialbase.downloader.downloader.h eEH() {
        if (qbL == null) {
            qbL = new c(j.i());
        }
        return qbL;
    }

    public static com.ss.android.socialbase.downloader.downloader.i B(String str, JSONObject jSONObject) {
        return (jSONObject == null || !jSONObject.has("download_chunk_config") || com.ss.android.socialbase.downloader.k.a.g("download_chunk_config")) ? aaU(str) : ff(jSONObject);
    }

    public static com.ss.android.socialbase.downloader.downloader.h fe(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("download_chunk_config") || com.ss.android.socialbase.downloader.k.a.g("download_chunk_config")) {
            return null;
        }
        return fg(jSONObject);
    }

    public static com.ss.android.socialbase.downloader.downloader.i ff(JSONObject jSONObject) {
        return new b(jSONObject);
    }

    public static com.ss.android.socialbase.downloader.downloader.h fg(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class c implements com.ss.android.socialbase.downloader.downloader.h {

        /* renamed from: a  reason: collision with root package name */
        private int f12953a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<int[]> f12954b = new ArrayList<>();

        public c(JSONObject jSONObject) {
            a(jSONObject);
        }

        private void a(JSONObject jSONObject) {
            this.f12953a = jSONObject.optInt("is_open_exp", 0);
            b(jSONObject);
        }

        private void b(JSONObject jSONObject) {
            JSONObject jSONObject2;
            if (jSONObject != null && jSONObject.has("download_chunk_config")) {
                String obj = jSONObject.opt("download_chunk_config").toString();
                if (!TextUtils.isEmpty(obj)) {
                    try {
                        jSONObject2 = new JSONObject(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("network_quality_operation");
                        String optString2 = jSONObject2.optString("network_quality_operand");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            try {
                                String[] split = optString.split(",");
                                String[] split2 = optString2.split(",");
                                if (split.length >= 5 && split2.length >= 5) {
                                    for (int i = 0; i < 5; i++) {
                                        this.f12954b.add(new int[]{Integer.parseInt(split[i]), Integer.parseInt(split2[i])});
                                    }
                                }
                            } catch (Throwable th) {
                            }
                        }
                    }
                }
            }
        }

        @Override // com.ss.android.socialbase.downloader.downloader.h
        public int a(int i, com.ss.android.socialbase.downloader.i.k kVar) {
            if (a()) {
                return b(i, kVar);
            }
            return i;
        }

        boolean a() {
            return this.f12953a == 2 || this.f12953a == 3;
        }

        private int b(int i, com.ss.android.socialbase.downloader.i.k kVar) {
            int i2;
            if (this.f12954b.size() >= 5) {
                int[] iArr = null;
                switch (kVar) {
                    case POOR:
                        iArr = this.f12954b.get(0);
                        break;
                    case MODERATE:
                        iArr = this.f12954b.get(1);
                        break;
                    case GOOD:
                        iArr = this.f12954b.get(2);
                        break;
                    case EXCELLENT:
                        iArr = this.f12954b.get(3);
                        break;
                    case UNKNOWN:
                        iArr = this.f12954b.get(4);
                        break;
                }
                if (iArr != null && iArr.length >= 2) {
                    switch (iArr[0]) {
                        case 1:
                            i2 = iArr[1] + i;
                            break;
                        case 2:
                            i2 = i - iArr[1];
                            break;
                        case 3:
                            i2 = iArr[1];
                            break;
                        default:
                            i2 = i;
                            break;
                    }
                    if (i2 <= 1) {
                        i2 = 1;
                    }
                    return i2;
                }
                return i;
            }
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class b implements com.ss.android.socialbase.downloader.downloader.i {

        /* renamed from: a  reason: collision with root package name */
        private int f12951a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<int[]> f12952b = new ArrayList<>();

        public b(JSONObject jSONObject) {
            a(jSONObject);
        }

        private void a(JSONObject jSONObject) {
            this.f12951a = jSONObject.optInt("is_open_exp", 0);
            b(jSONObject);
        }

        @Override // com.ss.android.socialbase.downloader.downloader.i
        public int a(long j) {
            if (a() && b(j)) {
                return a((int) (j / 1048576));
            }
            return 1;
        }

        protected boolean b(long j) {
            return true;
        }

        public boolean a() {
            return this.f12951a == 1 || this.f12951a == 3;
        }

        private void b(JSONObject jSONObject) {
            JSONObject jSONObject2;
            if (jSONObject != null && jSONObject.has("download_chunk_config")) {
                String obj = jSONObject.opt("download_chunk_config").toString();
                if (!TextUtils.isEmpty(obj)) {
                    try {
                        jSONObject2 = new JSONObject(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null) {
                        String[] strArr = new String[5];
                        String[][] strArr2 = new String[5];
                        strArr[1] = jSONObject2.optString("download_chunk_1");
                        strArr[2] = jSONObject2.optString("download_chunk_2");
                        strArr[3] = jSONObject2.optString("download_chunk_3");
                        strArr[4] = jSONObject2.optString("download_chunk_4");
                        for (int i = 1; i < 5; i++) {
                            if (!TextUtils.isEmpty(strArr[i])) {
                                try {
                                    strArr2[i] = strArr[i].split(",");
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                for (int i2 = 0; i2 < strArr2[i].length - 1; i2 += 2) {
                                    try {
                                        this.f12952b.add(new int[]{i, Integer.parseInt(strArr2[i][i2]), Integer.parseInt(strArr2[i][i2 + 1])});
                                    } catch (Throwable th2) {
                                        th2.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        private int a(int i) {
            for (int i2 = 0; i2 < this.f12952b.size(); i2++) {
                int[] iArr = this.f12952b.get(i2);
                if (i >= iArr[1] && i < iArr[2]) {
                    return iArr[0];
                }
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements com.ss.android.socialbase.downloader.downloader.i {

        /* renamed from: a  reason: collision with root package name */
        private final String f12949a;
        private b qbM;

        public a(b bVar, String str) {
            this.qbM = bVar;
            this.f12949a = str;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.i
        public int a(long j) {
            if (!com.ss.android.downloadlib.f.i.c(this.f12949a) || this.qbM == null) {
                return 1;
            }
            return this.qbM.a(j);
        }
    }
}
