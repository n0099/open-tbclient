package d.a.o0.t2.c0;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.INetWorkCore;
import com.baidu.tbadk.core.util.NetWorkState;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.HttpResponse;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.http.BdHttpCancelException;
import d.a.c.e.p.q;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes5.dex */
public class d implements INetWorkCore {

    /* renamed from: d  reason: collision with root package name */
    public static int f64751d = 2097152;

    /* renamed from: a  reason: collision with root package name */
    public final HttpNetContext f64752a;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.t2.c0.m.d f64754c = new d.a.o0.t2.c0.m.d();

    /* renamed from: b  reason: collision with root package name */
    public Context f64753b = TbadkCoreApplication.getInst().getApp();

    /* loaded from: classes5.dex */
    public class a implements d.a.o0.t2.c0.m.j {

        /* renamed from: a  reason: collision with root package name */
        public int f64755a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f64756b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f64757c = 0;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Handler f64758d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f64759e;

        public a(d dVar, Handler handler, int i2) {
            this.f64758d = handler;
            this.f64759e = i2;
        }

        @Override // d.a.o0.t2.c0.m.j
        public void onProgress(int i2, int i3) {
            if (i3 > 0) {
                this.f64755a = i3 / 50;
            }
            int i4 = this.f64756b + (i2 - this.f64757c);
            this.f64756b = i4;
            this.f64757c = i2;
            if (this.f64758d != null) {
                if (i4 > this.f64755a || i2 == i3) {
                    this.f64756b = 0;
                    Handler handler = this.f64758d;
                    handler.sendMessage(handler.obtainMessage(this.f64759e, i2, i3));
                }
            }
        }
    }

    public d(HttpNetContext httpNetContext) {
        this.f64752a = httpNetContext;
        d.a.o0.t2.c0.m.d.n("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        d.a.o0.t2.c0.m.d.l((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? d.a.n0.l.a.f53231a : cookie);
    }

    public final int a(ArrayList<BasicNameValuePair> arrayList, String str) {
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            int compareTo = str.compareTo(arrayList.get(i2).getName());
            if (compareTo < 0) {
                i3 = i2;
                break;
            } else if (compareTo == 0) {
                return -1;
            } else {
                i3 = i2;
                i2++;
            }
        }
        return i2 >= size ? size : i3;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    public final LinkedList<BasicNameValuePair> b() {
        if (this.f64752a != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.f64752a.getRequest().getNetWorkParam().mSeqId)) {
                linkedList.add(new BasicNameValuePair("sid", this.f64752a.getRequest().getNetWorkParam().mSeqId));
            }
            if (!TextUtils.isEmpty(this.f64752a.getRequest().getNetWorkParam().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.f64752a.getRequest().getNetWorkParam().mNetType));
            }
            return linkedList;
        }
        return null;
    }

    public final int c(int i2) {
        if (i2 != 1) {
            if (i2 == 2) {
                return 2;
            }
            if (i2 == 3) {
                return 3;
            }
        }
        return 1;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void cancelNetConnect() {
        this.f64754c.c();
    }

    public void d(String str) {
        this.f64752a.getResponse().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.f64752a.getResponse().mServerErrorCode = errorData.getError_code();
                if (this.f64752a.getResponse().mServerErrorCode == -1) {
                    this.f64752a.getResponse().mErrorString = this.f64753b.getString(R.string.error_unkown_try_again);
                } else if (this.f64752a.getResponse().mServerErrorCode != 0) {
                    this.f64752a.getResponse().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                this.f64752a.getResponse().mErrorString = this.f64753b.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public boolean downloadFile(String str, Handler handler, int i2, int i3, int i4, boolean z) {
        File a2;
        boolean z2 = false;
        try {
            try {
            } catch (Exception e2) {
                this.f64752a.getResponse().mNetErrorCode = -10;
                HttpResponse response = this.f64752a.getResponse();
                response.mErrorString = this.f64753b.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                BdLog.e(e2.getMessage());
            } catch (OutOfMemoryError e3) {
                this.f64752a.getResponse().mNetErrorCode = -15;
                this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.memoryerror);
                BdLog.e(e3.getMessage());
            }
            if (this.f64754c.i()) {
                return false;
            }
            if (z) {
                a2 = new File(str);
            } else {
                a2 = d.a.o0.t2.b.a(str);
            }
            z2 = this.f64754c.d(this.f64752a.getRequest().getNetWorkParam().mUrl, a2.getAbsolutePath(), false, i3, i4, -1, -1, b(), new a(this, handler, i2), true);
            return z2;
        } finally {
            TiebaStatic.net(this.f64752a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0533 A[RETURN] */
    @Override // com.baidu.tbadk.core.util.INetWorkCore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getNetData() {
        Exception exc;
        d.a.o0.t2.c0.m.i iVar;
        SocketTimeoutException socketTimeoutException;
        SocketException socketException;
        OutOfMemoryError outOfMemoryError;
        BdHttpCancelException bdHttpCancelException;
        String str;
        String str2;
        boolean z;
        String str3;
        d.a.o0.t2.c0.m.d.m(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.f64752a.getRequest().getNetWorkParam().mPostData != null && this.f64752a.getRequest().getNetWorkParam().mPostData.size() > 0 && !this.f64752a.getRequest().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.f64752a.getRequest().getNetWorkParam().mUrl);
                if (this.f64752a.getRequest().getNetWorkParam().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.f64752a.getRequest().getNetWorkParam().mUrl.endsWith("?") && !this.f64752a.getRequest().getNetWorkParam().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i2 = 0; i2 < this.f64752a.getRequest().getNetWorkParam().mPostData.size(); i2++) {
                    if (i2 != 0) {
                        sb.append("&");
                    }
                    sb.append(this.f64752a.getRequest().getNetWorkParam().mPostData.get(i2).getName());
                    sb.append("=");
                    sb.append(d.a.c.e.p.k.getUrlEncode(this.f64752a.getRequest().getNetWorkParam().mPostData.get(i2).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.f64752a.getRequest().getNetWorkParam().mUrl;
            }
            str2 = str;
            TbConfig.getDebugSwitch();
            z = (this.f64752a.getRequest().getNetWorkParam().mRequestGzip && !this.f64752a.getRequest().getNetWorkParam().mIsBDImage) || this.f64752a.getRequest().mIsFromCDN;
        } catch (BdHttpCancelException e2) {
            bdHttpCancelException = e2;
            iVar = null;
        } catch (OutOfMemoryError e3) {
            outOfMemoryError = e3;
            iVar = null;
        } catch (SocketException e4) {
            socketException = e4;
            iVar = null;
        } catch (SocketTimeoutException e5) {
            socketTimeoutException = e5;
            iVar = null;
        } catch (Exception e6) {
            exc = e6;
            iVar = null;
        }
        if (!this.f64754c.i()) {
            long time = new Date().getTime();
            this.f64754c.g(str2, z, 5, 100, -1, -1, b());
            d.a.o0.t2.c0.m.g f2 = this.f64754c.f();
            if (f2 == null) {
                return null;
            }
            iVar = f2.b();
            if (f2 != null) {
                try {
                    if (f2.c() != null) {
                        f2.c().size();
                    }
                } catch (BdHttpCancelException e7) {
                    bdHttpCancelException = e7;
                    this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.neterror);
                    HttpResponse response = this.f64752a.getResponse();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f64752a.getResponse().mNetErrorCode);
                    sb2.append("|retryCount:");
                    sb2.append(this.f64752a.getStat().stat != null ? this.f64752a.getStat().stat.f42381e : -1);
                    sb2.append("|");
                    sb2.append(BdHttpCancelException.class);
                    sb2.append("|");
                    sb2.append(bdHttpCancelException.getMessage());
                    response.mException = sb2.toString();
                    this.f64752a.getResponse().mNetErrorCode = -14;
                    if (iVar == null) {
                    }
                } catch (OutOfMemoryError e8) {
                    outOfMemoryError = e8;
                    this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.memoryerror);
                    HttpResponse response2 = this.f64752a.getResponse();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.f64752a.getResponse().mNetErrorCode);
                    sb3.append("|retryCount:");
                    sb3.append(this.f64752a.getStat().stat != null ? this.f64752a.getStat().stat.f42381e : -1);
                    sb3.append("|");
                    sb3.append(outOfMemoryError.getClass());
                    sb3.append("|");
                    sb3.append(outOfMemoryError.getMessage());
                    response2.mException = sb3.toString();
                    this.f64752a.getResponse().mNetErrorCode = -15;
                    BdLog.e(outOfMemoryError.getMessage());
                    TiebaStatic.net(this.f64752a);
                    if (iVar == null) {
                    }
                } catch (SocketException e9) {
                    socketException = e9;
                    this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.neterror);
                    HttpResponse response3 = this.f64752a.getResponse();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(this.f64752a.getResponse().mNetErrorCode);
                    sb4.append("|retryCount:");
                    sb4.append(this.f64752a.getStat().stat != null ? this.f64752a.getStat().stat.f42381e : -1);
                    sb4.append("|");
                    sb4.append(socketException.getClass());
                    sb4.append("|");
                    sb4.append(socketException.getMessage());
                    response3.mException = sb4.toString();
                    this.f64752a.getResponse().mNetErrorCode = -12;
                    TiebaStatic.net(this.f64752a);
                    if (iVar == null) {
                    }
                } catch (SocketTimeoutException e10) {
                    socketTimeoutException = e10;
                    this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.neterror);
                    HttpResponse response4 = this.f64752a.getResponse();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.f64752a.getResponse().mNetErrorCode);
                    sb5.append("|retryCount:");
                    sb5.append(this.f64752a.getStat().stat != null ? this.f64752a.getStat().stat.f42381e : -1);
                    sb5.append("|");
                    sb5.append(socketTimeoutException.getClass());
                    sb5.append("|");
                    sb5.append(socketTimeoutException.getMessage());
                    response4.mException = sb5.toString();
                    this.f64752a.getResponse().mNetErrorCode = -13;
                    TiebaStatic.net(this.f64752a);
                    if (iVar == null) {
                    }
                } catch (Exception e11) {
                    exc = e11;
                    this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.neterror) + " detailException:" + exc.getMessage();
                    HttpResponse response5 = this.f64752a.getResponse();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(this.f64752a.getResponse().mNetErrorCode);
                    sb6.append("|retryCount:");
                    sb6.append(this.f64752a.getStat().stat != null ? this.f64752a.getStat().stat.f42381e : -1);
                    sb6.append("|");
                    sb6.append(exc.getClass());
                    sb6.append("|");
                    sb6.append(exc.getMessage());
                    response5.mException = sb6.toString();
                    this.f64752a.getResponse().mNetErrorCode = -10;
                    BdLog.e(exc.getMessage());
                    TiebaStatic.net(this.f64752a);
                    if (iVar == null) {
                    }
                }
            }
            if (iVar == null) {
                return null;
            }
            this.f64752a.getResponse().mNetErrorCode = iVar.f64836b;
            if (this.f64752a.getResponse().mNetErrorCode != 200) {
                this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.neterror);
                if (this.f64752a.getStat().stat != null && !TextUtils.isEmpty(this.f64752a.getStat().stat.f42384h)) {
                    this.f64752a.getResponse().mException = this.f64752a.getStat().stat.f42384h;
                } else {
                    HttpResponse response6 = this.f64752a.getResponse();
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(this.f64752a.getResponse().mNetErrorCode);
                    sb7.append("|retryCount:");
                    sb7.append(this.f64752a.getStat().stat == null ? -1 : this.f64752a.getStat().stat.f42381e);
                    response6.mException = sb7.toString();
                }
                TiebaStatic.net(this.f64752a);
                return null;
            }
            if (TbadkCoreApplication.getInst().isMainProcess(true) && (str3 = iVar.f64839e) != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (parseInt > f64751d) {
                        this.f64752a.getResponse().mNetErrorCode = -11;
                        TiebaStatic.net(this.f64752a);
                        return null;
                    }
                    int i3 = parseInt * 10;
                    if (i3 > 0) {
                        BdLog.isDebugMode();
                        if (!d.a.n0.a0.c.k().i(i3)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.f64752a.getRequest().getNetWorkParam().mUrl + "], size:" + i3);
                            this.f64752a.getResponse().mNetErrorCode = -16;
                            TiebaStatic.net(this.f64752a);
                            return null;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
            statisticsData.mMode = c(d.a.c.e.p.j.I());
            statisticsData.mSize = this.f64752a.getStat().stat.f42378b;
            statisticsData.mTime = new Date().getTime() - time;
            statisticsData.mTimesNum = this.f64752a.getStat().stat.f42381e;
            statisticsData.mMethod = 2;
            NetWorkState.addStatisticsData(statisticsData);
            NetWorkState.mErrorNums.set(this.f64752a.getStat().stat.f42381e);
            TiebaStatic.net(this.f64752a);
            if (iVar == null) {
                return iVar.f64841g;
            }
            return null;
        }
        throw new BdHttpCancelException();
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String getNetString() {
        byte[] netData = getNetData();
        String str = null;
        if (netData == null || this.f64752a.getResponse().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.f64752a.getRequest().getNetWorkParam().charSet = TextUtils.isEmpty(this.f64752a.getRequest().getNetWorkParam().charSet) ? "UTF-8" : this.f64752a.getRequest().getNetWorkParam().charSet;
            String str2 = new String(netData, 0, netData.length, this.f64752a.getRequest().getNetWorkParam().charSet);
            try {
                d(str2);
                return str2;
            } catch (Exception e2) {
                e = e2;
                str = str2;
                BdLog.e(e.getMessage());
                return str;
            } catch (OutOfMemoryError e3) {
                e = e3;
                str = str2;
                BdLog.e(e.getMessage());
                return str;
            }
        } catch (Exception e4) {
            e = e4;
        } catch (OutOfMemoryError e5) {
            e = e5;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public ArrayList<BasicNameValuePair> getPostData() {
        return this.f64752a.getRequest().getNetWorkParam().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String getSeqId() {
        HttpNetContext httpNetContext = this.f64752a;
        if (httpNetContext != null) {
            return httpNetContext.getRequest().getNetWorkParam().mSeqId;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public boolean isCancel() {
        return this.f64754c.i();
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String postMultiNetData() {
        StringBuilder sb = new StringBuilder(1024);
        for (int i2 = 0; this.f64752a.getRequest().getNetWorkParam().mPostData != null && i2 < this.f64752a.getRequest().getNetWorkParam().mPostData.size(); i2++) {
            BasicNameValuePair basicNameValuePair = this.f64752a.getRequest().getNetWorkParam().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
        }
        if (this.f64752a.getRequest().getNetWorkParam().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", q.c(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        String str = null;
        try {
            if (this.f64754c.i()) {
                return null;
            }
            if (this.f64754c.j(this.f64752a.getRequest().getNetWorkParam().mUrl, this.f64752a.getRequest().getNetWorkParam().mPostData, this.f64752a.getRequest().getNetWorkParam().mRequestGzip, 5, -1, b()) != null) {
                d.a.o0.t2.c0.m.g f2 = this.f64754c.f();
                if (f2 == null) {
                    return null;
                }
                d.a.o0.t2.c0.m.i b2 = f2.b();
                if (f2 != null && f2.c() != null) {
                    f2.c().size();
                }
                this.f64752a.getResponse().mNetErrorCode = b2.f64836b;
                this.f64752a.getResponse().mHeader = b2.f64840f;
                if (this.f64752a.getResponse().mNetErrorCode != 200) {
                    if (this.f64752a.getStat().stat != null && !TextUtils.isEmpty(this.f64752a.getStat().stat.f42384h)) {
                        this.f64752a.getResponse().mException = this.f64752a.getStat().stat.f42384h;
                    } else {
                        HttpResponse response = this.f64752a.getResponse();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.f64752a.getResponse().mNetErrorCode);
                        sb2.append("|retryCount:");
                        sb2.append(this.f64752a.getStat().stat == null ? -1 : this.f64752a.getStat().stat.f42381e);
                        response.mException = sb2.toString();
                    }
                    TiebaStatic.net(this.f64752a);
                    return null;
                } else if (this.f64754c.i()) {
                    return null;
                } else {
                    String str2 = new String(b2.f64841g, StandardCharsets.UTF_8);
                    try {
                        if (this.f64752a.getRequest().getNetWorkParam().mIsBaiduServer && this.f64752a.getRequest().getNetWorkParam().mIsJson) {
                            d(str2);
                        }
                        NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
                        statisticsData.mMode = c(d.a.c.e.p.j.I());
                        statisticsData.mSize = this.f64752a.getStat().stat.f42378b;
                        statisticsData.mTime = this.f64752a.getStat().stat.f42382f;
                        statisticsData.mTimesNum = this.f64752a.getStat().stat.f42381e;
                        statisticsData.mMethod = 1;
                        NetWorkState.addStatisticsData(statisticsData);
                        NetWorkState.mErrorNums.set(this.f64752a.getStat().stat.f42381e);
                        TiebaStatic.net(this.f64752a);
                        return str2;
                    } catch (BdHttpCancelException e2) {
                        e = e2;
                        str = str2;
                        this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.neterror);
                        HttpResponse response2 = this.f64752a.getResponse();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(this.f64752a.getResponse().mNetErrorCode);
                        sb3.append("|retryCount:");
                        sb3.append(this.f64752a.getStat().stat != null ? this.f64752a.getStat().stat.f42381e : -1);
                        sb3.append("|");
                        sb3.append(BdHttpCancelException.class);
                        sb3.append("|");
                        sb3.append(e.getMessage());
                        response2.mException = sb3.toString();
                        this.f64752a.getResponse().mNetErrorCode = -14;
                        return str;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        str = str2;
                        this.f64752a.getResponse().mNetErrorCode = -15;
                        this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.f64752a);
                        return str;
                    } catch (SocketException e4) {
                        e = e4;
                        str = str2;
                        this.f64752a.getResponse().mNetErrorCode = -12;
                        this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.f64752a);
                        return str;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        str = str2;
                        this.f64752a.getResponse().mNetErrorCode = -13;
                        this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.f64752a);
                        return str;
                    } catch (Exception e6) {
                        e = e6;
                        str = str2;
                        this.f64752a.getResponse().mNetErrorCode = -10;
                        HttpResponse response3 = this.f64752a.getResponse();
                        response3.mErrorString = this.f64753b.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.f64752a);
                        return str;
                    } catch (Throwable th) {
                        th = th;
                        str = str2;
                        this.f64752a.getResponse().mNetErrorCode = -10;
                        this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.f64752a);
                        return str;
                    }
                }
            }
            throw new BdHttpCancelException();
        } catch (BdHttpCancelException e7) {
            e = e7;
        } catch (SocketException e8) {
            e = e8;
        } catch (SocketTimeoutException e9) {
            e = e9;
        } catch (Exception e10) {
            e = e10;
        } catch (OutOfMemoryError e11) {
            e = e11;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String postNetData() {
        StringBuilder sb = new StringBuilder(1024);
        for (int i2 = 0; this.f64752a.getRequest().getNetWorkParam().mPostData != null && i2 < this.f64752a.getRequest().getNetWorkParam().mPostData.size(); i2++) {
            BasicNameValuePair basicNameValuePair = this.f64752a.getRequest().getNetWorkParam().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
        }
        if (this.f64752a.getRequest().getNetWorkParam().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", q.c(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        String str = null;
        try {
            if (this.f64754c.i()) {
                return null;
            }
            if (this.f64754c.j(this.f64752a.getRequest().getNetWorkParam().mUrl, this.f64752a.getRequest().getNetWorkParam().mPostData, this.f64752a.getRequest().getNetWorkParam().mRequestGzip, 5, -1, b()) != null) {
                d.a.o0.t2.c0.m.g f2 = this.f64754c.f();
                if (f2 == null) {
                    return null;
                }
                d.a.o0.t2.c0.m.i b2 = f2.b();
                if (f2 != null && f2.c() != null) {
                    f2.c().size();
                }
                this.f64752a.getResponse().mNetErrorCode = b2.f64836b;
                this.f64752a.getResponse().mHeader = b2.f64840f;
                if (this.f64752a.getResponse().mNetErrorCode != 200) {
                    if (this.f64752a.getStat().stat != null && !TextUtils.isEmpty(this.f64752a.getStat().stat.f42384h)) {
                        this.f64752a.getResponse().mException = this.f64752a.getStat().stat.f42384h;
                    } else {
                        HttpResponse response = this.f64752a.getResponse();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.f64752a.getResponse().mNetErrorCode);
                        sb2.append("|retryCount:");
                        sb2.append(this.f64752a.getStat().stat == null ? -1 : this.f64752a.getStat().stat.f42381e);
                        response.mException = sb2.toString();
                    }
                    TiebaStatic.net(this.f64752a);
                    return null;
                } else if (this.f64754c.i()) {
                    return null;
                } else {
                    String str2 = new String(b2.f64841g, StandardCharsets.UTF_8);
                    try {
                        if (this.f64752a.getRequest().getNetWorkParam().mIsBaiduServer && this.f64752a.getRequest().getNetWorkParam().mIsJson) {
                            d(str2);
                        }
                        NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
                        statisticsData.mMode = c(d.a.c.e.p.j.I());
                        statisticsData.mSize = this.f64752a.getStat().stat.f42378b;
                        statisticsData.mTime = this.f64752a.getStat().stat.f42382f;
                        statisticsData.mTimesNum = this.f64752a.getStat().stat.f42381e;
                        statisticsData.mMethod = 1;
                        NetWorkState.addStatisticsData(statisticsData);
                        NetWorkState.mErrorNums.set(this.f64752a.getStat().stat.f42381e);
                        TiebaStatic.net(this.f64752a);
                        return str2;
                    } catch (BdHttpCancelException e2) {
                        e = e2;
                        str = str2;
                        this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.neterror);
                        HttpResponse response2 = this.f64752a.getResponse();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(this.f64752a.getResponse().mNetErrorCode);
                        sb3.append("|retryCount:");
                        sb3.append(this.f64752a.getStat().stat != null ? this.f64752a.getStat().stat.f42381e : -1);
                        sb3.append("|");
                        sb3.append(BdHttpCancelException.class);
                        sb3.append("|");
                        sb3.append(e.getMessage());
                        response2.mException = sb3.toString();
                        this.f64752a.getResponse().mNetErrorCode = -14;
                        return str;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        str = str2;
                        this.f64752a.getResponse().mNetErrorCode = -15;
                        this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.f64752a);
                        return str;
                    } catch (SocketException e4) {
                        e = e4;
                        str = str2;
                        this.f64752a.getResponse().mNetErrorCode = -12;
                        this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.f64752a);
                        return str;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        str = str2;
                        this.f64752a.getResponse().mNetErrorCode = -13;
                        this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.f64752a);
                        return str;
                    } catch (Exception e6) {
                        e = e6;
                        str = str2;
                        this.f64752a.getResponse().mNetErrorCode = -10;
                        HttpResponse response3 = this.f64752a.getResponse();
                        response3.mErrorString = this.f64753b.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.f64752a);
                        return str;
                    } catch (Throwable th) {
                        th = th;
                        str = str2;
                        this.f64752a.getResponse().mNetErrorCode = -10;
                        this.f64752a.getResponse().mErrorString = this.f64753b.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.f64752a);
                        return str;
                    }
                }
            }
            throw new BdHttpCancelException();
        } catch (BdHttpCancelException e7) {
            e = e7;
        } catch (SocketException e8) {
            e = e8;
        } catch (SocketTimeoutException e9) {
            e = e9;
        } catch (Exception e10) {
            e = e10;
        } catch (OutOfMemoryError e11) {
            e = e11;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setCancel() {
        d.a.o0.t2.c0.m.d dVar = this.f64754c;
        if (dVar != null) {
            dVar.k();
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setIsBaiduServer(boolean z) {
        this.f64752a.getRequest().getNetWorkParam().mIsBaiduServer = z;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.f64752a.getRequest().getNetWorkParam().mPostData != null) {
            this.f64752a.getRequest().getNetWorkParam().mPostData.clear();
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            addPostData(arrayList.get(i2));
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair == null || basicNameValuePair.getName() == null) {
            return;
        }
        if (this.f64752a.getRequest().getNetWorkParam().mPostData == null) {
            this.f64752a.getRequest().getNetWorkParam().mPostData = new ArrayList<>();
        }
        int a2 = a(this.f64752a.getRequest().getNetWorkParam().mPostData, basicNameValuePair.getName());
        int size = this.f64752a.getRequest().getNetWorkParam().mPostData.size();
        if (a2 < 0 || a2 >= size) {
            if (a2 == size) {
                this.f64752a.getRequest().getNetWorkParam().mPostData.add(a2, basicNameValuePair);
            }
        } else if (basicNameValuePair.getName().equals(this.f64752a.getRequest().getNetWorkParam().mPostData.get(a2).getName())) {
            this.f64752a.getRequest().getNetWorkParam().mPostData.set(a2, basicNameValuePair);
        } else {
            this.f64752a.getRequest().getNetWorkParam().mPostData.add(a2, basicNameValuePair);
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(String str, byte[] bArr) {
        if (this.f64752a.getRequest().getNetWorkParam().mFileData == null) {
            this.f64752a.getRequest().getNetWorkParam().mFileData = new HashMap<>();
        }
        this.f64752a.getRequest().getNetWorkParam().mFileData.put(str, bArr);
    }
}
