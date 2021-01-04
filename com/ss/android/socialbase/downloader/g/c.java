package com.ss.android.socialbase.downloader.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.ss.android.socialbase.downloader.b.g;
import com.ss.android.socialbase.downloader.b.i;
import com.ss.android.socialbase.downloader.d.s;
import com.ss.android.socialbase.downloader.downloader.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.ss.android.socialbase.downloader.g.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ar */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Sy */
        public c[] newArray(int i) {
            return new c[i];
        }
    };
    private boolean A;
    private String B;
    private boolean C;
    private boolean D;
    private String E;
    private int F;
    private i G;
    private boolean H;
    private com.ss.android.socialbase.downloader.b.a I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private String N;
    private boolean O;
    private String P;
    private int Q;
    private int R;
    private int S;
    private AtomicLong T;
    private long U;
    private AtomicInteger V;
    private boolean W;
    private boolean X;
    private long Y;
    private long Z;

    /* renamed from: a  reason: collision with root package name */
    private int f13452a;
    private com.ss.android.socialbase.downloader.e.a aA;
    @Deprecated
    private int aB;
    private JSONObject aC;
    private JSONObject aD;
    private String aE;
    private Bundle aF;
    private boolean aG;
    private boolean aa;
    private boolean ab;
    private long ac;
    private long ad;
    private StringBuffer ae;
    private int af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private List<String> aj;
    private com.ss.android.socialbase.downloader.b.b ak;
    private g al;
    private String am;
    private int an;
    private String ao;
    private AtomicLong ap;
    private volatile boolean aq;
    private volatile List<s> ar;
    private boolean as;
    private int at;
    private long au;
    private boolean av;
    private boolean aw;
    private boolean ax;
    private boolean ay;
    private String az;

    /* renamed from: b  reason: collision with root package name */
    private String f13453b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private String h;
    private List<e> i;
    private int j;
    private String[] k;
    private int[] l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private List<String> s;
    private boolean t;
    private String u;
    private boolean v;
    private String w;
    private String x;
    private String y;
    private AtomicLong z;

    public c() {
        this.C = true;
        this.G = i.DELAY_RETRY_NONE;
        this.H = false;
        this.I = com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_NONE;
        this.M = true;
        this.S = 1;
        this.W = true;
        this.X = true;
        this.ak = com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_NONE;
        this.al = g.ENQUEUE_NONE;
        this.ap = new AtomicLong(0L);
        this.av = true;
    }

    private c(a aVar) {
        this.C = true;
        this.G = i.DELAY_RETRY_NONE;
        this.H = false;
        this.I = com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_NONE;
        this.M = true;
        this.S = 1;
        this.W = true;
        this.X = true;
        this.ak = com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_NONE;
        this.al = g.ENQUEUE_NONE;
        this.ap = new AtomicLong(0L);
        this.av = true;
        if (aVar == null) {
            return;
        }
        this.f13453b = aVar.f13454a;
        this.c = aVar.f13455b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.V = new AtomicInteger(0);
        this.T = new AtomicLong(0L);
        this.h = aVar.g;
        this.g = aVar.f;
        this.i = aVar.h;
        this.j = aVar.i;
        this.m = aVar.l;
        this.n = aVar.m;
        this.o = aVar.n;
        this.k = aVar.pYG;
        this.l = aVar.k;
        this.p = aVar.o;
        this.q = aVar.p;
        this.r = aVar.q;
        this.s = aVar.r;
        this.t = aVar.s;
        this.u = aVar.t;
        this.v = aVar.u;
        this.A = aVar.C;
        this.B = aVar.D;
        this.ag = aVar.v;
        this.ah = aVar.w;
        this.C = aVar.x;
        this.D = aVar.y;
        this.w = aVar.z;
        this.y = aVar.A;
        this.H = aVar.E;
        this.L = aVar.F;
        this.al = aVar.pYH;
        this.J = aVar.H;
        this.K = aVar.I;
        this.av = aVar.M;
        this.aw = aVar.N;
        this.ax = aVar.J;
        this.N = aVar.K;
        this.au = aVar.L;
        JSONObject jSONObject = aVar.pYI;
        if (jSONObject != null) {
            a("download_setting", jSONObject.toString());
        }
        a("dbjson_key_expect_file_length", Long.valueOf(aVar.B));
        a("executor_group", Integer.valueOf(aVar.P));
    }

    public void a(Parcel parcel) {
        this.f13452a = parcel.readInt();
        this.f13453b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readByte() != 0;
        this.h = parcel.readString();
        this.i = parcel.createTypedArrayList(e.CREATOR);
        this.j = parcel.readInt();
        this.k = parcel.createStringArray();
        this.l = parcel.createIntArray();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readByte() != 0;
        this.p = parcel.readByte() != 0;
        this.q = parcel.readInt();
        this.r = parcel.readInt();
        this.s = parcel.createStringArrayList();
        this.t = parcel.readByte() != 0;
        this.u = parcel.readString();
        this.v = parcel.readByte() != 0;
        this.w = parcel.readString();
        this.y = parcel.readString();
        this.A = parcel.readByte() != 0;
        this.C = parcel.readByte() != 0;
        this.D = parcel.readByte() != 0;
        this.B = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readInt();
        q(parcel.readInt());
        this.H = parcel.readByte() != 0;
        this.O = parcel.readByte() != 0;
        this.P = parcel.readString();
        this.Q = parcel.readInt();
        this.R = parcel.readInt();
        this.S = parcel.readInt();
        d(parcel.readLong());
        this.U = parcel.readLong();
        c(parcel.readInt());
        this.Y = parcel.readLong();
        this.Z = parcel.readLong();
        this.aa = parcel.readByte() != 0;
        this.ab = parcel.readByte() != 0;
        try {
            if (this.ae == null) {
                this.ae = new StringBuffer(parcel.readString());
            } else {
                this.ae.delete(0, this.ae.length()).append(parcel.readString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ag = parcel.readByte() != 0;
        this.ah = parcel.readByte() != 0;
        this.ai = parcel.readByte() != 0;
        this.aj = parcel.createStringArrayList();
        this.L = parcel.readByte() != 0;
        p(parcel.readInt());
        this.J = parcel.readByte() != 0;
        this.an = parcel.readInt();
        this.ao = parcel.readString();
        this.aq = parcel.readByte() != 0;
        this.as = parcel.readByte() != 0;
        this.av = parcel.readByte() != 0;
        this.aw = parcel.readByte() != 0;
        this.ax = parcel.readByte() != 0;
        this.ay = parcel.readByte() != 0;
        this.aA = (com.ss.android.socialbase.downloader.e.a) parcel.readParcelable(com.ss.android.socialbase.downloader.e.a.class.getClassLoader());
        this.aB = parcel.readInt();
        this.aE = parcel.readString();
        this.M = parcel.readByte() != 0;
        this.N = parcel.readString();
        this.at = parcel.readInt();
    }

    private String eHJ() {
        if (this.az == null && this.s != null && !this.s.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.s) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                this.az = jSONArray.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.az == null) {
            this.az = "";
        }
        return this.az;
    }

    private void k(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.az = str;
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String optString = jSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    this.s = arrayList;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean a() {
        long j = this.ap.get();
        return j == 0 || SystemClock.uptimeMillis() - j > 20;
    }

    public void b() {
        this.ap.set(SystemClock.uptimeMillis());
    }

    public String c() {
        return this.am;
    }

    public void a(String str) {
        this.am = str;
    }

    protected c(Parcel parcel) {
        this.C = true;
        this.G = i.DELAY_RETRY_NONE;
        this.H = false;
        this.I = com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_NONE;
        this.M = true;
        this.S = 1;
        this.W = true;
        this.X = true;
        this.ak = com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_NONE;
        this.al = g.ENQUEUE_NONE;
        this.ap = new AtomicLong(0L);
        this.av = true;
        a(parcel);
    }

    private void p(int i) {
        if (i == g.ENQUEUE_HEAD.ordinal()) {
            this.al = g.ENQUEUE_HEAD;
        } else if (i == g.ENQUEUE_TAIL.ordinal()) {
            this.al = g.ENQUEUE_TAIL;
        } else {
            this.al = g.ENQUEUE_NONE;
        }
    }

    private void q(int i) {
        if (i == i.DELAY_RETRY_WAITING.ordinal()) {
            this.G = i.DELAY_RETRY_WAITING;
        } else if (i == i.DELAY_RETRY_DOWNLOADING.ordinal()) {
            this.G = i.DELAY_RETRY_DOWNLOADING;
        } else if (i == i.DELAY_RETRY_DOWNLOADED.ordinal()) {
            this.G = i.DELAY_RETRY_DOWNLOADED;
        } else {
            this.G = i.DELAY_RETRY_NONE;
        }
    }

    public String d() {
        return (this.ae == null || this.ae.length() == 0) ? "" : this.ae.toString();
    }

    public c(Cursor cursor) {
        this.C = true;
        this.G = i.DELAY_RETRY_NONE;
        this.H = false;
        this.I = com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_NONE;
        this.M = true;
        this.S = 1;
        this.W = true;
        this.X = true;
        this.ak = com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_NONE;
        this.al = g.ENQUEUE_NONE;
        this.ap = new AtomicLong(0L);
        this.av = true;
        if (cursor != null) {
            try {
                int columnIndex = cursor.getColumnIndex(IMConstants.MSG_ROW_ID);
                if (columnIndex != -1) {
                    this.f13452a = cursor.getInt(columnIndex);
                }
                int columnIndex2 = cursor.getColumnIndex("name");
                if (columnIndex2 != -1) {
                    this.f13453b = cursor.getString(columnIndex2);
                }
                int columnIndex3 = cursor.getColumnIndex("title");
                if (columnIndex3 != -1) {
                    this.c = cursor.getString(columnIndex3);
                }
                int columnIndex4 = cursor.getColumnIndex("url");
                if (columnIndex4 != -1) {
                    this.d = cursor.getString(columnIndex4);
                }
                int columnIndex5 = cursor.getColumnIndex("savePath");
                if (columnIndex5 != -1) {
                    this.e = cursor.getString(columnIndex5);
                }
                int columnIndex6 = cursor.getColumnIndex("tempPath");
                if (columnIndex6 != -1) {
                    this.f = cursor.getString(columnIndex6);
                }
                int columnIndex7 = cursor.getColumnIndex("chunkCount");
                if (columnIndex7 != -1) {
                    this.S = cursor.getInt(columnIndex7);
                }
                int columnIndex8 = cursor.getColumnIndex("status");
                if (columnIndex8 != -1) {
                    this.V = new AtomicInteger(cursor.getInt(columnIndex8));
                } else {
                    this.V = new AtomicInteger(0);
                }
                int columnIndex9 = cursor.getColumnIndex("curBytes");
                if (columnIndex9 != -1) {
                    this.T = new AtomicLong(cursor.getLong(columnIndex9));
                } else {
                    this.T = new AtomicLong(0L);
                }
                int columnIndex10 = cursor.getColumnIndex("totalBytes");
                if (columnIndex10 != -1) {
                    this.U = cursor.getLong(columnIndex10);
                }
                int columnIndex11 = cursor.getColumnIndex("eTag");
                if (columnIndex11 != -1) {
                    this.E = cursor.getString(columnIndex11);
                }
                int columnIndex12 = cursor.getColumnIndex("onlyWifi");
                if (columnIndex12 != -1) {
                    this.g = cursor.getInt(columnIndex12) != 0;
                }
                int columnIndex13 = cursor.getColumnIndex("force");
                if (columnIndex13 != -1) {
                    this.o = cursor.getInt(columnIndex13) != 0;
                }
                int columnIndex14 = cursor.getColumnIndex("retryCount");
                if (columnIndex14 != -1) {
                    this.m = cursor.getInt(columnIndex14);
                }
                int columnIndex15 = cursor.getColumnIndex("extra");
                if (columnIndex15 != -1) {
                    this.h = cursor.getString(columnIndex15);
                }
                int columnIndex16 = cursor.getColumnIndex("mimeType");
                if (columnIndex16 != -1) {
                    this.u = cursor.getString(columnIndex16);
                }
                int columnIndex17 = cursor.getColumnIndex("notificationEnable");
                if (columnIndex17 != -1) {
                    this.t = cursor.getInt(columnIndex17) != 0;
                }
                int columnIndex18 = cursor.getColumnIndex("notificationVisibility");
                if (columnIndex18 != -1) {
                    this.R = cursor.getInt(columnIndex18);
                }
                int columnIndex19 = cursor.getColumnIndex("isFirstDownload");
                if (columnIndex19 != -1) {
                    this.W = cursor.getInt(columnIndex19) == 1;
                }
                int columnIndex20 = cursor.getColumnIndex("isFirstSuccess");
                if (columnIndex20 != -1) {
                    this.X = cursor.getInt(columnIndex20) == 1;
                }
                int columnIndex21 = cursor.getColumnIndex("needHttpsToHttpRetry");
                if (columnIndex21 != -1) {
                    this.v = cursor.getInt(columnIndex21) == 1;
                }
                int columnIndex22 = cursor.getColumnIndex("downloadTime");
                if (columnIndex22 != -1) {
                    this.Y = cursor.getLong(columnIndex22);
                }
                int columnIndex23 = cursor.getColumnIndex("packageName");
                if (columnIndex23 != -1) {
                    this.w = cursor.getString(columnIndex23);
                }
                int columnIndex24 = cursor.getColumnIndex("md5");
                if (columnIndex24 != -1) {
                    this.y = cursor.getString(columnIndex24);
                }
                int columnIndex25 = cursor.getColumnIndex("retryDelay");
                if (columnIndex25 != -1) {
                    this.A = cursor.getInt(columnIndex25) == 1;
                }
                int columnIndex26 = cursor.getColumnIndex("curRetryTime");
                if (columnIndex26 != -1) {
                    this.F = cursor.getInt(columnIndex26);
                }
                int columnIndex27 = cursor.getColumnIndex("retryDelayStatus");
                if (columnIndex27 != -1) {
                    int i = cursor.getInt(columnIndex27);
                    if (i == i.DELAY_RETRY_WAITING.ordinal()) {
                        this.G = i.DELAY_RETRY_WAITING;
                    } else if (i == i.DELAY_RETRY_DOWNLOADING.ordinal()) {
                        this.G = i.DELAY_RETRY_DOWNLOADING;
                    } else if (i == i.DELAY_RETRY_DOWNLOADED.ordinal()) {
                        this.G = i.DELAY_RETRY_DOWNLOADED;
                    } else {
                        this.G = i.DELAY_RETRY_NONE;
                    }
                }
                int columnIndex28 = cursor.getColumnIndex("defaultHttpServiceBackUp");
                if (columnIndex28 != -1) {
                    this.C = cursor.getInt(columnIndex28) == 1;
                }
                int columnIndex29 = cursor.getColumnIndex("chunkRunnableReuse");
                if (columnIndex29 != -1) {
                    this.D = cursor.getInt(columnIndex29) == 1;
                }
                int columnIndex30 = cursor.getColumnIndex("retryDelayTimeArray");
                if (columnIndex30 != -1) {
                    this.B = cursor.getString(columnIndex30);
                }
                int columnIndex31 = cursor.getColumnIndex("chunkDowngradeRetry");
                if (columnIndex31 != -1) {
                    this.ax = cursor.getInt(columnIndex31) == 1;
                }
                int columnIndex32 = cursor.getColumnIndex("backUpUrlsStr");
                if (columnIndex32 != -1) {
                    k(cursor.getString(columnIndex32));
                }
                int columnIndex33 = cursor.getColumnIndex("backUpUrlRetryCount");
                if (columnIndex33 != -1) {
                    this.n = cursor.getInt(columnIndex33);
                }
                int columnIndex34 = cursor.getColumnIndex("realDownloadTime");
                if (columnIndex34 != -1) {
                    this.Z = cursor.getLong(columnIndex34);
                }
                int columnIndex35 = cursor.getColumnIndex("retryScheduleMinutes");
                if (columnIndex35 != -1) {
                    this.aB = cursor.getInt(columnIndex35);
                }
                int columnIndex36 = cursor.getColumnIndex("independentProcess");
                if (columnIndex36 != -1) {
                    this.L = cursor.getInt(columnIndex36) == 1;
                }
                int columnIndex37 = cursor.getColumnIndex("auxiliaryJsonobjectString");
                if (columnIndex37 != -1) {
                    this.aE = cursor.getString(columnIndex37);
                }
                int columnIndex38 = cursor.getColumnIndex("iconUrl");
                if (columnIndex38 != -1) {
                    this.N = cursor.getString(columnIndex38);
                }
                int columnIndex39 = cursor.getColumnIndex("appVersionCode");
                if (columnIndex39 != -1) {
                    this.at = cursor.getInt(columnIndex39);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ContentValues eHK() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IMConstants.MSG_ROW_ID, Integer.valueOf(this.f13452a));
        contentValues.put("url", this.d);
        contentValues.put("savePath", this.e);
        contentValues.put("tempPath", this.f);
        contentValues.put("name", this.f13453b);
        contentValues.put("chunkCount", Integer.valueOf(this.S));
        contentValues.put("status", Integer.valueOf(q()));
        contentValues.put("curBytes", Long.valueOf(eHV()));
        contentValues.put("totalBytes", Long.valueOf(this.U));
        contentValues.put("eTag", this.E);
        contentValues.put("onlyWifi", Integer.valueOf(this.g ? 1 : 0));
        contentValues.put("force", Integer.valueOf(this.o ? 1 : 0));
        contentValues.put("retryCount", Integer.valueOf(this.m));
        contentValues.put("extra", this.h);
        contentValues.put("mimeType", this.u);
        contentValues.put("title", this.c);
        contentValues.put("notificationEnable", Integer.valueOf(this.t ? 1 : 0));
        contentValues.put("notificationVisibility", Integer.valueOf(this.R));
        contentValues.put("isFirstDownload", Integer.valueOf(this.W ? 1 : 0));
        contentValues.put("isFirstSuccess", Integer.valueOf(this.X ? 1 : 0));
        contentValues.put("needHttpsToHttpRetry", Integer.valueOf(this.v ? 1 : 0));
        contentValues.put("downloadTime", Long.valueOf(this.Y));
        contentValues.put("packageName", this.w);
        contentValues.put("md5", this.y);
        contentValues.put("retryDelay", Integer.valueOf(this.A ? 1 : 0));
        contentValues.put("curRetryTime", Integer.valueOf(this.F));
        contentValues.put("retryDelayStatus", Integer.valueOf(this.G.ordinal()));
        contentValues.put("defaultHttpServiceBackUp", Integer.valueOf(this.C ? 1 : 0));
        contentValues.put("chunkRunnableReuse", Integer.valueOf(this.D ? 1 : 0));
        contentValues.put("retryDelayTimeArray", this.B);
        contentValues.put("chunkDowngradeRetry", Integer.valueOf(this.ax ? 1 : 0));
        contentValues.put("backUpUrlsStr", eHJ());
        contentValues.put("backUpUrlRetryCount", Integer.valueOf(this.n));
        contentValues.put("realDownloadTime", Long.valueOf(this.Z));
        contentValues.put("retryScheduleMinutes", Integer.valueOf(this.aB));
        contentValues.put("independentProcess", Integer.valueOf(this.L ? 1 : 0));
        contentValues.put("auxiliaryJsonobjectString", eHL());
        contentValues.put("iconUrl", this.N);
        contentValues.put("appVersionCode", Integer.valueOf(this.at));
        return contentValues;
    }

    private String eHL() {
        String str;
        if (this.aE != null) {
            return this.aE;
        }
        bC();
        synchronized (this.aD) {
            this.aE = this.aD.toString();
            str = this.aE;
        }
        return str;
    }

    public void b(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            this.af = 0;
            sQLiteStatement.clearBindings();
            int i = this.af + 1;
            this.af = i;
            sQLiteStatement.bindLong(i, this.f13452a);
            int i2 = this.af + 1;
            this.af = i2;
            sQLiteStatement.bindString(i2, this.d == null ? "" : this.d);
            int i3 = this.af + 1;
            this.af = i3;
            sQLiteStatement.bindString(i3, this.e == null ? "" : this.e);
            int i4 = this.af + 1;
            this.af = i4;
            sQLiteStatement.bindString(i4, this.f == null ? "" : this.f);
            int i5 = this.af + 1;
            this.af = i5;
            sQLiteStatement.bindString(i5, this.f13453b == null ? "" : this.f13453b);
            int i6 = this.af + 1;
            this.af = i6;
            sQLiteStatement.bindLong(i6, this.S);
            int i7 = this.af + 1;
            this.af = i7;
            sQLiteStatement.bindLong(i7, q());
            int i8 = this.af + 1;
            this.af = i8;
            sQLiteStatement.bindLong(i8, eHV());
            int i9 = this.af + 1;
            this.af = i9;
            sQLiteStatement.bindLong(i9, this.U);
            int i10 = this.af + 1;
            this.af = i10;
            sQLiteStatement.bindString(i10, this.E == null ? "" : this.E);
            int i11 = this.af + 1;
            this.af = i11;
            sQLiteStatement.bindLong(i11, this.g ? 1L : 0L);
            int i12 = this.af + 1;
            this.af = i12;
            sQLiteStatement.bindLong(i12, this.o ? 1L : 0L);
            int i13 = this.af + 1;
            this.af = i13;
            sQLiteStatement.bindLong(i13, this.m);
            int i14 = this.af + 1;
            this.af = i14;
            sQLiteStatement.bindString(i14, this.h == null ? "" : this.h);
            int i15 = this.af + 1;
            this.af = i15;
            sQLiteStatement.bindString(i15, this.u == null ? "" : this.u);
            int i16 = this.af + 1;
            this.af = i16;
            sQLiteStatement.bindString(i16, this.c == null ? "" : this.c);
            int i17 = this.af + 1;
            this.af = i17;
            sQLiteStatement.bindLong(i17, this.t ? 1L : 0L);
            int i18 = this.af + 1;
            this.af = i18;
            sQLiteStatement.bindLong(i18, this.R);
            int i19 = this.af + 1;
            this.af = i19;
            sQLiteStatement.bindLong(i19, this.W ? 1L : 0L);
            int i20 = this.af + 1;
            this.af = i20;
            sQLiteStatement.bindLong(i20, this.X ? 1L : 0L);
            int i21 = this.af + 1;
            this.af = i21;
            sQLiteStatement.bindLong(i21, this.v ? 1L : 0L);
            int i22 = this.af + 1;
            this.af = i22;
            sQLiteStatement.bindLong(i22, this.Y);
            int i23 = this.af + 1;
            this.af = i23;
            sQLiteStatement.bindString(i23, this.w == null ? "" : this.w);
            int i24 = this.af + 1;
            this.af = i24;
            sQLiteStatement.bindString(i24, this.y == null ? "" : this.y);
            int i25 = this.af + 1;
            this.af = i25;
            sQLiteStatement.bindLong(i25, this.A ? 1L : 0L);
            int i26 = this.af + 1;
            this.af = i26;
            sQLiteStatement.bindLong(i26, this.F);
            int i27 = this.af + 1;
            this.af = i27;
            sQLiteStatement.bindLong(i27, this.G.ordinal());
            int i28 = this.af + 1;
            this.af = i28;
            sQLiteStatement.bindLong(i28, this.C ? 1L : 0L);
            int i29 = this.af + 1;
            this.af = i29;
            sQLiteStatement.bindLong(i29, this.D ? 1L : 0L);
            int i30 = this.af + 1;
            this.af = i30;
            sQLiteStatement.bindString(i30, this.B == null ? "" : this.B);
            int i31 = this.af + 1;
            this.af = i31;
            sQLiteStatement.bindLong(i31, this.ax ? 1L : 0L);
            int i32 = this.af + 1;
            this.af = i32;
            sQLiteStatement.bindString(i32, eHJ());
            int i33 = this.af + 1;
            this.af = i33;
            sQLiteStatement.bindLong(i33, this.n);
            int i34 = this.af + 1;
            this.af = i34;
            sQLiteStatement.bindLong(i34, this.Z);
            int i35 = this.af + 1;
            this.af = i35;
            sQLiteStatement.bindLong(i35, this.aB);
            int i36 = this.af + 1;
            this.af = i36;
            sQLiteStatement.bindLong(i36, this.L ? 1L : 0L);
            int i37 = this.af + 1;
            this.af = i37;
            sQLiteStatement.bindString(i37, eHL());
            int i38 = this.af + 1;
            this.af = i38;
            sQLiteStatement.bindString(i38, this.N == null ? "" : this.N);
            int i39 = this.af + 1;
            this.af = i39;
            sQLiteStatement.bindLong(i39, this.at);
        }
    }

    public int f() {
        return this.af;
    }

    public int g() {
        if (this.f13452a == 0) {
            this.f13452a = com.ss.android.socialbase.downloader.downloader.b.r(this);
        }
        return this.f13452a;
    }

    public String h() {
        return this.f13453b;
    }

    public String i() {
        return TextUtils.isEmpty(this.c) ? this.f13453b : this.c;
    }

    public String j() {
        return this.d;
    }

    public String k() {
        return this.e;
    }

    public String l() {
        return com.ss.android.socialbase.downloader.m.d.b(this.e, this.f);
    }

    public String m() {
        return com.ss.android.socialbase.downloader.m.d.b(this.f13453b);
    }

    public String n() {
        return com.ss.android.socialbase.downloader.m.d.a(this.e, this.f13453b);
    }

    public boolean o() {
        return this.C;
    }

    public boolean p() {
        return this.D;
    }

    public int q() {
        if (this.V != null) {
            int i = this.V.get();
            if (i == -5) {
                return -2;
            }
            return i;
        }
        return 0;
    }

    public g eHM() {
        return this.al;
    }

    public int s() {
        return this.Q;
    }

    public boolean t() {
        return this.ab;
    }

    public boolean u() {
        return this.ag;
    }

    public void a(boolean z) {
        this.ag = z;
    }

    public boolean v() {
        return this.ai;
    }

    public void b(boolean z) {
        this.ai = z;
    }

    public int w() {
        if (this.V != null) {
            return this.V.get();
        }
        return 0;
    }

    public boolean x() {
        return this.g;
    }

    public void c(boolean z) {
        this.g = z;
    }

    public long epL() {
        bC();
        return this.aD.optLong("dbjson_key_first_speed_time");
    }

    public void a(long j) {
        a("dbjson_key_first_speed_time", Long.valueOf(j));
    }

    public int z() {
        bC();
        return this.aD.optInt("ttmd5_check_status", -1);
    }

    public void a(int i) {
        a("ttmd5_check_status", Integer.valueOf(i));
    }

    public long eHN() {
        bC();
        if (this.z == null) {
            this.z = new AtomicLong(this.aD.optLong("dbjson_key_all_connect_time"));
        }
        return this.z.get();
    }

    public void b(long j) {
        if (j > 0) {
            eHN();
            a("dbjson_key_all_connect_time", Long.valueOf(this.z.addAndGet(j)));
        }
    }

    public long eFd() {
        bC();
        return this.aD.optLong("dbjson_key_download_prepare_time");
    }

    public void c(long j) {
        if (j > 0) {
            a("dbjson_key_download_prepare_time", Long.valueOf(eFd() + j));
        }
    }

    public String C() {
        return this.h;
    }

    public String D() {
        return this.w;
    }

    public String E() {
        return this.x;
    }

    public void b(String str) {
        this.x = str;
    }

    public String F() {
        return this.y;
    }

    public long eFe() {
        bC();
        return this.aD.optLong("dbjson_key_expect_file_length");
    }

    public List<e> eHO() {
        return this.i;
    }

    public int I() {
        return this.j;
    }

    public int eHP() {
        return this.m;
    }

    public int K() {
        return this.n;
    }

    public int eHQ() {
        int i = this.m;
        if (this.s != null && !this.s.isEmpty()) {
            return i + (this.n * this.s.size());
        }
        return i;
    }

    public int M() {
        int i = this.F;
        if (this.aa) {
            int i2 = i + this.m;
            if (this.Q > 0) {
                return i2 + (this.Q * this.n);
            }
            return i2;
        }
        return i;
    }

    public List<String> eHR() {
        return this.aj;
    }

    public void a(List<String> list, boolean z) {
        this.aj = list;
        o(z);
    }

    private void o(boolean z) {
        int i = z ? 1 : 0;
        if (this.aj != null && this.aj.size() > i) {
            if (this.s == null) {
                this.s = new ArrayList();
            } else {
                this.s.clear();
            }
            this.aa = false;
            this.Q = 0;
            while (i < this.aj.size()) {
                this.s.add(this.aj.get(i));
                i++;
            }
        }
    }

    public String O() {
        String str = this.d;
        if (q() == 8 && this.aj != null && !this.aj.isEmpty() && !this.aa) {
            return this.aj.get(0);
        }
        if (this.aa && this.s != null && this.s.size() > 0 && this.Q >= 0 && this.Q < this.s.size()) {
            String str2 = this.s.get(this.Q);
            if (TextUtils.isEmpty(str2)) {
                str2 = str;
            }
            return str2;
        } else if (!TextUtils.isEmpty(this.d) && this.d.startsWith("https") && this.v && this.ab) {
            return this.d.replaceFirst("https", HttpHost.DEFAULT_SCHEME_NAME);
        } else {
            return str;
        }
    }

    public boolean P() {
        return this.aa;
    }

    public void Q() {
        this.ac = SystemClock.uptimeMillis();
        a("dbjson_last_start_download_time", Long.valueOf(System.currentTimeMillis()));
    }

    private void a(String str, Object obj) {
        bC();
        synchronized (this.aD) {
            try {
                this.aD.put(str, obj);
            } catch (Exception e) {
            }
            this.aE = null;
        }
    }

    public String R() {
        bC();
        return this.aD.optString("download_setting");
    }

    public int eHS() {
        bC();
        return this.aD.optInt("retry_schedule_count", 0);
    }

    public void b(int i) {
        a("retry_schedule_count", Integer.valueOf(i));
    }

    public boolean T() {
        return this.aG;
    }

    public void d(boolean z) {
        this.aG = z;
    }

    public boolean U() {
        return (eHU() & 2) > 0;
    }

    public boolean V() {
        return (eHU() & 1) > 0;
    }

    public boolean eHT() {
        return w() == -2 || w() == -5;
    }

    private int eHU() {
        bD();
        try {
            return this.aC.optInt("pause_reserve_on_wifi", 0);
        } catch (Exception e) {
            return 0;
        }
    }

    public void X() {
        bD();
        try {
            this.aC.put("pause_reserve_on_wifi", 3);
            eIJ();
        } catch (Exception e) {
        }
    }

    public void Y() {
        bD();
        try {
            this.aC.put("pause_reserve_on_wifi", 1);
            eIJ();
        } catch (Exception e) {
        }
    }

    public void e(boolean z) {
        a("rw_concurrent", Integer.valueOf(z ? 1 : 0));
    }

    public boolean uE() {
        bC();
        return this.aD.optInt("rw_concurrent", 0) == 1;
    }

    public void aa() {
        if (this.ac != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.ac;
            if (this.Y < 0) {
                this.Y = 0L;
            }
            if (uptimeMillis > 0) {
                this.Y = uptimeMillis;
            }
        }
    }

    public void ab() {
        if (this.ad == 0) {
            this.ad = System.nanoTime();
        }
    }

    public void ac() {
        this.ad = 0L;
    }

    public void f(boolean z) {
        long nanoTime = System.nanoTime();
        if (this.ad <= 0) {
            if (z) {
                this.ad = nanoTime;
                return;
            }
            return;
        }
        long j = nanoTime - this.ad;
        if (z) {
            this.ad = nanoTime;
        } else {
            this.ad = 0L;
        }
        if (j > 0) {
            this.Z += j;
        }
    }

    public boolean ad() {
        return this.H;
    }

    public boolean ae() {
        return this.L;
    }

    public boolean af() {
        return this.J;
    }

    public boolean ag() {
        return this.K;
    }

    public boolean ah() {
        return this.av;
    }

    public boolean ai() {
        return this.aw;
    }

    public boolean aj() {
        return this.o;
    }

    public long eHV() {
        if (this.T != null) {
            return this.T.get();
        }
        return 0L;
    }

    public void d(long j) {
        if (this.T != null) {
            this.T.set(j);
        } else {
            this.T = new AtomicLong(j);
        }
    }

    public void a(long j, boolean z) {
        if (z) {
            d(j);
        } else if (j > eHV()) {
            d(j);
        }
    }

    public com.ss.android.socialbase.downloader.b.b eHW() {
        return this.ak;
    }

    public void a(com.ss.android.socialbase.downloader.b.b bVar) {
        this.ak = bVar;
    }

    public void g(boolean z) {
        this.W = z;
    }

    public void h(boolean z) {
        this.X = z;
    }

    public void e(long j) {
        this.T.addAndGet(j);
    }

    public void c(String str) {
        this.E = str;
    }

    public void d(String str) {
        this.f13453b = str;
    }

    public void f(long j) {
        this.U = j;
    }

    public void c(int i) {
        if (this.V != null) {
            this.V.set(i);
        } else {
            this.V = new AtomicInteger(i);
        }
    }

    public void i(boolean z) {
        this.M = z;
    }

    public void e(String str) {
        this.w = str;
    }

    public long ejK() {
        return this.U;
    }

    public String an() {
        return this.E;
    }

    public String eHX() {
        return this.P;
    }

    public void f(String str) {
        this.P = str;
    }

    public void d(int i) {
        this.S = i;
    }

    public int eHY() {
        return this.R;
    }

    public void e(int i) {
        this.R = i;
    }

    public void j(boolean z) {
        this.O = z;
    }

    public int aq() {
        return this.an;
    }

    public void f(int i) {
        this.an = i;
    }

    public void g(String str) {
        this.ao = str;
    }

    public boolean eHZ() {
        return (!this.ag && this.t) || (this.ag && (this.ah || this.ai));
    }

    public void h(String str) {
        this.u = str;
    }

    public boolean ejN() {
        return this.t;
    }

    public String eIa() {
        return this.u;
    }

    public boolean eIb() {
        return this.v;
    }

    public boolean eIc() {
        return this.A;
    }

    public String eId() {
        return this.B;
    }

    public int ax() {
        return this.F;
    }

    public boolean ejS() {
        return this.as;
    }

    public void eIe() {
        this.as = true;
    }

    public String eIf() {
        return this.N;
    }

    public void g(int i) {
        this.at = i;
    }

    public int eIg() {
        return this.at;
    }

    public boolean eIh() {
        return this.ax;
    }

    public boolean eIi() {
        return this.ay;
    }

    public i eIj() {
        return this.G;
    }

    public com.ss.android.socialbase.downloader.b.a eIk() {
        return this.I;
    }

    public boolean eIl() {
        int q = q();
        return q == 7 || this.G == i.DELAY_RETRY_WAITING || q == 8 || this.I == com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_WAITING || this.I == com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_RESTART || this.ak == com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_RESTART;
    }

    public void aH() {
        int q = q();
        if (q == 7 || this.G == i.DELAY_RETRY_WAITING) {
            a(i.DELAY_RETRY_DOWNLOADING);
        }
        if (q == 8 || this.I == com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_WAITING || this.I == com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_RESTART) {
            a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADING);
        }
        if (this.ak == com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_RESTART) {
            a(com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        }
    }

    public boolean eIm() {
        return this.A && q() != -3 && this.G == i.DELAY_RETRY_WAITING;
    }

    public void a(i iVar) {
        this.G = iVar;
    }

    public boolean eIn() {
        return q() != -3 && this.I == com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_WAITING;
    }

    public void a(com.ss.android.socialbase.downloader.b.a aVar) {
        this.I = aVar;
    }

    public void h(int i) {
        this.F = (this.aa ? this.n : this.m) - i;
        if (this.F < 0) {
            this.F = 0;
        }
    }

    public long eIo() {
        return this.Y;
    }

    public long eIp() {
        return TimeUnit.NANOSECONDS.toMillis(this.Z);
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            d(cVar.eIH());
            f(cVar.ejK());
            a(cVar.eHV(), true);
            this.Z = cVar.Z;
            if (!cVar.eIl() && !eIl()) {
                this.F = 0;
                this.as = false;
                this.aa = false;
                this.Q = 0;
                this.ab = false;
            } else {
                this.F = cVar.ax();
            }
            c(cVar.an());
            if (z) {
                c(cVar.q());
            }
            this.W = cVar.eIq();
            this.X = cVar.eIr();
            this.G = cVar.eIj();
            a(cVar.aD);
        }
    }

    private void bC() {
        if (this.aD == null) {
            synchronized (this) {
                if (this.aD == null) {
                    try {
                        if (!TextUtils.isEmpty(this.aE)) {
                            this.aD = new JSONObject(this.aE);
                        } else {
                            this.aD = new JSONObject();
                        }
                    } catch (Exception e) {
                        this.aD = new JSONObject();
                    }
                }
            }
        }
    }

    public void i(String str) {
        this.y = str;
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            bC();
            synchronized (this.aD) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object opt = jSONObject.opt(next);
                        if (!this.aD.has(next) && opt != null) {
                            this.aD.put(next, opt);
                        }
                    }
                } catch (Exception e) {
                }
                this.aE = null;
            }
        }
    }

    public boolean eIq() {
        return this.W;
    }

    public boolean eIr() {
        return this.X;
    }

    public boolean a(c cVar) {
        return (cVar == null || this.d == null || !this.d.equals(cVar.j()) || this.e == null || !this.e.equals(cVar.k())) ? false : true;
    }

    public void i(int i) {
        this.f13452a = i;
    }

    public boolean eIs() {
        return !x() || com.ss.android.socialbase.downloader.m.d.a(com.ss.android.socialbase.downloader.downloader.b.eHp());
    }

    public boolean eIt() {
        if (this.aG) {
            return U() && com.ss.android.socialbase.downloader.m.d.a(com.ss.android.socialbase.downloader.downloader.b.eHp());
        }
        return true;
    }

    public boolean aQ() {
        return com.ss.android.socialbase.downloader.b.f.a(q());
    }

    public List<String> eIu() {
        return this.s;
    }

    public boolean eIv() {
        return com.ss.android.socialbase.downloader.m.d.b(this.U);
    }

    public boolean eIw() {
        return this.p;
    }

    public int eIx() {
        return this.q;
    }

    public long jh(long j) {
        int i = this.q;
        if (i <= 0) {
            i = 100;
        }
        long j2 = j / (i + 1);
        if (j2 <= 0) {
            return 1048576L;
        }
        return j2;
    }

    public int eIy() {
        int i = this.r;
        if (i < 1000) {
            return 1000;
        }
        return i;
    }

    public boolean aW() {
        return TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.f13453b) || TextUtils.isEmpty(this.e);
    }

    public boolean aX() {
        return com.ss.android.socialbase.downloader.m.d.c(this);
    }

    public boolean aY() {
        if (this.aa) {
            this.Q++;
        }
        if (this.s == null || this.s.size() == 0 || this.Q < 0) {
            return false;
        }
        while (this.Q < this.s.size()) {
            if (!TextUtils.isEmpty(this.s.get(this.Q))) {
                this.aa = true;
                return true;
            }
            this.Q++;
        }
        return false;
    }

    public boolean aZ() {
        return this.s != null && this.s.size() > 0 && (!this.aa || (this.Q >= 0 && this.Q < this.s.size() + (-1)));
    }

    public boolean ba() {
        return !TextUtils.isEmpty(this.d) && this.d.startsWith("https") && this.v && !this.ab;
    }

    public void k(boolean z) {
        this.ab = z;
    }

    public synchronized void a(s sVar) {
        if (sVar != null) {
            try {
                com.ss.android.socialbase.downloader.f.a.b("DownloadInfo", "registerTempFileSaveCallback");
                if (this.ar == null) {
                    this.ar = new ArrayList();
                }
                if (!this.ar.contains(sVar)) {
                    this.ar.add(sVar);
                }
            } finally {
            }
        }
    }

    public void j(String str) {
        a(0L, true);
        f(0L);
        c(str);
        d(1);
        this.Y = 0L;
        this.ad = 0L;
        this.Z = 0L;
    }

    public void eIz() {
        a(0L, true);
        this.U = 0L;
        this.S = 1;
        this.Y = 0L;
        this.ad = 0L;
        this.Z = 0L;
    }

    public void eIA() {
        a(0L, true);
        this.U = 0L;
        this.S = 1;
        this.Y = 0L;
        this.ad = 0L;
        this.Z = 0L;
        c(0);
        this.F = 0;
        this.W = true;
        this.X = true;
        this.aa = false;
        this.ab = false;
        this.E = null;
        this.aA = null;
        this.aF = null;
        this.aC = null;
        this.aD = null;
        this.aE = null;
        bo();
    }

    public boolean bd() {
        if (aW()) {
            return false;
        }
        File file = new File(l(), m());
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (!exists || isDirectory) {
            return false;
        }
        long length = file.length();
        long eHV = eHV();
        return length > 0 && eHV > 0 && this.U > 0 && this.S > 0 && length >= eHV && length <= this.U && eHV < this.U;
    }

    public boolean eIB() {
        k eHf;
        long j;
        if (this.S > 1 && (eHf = com.ss.android.socialbase.downloader.downloader.b.eHf()) != null) {
            List<b> c = eHf.c(g());
            if (c == null || c.size() != this.S) {
                return false;
            }
            long j2 = 0;
            Iterator<b> it = c.iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                j2 = next != null ? next.o() + j : j;
            }
            if (j != eHV()) {
                d(j);
            }
        }
        return true;
    }

    public synchronized boolean eIC() {
        return this.aq;
    }

    public synchronized void l(boolean z) {
        this.aq = z;
    }

    public synchronized void a(boolean z, com.ss.android.socialbase.downloader.e.a aVar) {
        this.aq = false;
        if (this.ar != null) {
            com.ss.android.socialbase.downloader.f.a.b("DownloadInfo", "handleTempSaveCallback isSuccess " + z + " callback size:" + this.ar.size());
            for (s sVar : this.ar) {
                if (sVar != null) {
                    if (z) {
                        sVar.a();
                    } else {
                        sVar.a(aVar);
                    }
                }
            }
        }
    }

    public void m(boolean z) {
        this.ay = z;
    }

    public boolean eID() {
        if (bd()) {
            return eIB();
        }
        return false;
    }

    public boolean eIE() {
        return (!this.W || TextUtils.isEmpty(l()) || TextUtils.isEmpty(m()) || new File(l(), m()).exists()) ? false : true;
    }

    public int eIF() {
        return com.ss.android.socialbase.downloader.m.d.a(k(), h(), this.y);
    }

    public boolean eIG() {
        int q = q();
        if (q == 4 || q == 3 || q == -1 || q == 5 || q == 8) {
            return true;
        }
        return (q == 1 || q == 2) && eHV() > 0;
    }

    public boolean bk() {
        return q() == 0;
    }

    public int eIH() {
        return this.S;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f13452a);
        parcel.writeString(this.f13453b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeByte((byte) (this.g ? 1 : 0));
        parcel.writeString(this.h);
        parcel.writeTypedList(this.i);
        parcel.writeInt(this.j);
        parcel.writeStringArray(this.k);
        parcel.writeIntArray(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeByte((byte) (this.o ? 1 : 0));
        parcel.writeByte((byte) (this.p ? 1 : 0));
        parcel.writeInt(this.q);
        parcel.writeInt(this.r);
        parcel.writeStringList(this.s);
        parcel.writeByte((byte) (this.t ? 1 : 0));
        parcel.writeString(this.u);
        parcel.writeByte((byte) (this.v ? 1 : 0));
        parcel.writeString(this.w);
        parcel.writeString(this.y);
        parcel.writeByte((byte) (this.A ? 1 : 0));
        parcel.writeByte((byte) (this.C ? 1 : 0));
        parcel.writeByte((byte) (this.D ? 1 : 0));
        parcel.writeString(this.B);
        parcel.writeString(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G.ordinal());
        parcel.writeByte((byte) (this.H ? 1 : 0));
        parcel.writeByte((byte) (this.O ? 1 : 0));
        parcel.writeString(this.P);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
        parcel.writeInt(this.S);
        parcel.writeLong(eHV());
        parcel.writeLong(this.U);
        parcel.writeInt(w());
        parcel.writeLong(this.Y);
        parcel.writeLong(this.Z);
        parcel.writeByte((byte) (this.aa ? 1 : 0));
        parcel.writeByte((byte) (this.ab ? 1 : 0));
        String str = "";
        if (this.ae != null) {
            str = this.ae.toString();
        }
        parcel.writeString(str);
        parcel.writeByte((byte) (this.ag ? 1 : 0));
        parcel.writeByte((byte) (this.ah ? 1 : 0));
        parcel.writeByte((byte) (this.ai ? 1 : 0));
        parcel.writeStringList(this.aj);
        parcel.writeByte((byte) (this.L ? 1 : 0));
        parcel.writeInt(this.al.ordinal());
        parcel.writeByte((byte) (this.J ? 1 : 0));
        parcel.writeInt(this.an);
        parcel.writeString(this.ao);
        parcel.writeByte((byte) (this.aq ? 1 : 0));
        parcel.writeByte((byte) (this.as ? 1 : 0));
        parcel.writeByte((byte) (this.av ? 1 : 0));
        parcel.writeByte((byte) (this.aw ? 1 : 0));
        parcel.writeByte((byte) (this.ax ? 1 : 0));
        parcel.writeByte((byte) (this.ay ? 1 : 0));
        parcel.writeParcelable(this.aA, i);
        parcel.writeInt(this.aB);
        parcel.writeString(eHL());
        parcel.writeByte((byte) (this.M ? 1 : 0));
        parcel.writeString(this.N);
        parcel.writeInt(this.at);
    }

    public com.ss.android.socialbase.downloader.e.a eII() {
        return this.aA;
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
        this.aA = aVar;
    }

    private void bD() {
        if (this.aC == null) {
            Context eHp = com.ss.android.socialbase.downloader.downloader.b.eHp();
            if (eHp != null) {
                String string = eHp.getSharedPreferences("sp_download_info", 0).getString(Long.toString(g()), "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.aC = new JSONObject(string);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (this.aC == null) {
                this.aC = new JSONObject();
            }
        }
    }

    public void eIJ() {
        Context eHp;
        if (this.aC != null && (eHp = com.ss.android.socialbase.downloader.downloader.b.eHp()) != null) {
            eHp.getSharedPreferences("sp_download_info", 0).edit().putString(Integer.toString(g()), this.aC.toString()).apply();
        }
    }

    public void bo() {
        Context eHp = com.ss.android.socialbase.downloader.downloader.b.eHp();
        if (eHp != null) {
            try {
                eHp.getSharedPreferences("sp_download_info", 0).edit().remove(Integer.toString(g())).apply();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public int eIK() {
        bD();
        return this.aC.optInt("failed_resume_count", 0);
    }

    public void j(int i) {
        bD();
        try {
            this.aC.put("failed_resume_count", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long eIL() {
        bD();
        return this.aC.optLong("last_failed_resume_time", 0L);
    }

    public void h(long j) {
        bD();
        try {
            this.aC.put("last_failed_resume_time", j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int eIM() {
        bD();
        return this.aC.optInt("unins_resume_count", 0);
    }

    public void k(int i) {
        bD();
        try {
            this.aC.put("unins_resume_count", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long eIN() {
        bD();
        return this.aC.optLong("last_unins_resume_time", 0L);
    }

    public void iU(long j) {
        bD();
        try {
            this.aC.put("last_unins_resume_time", j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long eIO() {
        bC();
        return this.aD.optLong("dbjson_last_start_download_time", 0L);
    }

    public int ho(int i) {
        bC();
        return this.aD.optInt("anti_hijack_error_code", i);
    }

    public void m(int i) {
        a("anti_hijack_error_code", Integer.valueOf(i));
    }

    public boolean eIP() {
        bC();
        return this.aD.optBoolean("is_save_path_redirected", false);
    }

    public void n(boolean z) {
        a("is_save_path_redirected", Boolean.valueOf(z));
    }

    public String toString() {
        return "DownloadInfo{id=" + this.f13452a + ", name='" + this.f13453b + "', title='" + this.c + "', url='" + this.d + "', savePath='" + this.e + "'}";
    }

    public int eIQ() {
        bC();
        return this.aD.optInt("dbjson_key_preconnect_level", 0);
    }

    public void n(int i) {
        bC();
        a("dbjson_key_preconnect_level", Integer.valueOf(i));
    }

    private void eIR() {
        if (this.aF == null) {
            synchronized (this) {
                if (this.aF == null) {
                    this.aF = new Bundle();
                }
            }
        }
    }

    public Bundle eIS() {
        eIR();
        return this.aF;
    }

    public int eIT() {
        bC();
        return this.aD.optInt("executor_group", 2);
    }

    public void o(int i) {
        a("executor_group", Integer.valueOf(i));
    }

    public void ji(long j) {
        this.au = j;
    }

    public long eIU() {
        return this.au;
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String A;
        private long B;
        private boolean C;
        private String D;
        private boolean E;
        private boolean F;
        private boolean H;
        private boolean I;
        private boolean J;
        private String K;
        private long L;
        private boolean N;
        private int P;

        /* renamed from: a  reason: collision with root package name */
        private String f13454a;

        /* renamed from: b  reason: collision with root package name */
        private String f13455b;
        private String c;
        private String d;
        private String e;
        private boolean f;
        private String g;
        private List<e> h;
        private int i;
        private int[] k;
        private int l;
        private int m;
        private boolean n;
        private int p;
        private String[] pYG;
        private JSONObject pYI;
        private int q;
        private List<String> r;
        private boolean s;
        private String t;
        private boolean u;
        private boolean v;
        private boolean w;
        private boolean y;
        private String z;
        private boolean o = true;
        private boolean x = true;
        private g pYH = g.ENQUEUE_NONE;
        private boolean M = true;

        public a() {
        }

        public a(String str) {
            this.c = str;
        }

        public a abf(String str) {
            this.f13454a = str;
            return this;
        }

        public a abg(String str) {
            this.f13455b = str;
            return this;
        }

        public a abh(String str) {
            this.c = str;
            return this;
        }

        public a abi(String str) {
            this.d = str;
            return this;
        }

        public a abj(String str) {
            this.g = str;
            return this;
        }

        public a BY(boolean z) {
            this.f = z;
            return this;
        }

        public a gY(List<e> list) {
            this.h = list;
            return this;
        }

        public a Sz(int i) {
            this.l = i;
            return this;
        }

        public a SA(int i) {
            this.m = i;
            return this;
        }

        public a BZ(boolean z) {
            this.n = z;
            return this;
        }

        public a SB(int i) {
            this.p = i;
            return this;
        }

        public a SC(int i) {
            this.q = i;
            return this;
        }

        public a gZ(List<String> list) {
            this.r = list;
            return this;
        }

        public a abk(String str) {
            this.t = str;
            return this;
        }

        public a Ca(boolean z) {
            this.u = z;
            return this;
        }

        public a Cb(boolean z) {
            this.s = z;
            return this;
        }

        public a Cc(boolean z) {
            this.v = z;
            return this;
        }

        public a Cd(boolean z) {
            this.w = z;
            return this;
        }

        public a Ce(boolean z) {
            this.x = z;
            return this;
        }

        public a Cf(boolean z) {
            this.y = z;
            return this;
        }

        public a abl(String str) {
            this.z = str;
            return this;
        }

        public a abm(String str) {
            this.A = str;
            return this;
        }

        public a jj(long j) {
            this.B = j;
            return this;
        }

        public a Cg(boolean z) {
            this.C = z;
            return this;
        }

        public a abn(String str) {
            this.D = str;
            return this;
        }

        public a Ch(boolean z) {
            this.E = z;
            return this;
        }

        public a Ci(boolean z) {
            this.F = z;
            return this;
        }

        public a b(g gVar) {
            this.pYH = gVar;
            return this;
        }

        public a Cj(boolean z) {
            this.H = z;
            return this;
        }

        public a Ck(boolean z) {
            this.J = z;
            return this;
        }

        public a fj(JSONObject jSONObject) {
            this.pYI = jSONObject;
            return this;
        }

        public a abo(String str) {
            this.K = str;
            return this;
        }

        public a SD(int i) {
            this.P = i;
            return this;
        }

        public a jk(long j) {
            this.L = j;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }
}
