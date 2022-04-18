package com.repackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes6.dex */
public class hb8 implements INetWorkCore {
    public static /* synthetic */ Interceptable $ic = null;
    public static int d = 2097152;
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpNetContext a;
    public Context b;
    public wb8 c;

    /* loaded from: classes6.dex */
    public class a implements cc8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public final /* synthetic */ Handler d;
        public final /* synthetic */ int e;

        public a(hb8 hb8Var, Handler handler, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hb8Var, handler, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = handler;
            this.e = i;
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }

        @Override // com.repackage.cc8
        public void onProgress(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (i2 > 0) {
                    this.a = i2 / 50;
                }
                int i3 = this.b + (i - this.c);
                this.b = i3;
                this.c = i;
                if (this.d != null) {
                    if (i3 > this.a || i == i2) {
                        this.b = 0;
                        Handler handler = this.d;
                        handler.sendMessage(handler.obtainMessage(this.e, i, i2));
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755653901, "Lcom/repackage/hb8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755653901, "Lcom/repackage/hb8;");
        }
    }

    public hb8(HttpNetContext httpNetContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpNetContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new wb8();
        this.b = TbadkCoreApplication.getInst().getApp();
        this.a = httpNetContext;
        wb8.n("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        wb8.l((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? ul4.a : cookie);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        if (r2 < r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(ArrayList<BasicNameValuePair> arrayList, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, arrayList, str)) != null) {
            return invokeLL.intValue;
        }
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            int compareTo = str.compareTo(arrayList.get(i).getName());
            if (compareTo < 0) {
                i2 = i;
                break;
            } else if (compareTo == 0) {
                return -1;
            } else {
                i2 = i;
                i++;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            addPostData(new BasicNameValuePair(str, str2));
        }
    }

    public final LinkedList<BasicNameValuePair> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a != null) {
                LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
                if (!TextUtils.isEmpty(this.a.getRequest().getNetWorkParam().mSeqId)) {
                    linkedList.add(new BasicNameValuePair("sid", this.a.getRequest().getNetWorkParam().mSeqId));
                }
                if (!TextUtils.isEmpty(this.a.getRequest().getNetWorkParam().mNetType)) {
                    linkedList.add(new BasicNameValuePair("net", this.a.getRequest().getNetWorkParam().mNetType));
                }
                return linkedList;
            }
            return null;
        }
        return (LinkedList) invokeV.objValue;
    }

    public final int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i != 1) {
                if (i == 2) {
                    return 2;
                }
                if (i == 3) {
                    return 3;
                }
            }
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void cancelNetConnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.c();
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.a.getResponse().mServerErrorCode = -1;
            if (str != null) {
                try {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(str);
                    this.a.getResponse().mServerErrorCode = errorData.getError_code();
                    if (this.a.getResponse().mServerErrorCode == -1) {
                        this.a.getResponse().mErrorString = this.b.getString(R.string.obfuscated_res_0x7f0f059f);
                    } else if (this.a.getResponse().mServerErrorCode != 0) {
                        this.a.getResponse().mErrorString = errorData.getError_msg();
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    this.a.getResponse().mErrorString = this.b.getString(R.string.obfuscated_res_0x7f0f059f);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        File a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, handler, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            boolean z2 = false;
            try {
                try {
                } catch (Exception e) {
                    this.a.getResponse().mNetErrorCode = -10;
                    HttpResponse response = this.a.getResponse();
                    response.mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                } catch (OutOfMemoryError e2) {
                    this.a.getResponse().mNetErrorCode = -15;
                    this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0ab4);
                    BdLog.e(e2.getMessage());
                }
                if (this.c.i()) {
                    return false;
                }
                if (z) {
                    a2 = new File(str);
                } else {
                    a2 = o98.a(str);
                }
                z2 = this.c.d(this.a.getRequest().getNetWorkParam().mUrl, a2.getAbsolutePath(), false, i2, i3, -1, -1, b(), new a(this, handler, i), true);
                return z2;
            } finally {
                TiebaStatic.net(this.a);
            }
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0532 A[RETURN] */
    @Override // com.baidu.tbadk.core.util.INetWorkCore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getNetData() {
        InterceptResult invokeV;
        Exception exc;
        bc8 bc8Var;
        SocketTimeoutException socketTimeoutException;
        SocketException socketException;
        OutOfMemoryError outOfMemoryError;
        BdHttpCancelException bdHttpCancelException;
        String str;
        String str2;
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            wb8.m(TbadkCoreApplication.getCurrentAccount());
            try {
                if (this.a.getRequest().getNetWorkParam().mPostData != null && this.a.getRequest().getNetWorkParam().mPostData.size() > 0 && !this.a.getRequest().mIsFromCDN) {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.a.getRequest().getNetWorkParam().mUrl);
                    if (this.a.getRequest().getNetWorkParam().mUrl.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.a.getRequest().getNetWorkParam().mUrl.endsWith("?") && !this.a.getRequest().getNetWorkParam().mUrl.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i = 0; i < this.a.getRequest().getNetWorkParam().mPostData.size(); i++) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(this.a.getRequest().getNetWorkParam().mPostData.get(i).getName());
                        sb.append("=");
                        sb.append(ni.getUrlEncode(this.a.getRequest().getNetWorkParam().mPostData.get(i).getValue()));
                    }
                    str = sb.toString();
                } else {
                    str = this.a.getRequest().getNetWorkParam().mUrl;
                }
                str2 = str;
                TbConfig.getDebugSwitch();
                z = (this.a.getRequest().getNetWorkParam().mRequestGzip && !this.a.getRequest().getNetWorkParam().mIsBDImage) || this.a.getRequest().mIsFromCDN;
            } catch (BdHttpCancelException e) {
                bdHttpCancelException = e;
                bc8Var = null;
            } catch (OutOfMemoryError e2) {
                outOfMemoryError = e2;
                bc8Var = null;
            } catch (SocketException e3) {
                socketException = e3;
                bc8Var = null;
            } catch (SocketTimeoutException e4) {
                socketTimeoutException = e4;
                bc8Var = null;
            } catch (Exception e5) {
                exc = e5;
                bc8Var = null;
            }
            if (!this.c.i()) {
                long time = new Date().getTime();
                this.c.g(str2, z, 5, 100, -1, -1, b());
                zb8 f = this.c.f();
                if (f == null) {
                    return null;
                }
                bc8Var = f.b();
                if (f != null) {
                    try {
                        if (f.c() != null) {
                            f.c().size();
                        }
                    } catch (BdHttpCancelException e6) {
                        bdHttpCancelException = e6;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        HttpResponse response = this.a.getResponse();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.a.getResponse().mNetErrorCode);
                        sb2.append("|retryCount:");
                        sb2.append(this.a.getStat().stat != null ? this.a.getStat().stat.e : -1);
                        sb2.append("|");
                        sb2.append(BdHttpCancelException.class);
                        sb2.append("|");
                        sb2.append(bdHttpCancelException.getMessage());
                        response.mException = sb2.toString();
                        this.a.getResponse().mNetErrorCode = -14;
                        if (bc8Var == null) {
                        }
                    } catch (OutOfMemoryError e7) {
                        outOfMemoryError = e7;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0ab4);
                        HttpResponse response2 = this.a.getResponse();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(this.a.getResponse().mNetErrorCode);
                        sb3.append("|retryCount:");
                        sb3.append(this.a.getStat().stat != null ? this.a.getStat().stat.e : -1);
                        sb3.append("|");
                        sb3.append(outOfMemoryError.getClass());
                        sb3.append("|");
                        sb3.append(outOfMemoryError.getMessage());
                        response2.mException = sb3.toString();
                        this.a.getResponse().mNetErrorCode = -15;
                        BdLog.e(outOfMemoryError.getMessage());
                        TiebaStatic.net(this.a);
                        if (bc8Var == null) {
                        }
                    } catch (SocketException e8) {
                        socketException = e8;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        HttpResponse response3 = this.a.getResponse();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(this.a.getResponse().mNetErrorCode);
                        sb4.append("|retryCount:");
                        sb4.append(this.a.getStat().stat != null ? this.a.getStat().stat.e : -1);
                        sb4.append("|");
                        sb4.append(socketException.getClass());
                        sb4.append("|");
                        sb4.append(socketException.getMessage());
                        response3.mException = sb4.toString();
                        this.a.getResponse().mNetErrorCode = -12;
                        TiebaStatic.net(this.a);
                        if (bc8Var == null) {
                        }
                    } catch (SocketTimeoutException e9) {
                        socketTimeoutException = e9;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        HttpResponse response4 = this.a.getResponse();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(this.a.getResponse().mNetErrorCode);
                        sb5.append("|retryCount:");
                        sb5.append(this.a.getStat().stat != null ? this.a.getStat().stat.e : -1);
                        sb5.append("|");
                        sb5.append(socketTimeoutException.getClass());
                        sb5.append("|");
                        sb5.append(socketTimeoutException.getMessage());
                        response4.mException = sb5.toString();
                        this.a.getResponse().mNetErrorCode = -13;
                        TiebaStatic.net(this.a);
                        if (bc8Var == null) {
                        }
                    } catch (Exception e10) {
                        exc = e10;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17) + " detailException:" + exc.getMessage();
                        HttpResponse response5 = this.a.getResponse();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(this.a.getResponse().mNetErrorCode);
                        sb6.append("|retryCount:");
                        sb6.append(this.a.getStat().stat != null ? this.a.getStat().stat.e : -1);
                        sb6.append("|");
                        sb6.append(exc.getClass());
                        sb6.append("|");
                        sb6.append(exc.getMessage());
                        response5.mException = sb6.toString();
                        this.a.getResponse().mNetErrorCode = -10;
                        BdLog.e(exc.getMessage());
                        TiebaStatic.net(this.a);
                        if (bc8Var == null) {
                        }
                    }
                }
                if (bc8Var == null) {
                    return null;
                }
                this.a.getResponse().mNetErrorCode = bc8Var.b;
                if (this.a.getResponse().mNetErrorCode != 200) {
                    this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                    if (this.a.getStat().stat != null && !TextUtils.isEmpty(this.a.getStat().stat.h)) {
                        this.a.getResponse().mException = this.a.getStat().stat.h;
                    } else {
                        HttpResponse response6 = this.a.getResponse();
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(this.a.getResponse().mNetErrorCode);
                        sb7.append("|retryCount:");
                        sb7.append(this.a.getStat().stat == null ? -1 : this.a.getStat().stat.e);
                        response6.mException = sb7.toString();
                    }
                    TiebaStatic.net(this.a);
                    return null;
                }
                if (TbadkCoreApplication.getInst().isMainProcess(true) && (str3 = bc8Var.e) != null) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > d) {
                            this.a.getResponse().mNetErrorCode = -11;
                            TiebaStatic.net(this.a);
                            return null;
                        }
                        int i2 = parseInt * 10;
                        if (i2 > 0) {
                            BdLog.isDebugMode();
                            if (!h35.k().i(i2)) {
                                BdLog.d("Image download cacelled. out of memory. url:[" + this.a.getRequest().getNetWorkParam().mUrl + "], size:" + i2);
                                this.a.getResponse().mNetErrorCode = -16;
                                TiebaStatic.net(this.a);
                                return null;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
                statisticsData.mMode = c(mi.I());
                statisticsData.mSize = this.a.getStat().stat.b;
                statisticsData.mTime = new Date().getTime() - time;
                statisticsData.mTimesNum = this.a.getStat().stat.e;
                statisticsData.mMethod = 2;
                NetWorkState.addStatisticsData(statisticsData);
                NetWorkState.mErrorNums.set(this.a.getStat().stat.e);
                TiebaStatic.net(this.a);
                if (bc8Var == null) {
                    return bc8Var.g;
                }
                return null;
            }
            throw new BdHttpCancelException();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String getNetString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048586, this)) != null) {
            return (String) invokeV.objValue;
        }
        byte[] netData = getNetData();
        String str = null;
        if (netData == null || this.a.getResponse().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.a.getRequest().getNetWorkParam().charSet = TextUtils.isEmpty(this.a.getRequest().getNetWorkParam().charSet) ? "UTF-8" : this.a.getRequest().getNetWorkParam().charSet;
            String str2 = new String(netData, 0, netData.length, this.a.getRequest().getNetWorkParam().charSet);
            try {
                d(str2);
                return str2;
            } catch (Exception e) {
                e = e;
                str = str2;
                BdLog.e(e.getMessage());
                return str;
            } catch (OutOfMemoryError e2) {
                e = e2;
                str = str2;
                BdLog.e(e.getMessage());
                return str;
            }
        } catch (Exception e3) {
            e = e3;
        } catch (OutOfMemoryError e4) {
            e = e4;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public ArrayList<BasicNameValuePair> getPostData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.getRequest().getNetWorkParam().mPostData : (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String getSeqId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            HttpNetContext httpNetContext = this.a;
            if (httpNetContext != null) {
                return httpNetContext.getRequest().getNetWorkParam().mSeqId;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public boolean isCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.c.i() : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String postMultiNetData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048590, this)) != null) {
            return (String) invokeV.objValue;
        }
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; this.a.getRequest().getNetWorkParam().mPostData != null && i < this.a.getRequest().getNetWorkParam().mPostData.size(); i++) {
            BasicNameValuePair basicNameValuePair = this.a.getRequest().getNetWorkParam().mPostData.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
        }
        if (this.a.getRequest().getNetWorkParam().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", ui.c(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        String str = null;
        try {
            if (this.c.i()) {
                return null;
            }
            if (this.c.j(this.a.getRequest().getNetWorkParam().mUrl, this.a.getRequest().getNetWorkParam().mPostData, this.a.getRequest().getNetWorkParam().mRequestGzip, 5, -1, b()) != null) {
                zb8 f = this.c.f();
                if (f == null) {
                    return null;
                }
                bc8 b = f.b();
                if (f != null && f.c() != null) {
                    f.c().size();
                }
                this.a.getResponse().mNetErrorCode = b.b;
                this.a.getResponse().mHeader = b.f;
                if (this.a.getResponse().mNetErrorCode != 200) {
                    if (this.a.getStat().stat != null && !TextUtils.isEmpty(this.a.getStat().stat.h)) {
                        this.a.getResponse().mException = this.a.getStat().stat.h;
                    } else {
                        HttpResponse response = this.a.getResponse();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.a.getResponse().mNetErrorCode);
                        sb2.append("|retryCount:");
                        sb2.append(this.a.getStat().stat == null ? -1 : this.a.getStat().stat.e);
                        response.mException = sb2.toString();
                    }
                    TiebaStatic.net(this.a);
                    return null;
                } else if (this.c.i()) {
                    return null;
                } else {
                    String str2 = new String(b.g, StandardCharsets.UTF_8);
                    try {
                        if (this.a.getRequest().getNetWorkParam().mIsBaiduServer && this.a.getRequest().getNetWorkParam().mIsJson) {
                            d(str2);
                        }
                        NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
                        statisticsData.mMode = c(mi.I());
                        statisticsData.mSize = this.a.getStat().stat.b;
                        statisticsData.mTime = this.a.getStat().stat.f;
                        statisticsData.mTimesNum = this.a.getStat().stat.e;
                        statisticsData.mMethod = 1;
                        NetWorkState.addStatisticsData(statisticsData);
                        NetWorkState.mErrorNums.set(this.a.getStat().stat.e);
                        TiebaStatic.net(this.a);
                        return str2;
                    } catch (BdHttpCancelException e) {
                        e = e;
                        str = str2;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        HttpResponse response2 = this.a.getResponse();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(this.a.getResponse().mNetErrorCode);
                        sb3.append("|retryCount:");
                        sb3.append(this.a.getStat().stat != null ? this.a.getStat().stat.e : -1);
                        sb3.append("|");
                        sb3.append(BdHttpCancelException.class);
                        sb3.append("|");
                        sb3.append(e.getMessage());
                        response2.mException = sb3.toString();
                        this.a.getResponse().mNetErrorCode = -14;
                        return str;
                    } catch (OutOfMemoryError e2) {
                        e = e2;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -15;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0ab4);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (SocketException e3) {
                        e = e3;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -12;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (SocketTimeoutException e4) {
                        e = e4;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -13;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (Exception e5) {
                        e = e5;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -10;
                        HttpResponse response3 = this.a.getResponse();
                        response3.mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (Throwable th) {
                        th = th;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -10;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    }
                }
            }
            throw new BdHttpCancelException();
        } catch (BdHttpCancelException e6) {
            e = e6;
        } catch (SocketException e7) {
            e = e7;
        } catch (SocketTimeoutException e8) {
            e = e8;
        } catch (Exception e9) {
            e = e9;
        } catch (OutOfMemoryError e10) {
            e = e10;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String postNetData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048591, this)) != null) {
            return (String) invokeV.objValue;
        }
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; this.a.getRequest().getNetWorkParam().mPostData != null && i < this.a.getRequest().getNetWorkParam().mPostData.size(); i++) {
            BasicNameValuePair basicNameValuePair = this.a.getRequest().getNetWorkParam().mPostData.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
        }
        if (this.a.getRequest().getNetWorkParam().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", ui.c(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        String str = null;
        try {
            if (this.c.i()) {
                return null;
            }
            if (this.c.j(this.a.getRequest().getNetWorkParam().mUrl, this.a.getRequest().getNetWorkParam().mPostData, this.a.getRequest().getNetWorkParam().mRequestGzip, 5, -1, b()) != null) {
                zb8 f = this.c.f();
                if (f == null) {
                    return null;
                }
                bc8 b = f.b();
                if (f != null && f.c() != null) {
                    f.c().size();
                }
                this.a.getResponse().mNetErrorCode = b.b;
                this.a.getResponse().mHeader = b.f;
                if (this.a.getResponse().mNetErrorCode != 200) {
                    if (this.a.getStat().stat != null && !TextUtils.isEmpty(this.a.getStat().stat.h)) {
                        this.a.getResponse().mException = this.a.getStat().stat.h;
                    } else {
                        HttpResponse response = this.a.getResponse();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.a.getResponse().mNetErrorCode);
                        sb2.append("|retryCount:");
                        sb2.append(this.a.getStat().stat == null ? -1 : this.a.getStat().stat.e);
                        response.mException = sb2.toString();
                    }
                    TiebaStatic.net(this.a);
                    return null;
                } else if (this.c.i()) {
                    return null;
                } else {
                    String str2 = new String(b.g, StandardCharsets.UTF_8);
                    try {
                        if (this.a.getRequest().getNetWorkParam().mIsBaiduServer && this.a.getRequest().getNetWorkParam().mIsJson) {
                            d(str2);
                        }
                        NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
                        statisticsData.mMode = c(mi.I());
                        statisticsData.mSize = this.a.getStat().stat.b;
                        statisticsData.mTime = this.a.getStat().stat.f;
                        statisticsData.mTimesNum = this.a.getStat().stat.e;
                        statisticsData.mMethod = 1;
                        NetWorkState.addStatisticsData(statisticsData);
                        NetWorkState.mErrorNums.set(this.a.getStat().stat.e);
                        TiebaStatic.net(this.a);
                        return str2;
                    } catch (BdHttpCancelException e) {
                        e = e;
                        str = str2;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        HttpResponse response2 = this.a.getResponse();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(this.a.getResponse().mNetErrorCode);
                        sb3.append("|retryCount:");
                        sb3.append(this.a.getStat().stat != null ? this.a.getStat().stat.e : -1);
                        sb3.append("|");
                        sb3.append(BdHttpCancelException.class);
                        sb3.append("|");
                        sb3.append(e.getMessage());
                        response2.mException = sb3.toString();
                        this.a.getResponse().mNetErrorCode = -14;
                        return str;
                    } catch (OutOfMemoryError e2) {
                        e = e2;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -15;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0ab4);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (SocketException e3) {
                        e = e3;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -12;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (SocketTimeoutException e4) {
                        e = e4;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -13;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (Exception e5) {
                        e = e5;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -10;
                        HttpResponse response3 = this.a.getResponse();
                        response3.mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (Throwable th) {
                        th = th;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -10;
                        this.a.getResponse().mErrorString = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    }
                }
            }
            throw new BdHttpCancelException();
        } catch (BdHttpCancelException e6) {
            e = e6;
        } catch (SocketException e7) {
            e = e7;
        } catch (SocketTimeoutException e8) {
            e = e8;
        } catch (Exception e9) {
            e = e9;
        } catch (OutOfMemoryError e10) {
            e = e10;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setCancel() {
        wb8 wb8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (wb8Var = this.c) == null) {
            return;
        }
        wb8Var.k();
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setIsBaiduServer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.a.getRequest().getNetWorkParam().mIsBaiduServer = z;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, arrayList) == null) {
            if (this.a.getRequest().getNetWorkParam().mPostData != null) {
                this.a.getRequest().getNetWorkParam().mPostData.clear();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                addPostData(arrayList.get(i));
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, basicNameValuePair) == null) || basicNameValuePair == null || basicNameValuePair.getName() == null) {
            return;
        }
        if (this.a.getRequest().getNetWorkParam().mPostData == null) {
            this.a.getRequest().getNetWorkParam().mPostData = new ArrayList<>();
        }
        int a2 = a(this.a.getRequest().getNetWorkParam().mPostData, basicNameValuePair.getName());
        int size = this.a.getRequest().getNetWorkParam().mPostData.size();
        if (a2 < 0 || a2 >= size) {
            if (a2 == size) {
                this.a.getRequest().getNetWorkParam().mPostData.add(a2, basicNameValuePair);
            }
        } else if (basicNameValuePair.getName().equals(this.a.getRequest().getNetWorkParam().mPostData.get(a2).getName())) {
            this.a.getRequest().getNetWorkParam().mPostData.set(a2, basicNameValuePair);
        } else {
            this.a.getRequest().getNetWorkParam().mPostData.add(a2, basicNameValuePair);
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr) == null) {
            if (this.a.getRequest().getNetWorkParam().mFileData == null) {
                this.a.getRequest().getNetWorkParam().mFileData = new HashMap<>();
            }
            this.a.getRequest().getNetWorkParam().mFileData.put(str, bArr);
        }
    }
}
