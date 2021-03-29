package d.b.i0.p1.m;

import android.text.TextUtils;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.live.interfaces.net.DownLoadCallback;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.live.interfaces.net.LiveNetConstants;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLException;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class c implements INetWork {

    /* renamed from: a  reason: collision with root package name */
    public String f58804a;

    /* renamed from: b  reason: collision with root package name */
    public int f58805b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f58806c = -1;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f58807d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Object> f58808e;

    public final Map<String, String> a(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && (entry.getValue() instanceof String)) {
                hashMap.put(entry.getKey(), (String) entry.getValue());
            }
        }
        return hashMap;
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void cancel() {
        HttpManager.getDefault(TbadkCoreApplication.getInst()).cancelTag(this);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0110 -> B:84:0x012b). Please submit an issue!!! */
    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void download(Object obj, String str, DownLoadCallback downLoadCallback) {
        Throwable th;
        boolean startsWith = this.f58804a.startsWith("https://");
        GetRequest.GetRequestBuilder request = HttpManager.getDefault(TbadkCoreApplication.getInst()).getRequest();
        request.url(this.f58804a).tag(this).addHeaders(this.f58807d).connectionTimeout(this.f58805b).readTimeout(this.f58806c);
        if (startsWith) {
            request.cookieManager(CookieManager.WEBKIT_COOKIES);
        }
        NetResponse netResponse = new NetResponse();
        try {
            Response executeSync = request.build().executeSync();
            if (executeSync.isSuccessful()) {
                FileOutputStream fileOutputStream = null;
                InputStream byteStream = executeSync.body() != null ? executeSync.body().byteStream() : null;
                if (byteStream == null) {
                    return;
                }
                File file = new File(str);
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
                try {
                    try {
                        try {
                            if (file.createNewFile()) {
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                try {
                                    byte[] bArr = new byte[2048];
                                    long contentLength = executeSync.body().contentLength();
                                    long j = 0;
                                    if (contentLength > 0) {
                                        while (true) {
                                            int read = byteStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            fileOutputStream2.write(bArr, 0, read);
                                            long j2 = j + read;
                                            downLoadCallback.onFileUpdateProgress(obj, j2, contentLength);
                                            j = j2;
                                        }
                                        fileOutputStream2.flush();
                                        downLoadCallback.onFileDownloaded(obj, executeSync.code(), 0, "");
                                    } else {
                                        downLoadCallback.onFileDownloaded(obj, executeSync.code(), -10, "no content length");
                                    }
                                    fileOutputStream = fileOutputStream2;
                                } catch (IOException e2) {
                                    e = e2;
                                    fileOutputStream = fileOutputStream2;
                                    downLoadCallback.onFileDownloaded(obj, executeSync.code(), -19, e.getMessage());
                                    byteStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = fileOutputStream2;
                                    try {
                                        byteStream.close();
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                    throw th;
                                }
                            } else {
                                downLoadCallback.onFileDownloaded(obj, executeSync.code(), -19, "mkdir fail");
                            }
                            byteStream.close();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (IOException e4) {
                            e = e4;
                        }
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                downLoadCallback.onFileDownloaded(obj, executeSync.code(), -10, "http error");
            }
        } catch (ConnectException e6) {
            netResponse.netErrorCode = -22;
            netResponse.exception = e6.getMessage();
            downLoadCallback.onFileDownloaded(obj, 0, -22, e6.getMessage());
        } catch (SocketException e7) {
            netResponse.netErrorCode = -12;
            netResponse.exception = e7.getMessage();
            downLoadCallback.onFileDownloaded(obj, 0, -12, e7.getMessage());
        } catch (SocketTimeoutException e8) {
            netResponse.netErrorCode = -13;
            netResponse.exception = e8.getMessage();
            downLoadCallback.onFileDownloaded(obj, 0, -13, e8.getMessage());
        } catch (UnknownHostException e9) {
            netResponse.netErrorCode = -21;
            netResponse.exception = e9.getMessage();
            downLoadCallback.onFileDownloaded(obj, 0, -21, e9.getMessage());
        } catch (SSLException e10) {
            netResponse.netErrorCode = -20;
            netResponse.exception = e10.getMessage();
            downLoadCallback.onFileDownloaded(obj, 0, -20, e10.getMessage());
        } catch (IOException e11) {
            netResponse.netErrorCode = -19;
            netResponse.exception = e11.getMessage();
            downLoadCallback.onFileDownloaded(obj, 0, -19, e11.getMessage());
        } catch (Throwable th4) {
            netResponse.netErrorCode = -10;
            netResponse.exception = th4.getMessage();
            downLoadCallback.onFileDownloaded(obj, 0, -10, th4.getMessage());
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public NetResponse getSync(Map<String, Object> map) {
        NetResponse netResponse = new NetResponse();
        try {
            Response executeSync = HttpManager.getDefault(TbadkCoreApplication.getInst()).getRequest().url(this.f58804a).tag(this).addUrlParams(a(map)).addHeaders(this.f58807d).connectionTimeout(this.f58805b).readTimeout(this.f58806c).cookieManager(CookieManager.WEBKIT_COOKIES).build().executeSync();
            try {
                netResponse.responseCode = executeSync.code();
                netResponse.decodedResponseStr = executeSync.body() != null ? executeSync.body().string() : null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return netResponse;
        } catch (ConnectException e3) {
            netResponse.netErrorCode = -22;
            netResponse.exception = e3.getMessage();
            return netResponse;
        } catch (SocketException e4) {
            netResponse.netErrorCode = -12;
            netResponse.exception = e4.getMessage();
            return netResponse;
        } catch (SocketTimeoutException e5) {
            netResponse.netErrorCode = -13;
            netResponse.exception = e5.getMessage();
            return netResponse;
        } catch (UnknownHostException e6) {
            netResponse.netErrorCode = -21;
            netResponse.exception = e6.getMessage();
            return netResponse;
        } catch (SSLException e7) {
            netResponse.netErrorCode = -20;
            netResponse.exception = e7.getMessage();
            return netResponse;
        } catch (IOException e8) {
            netResponse.netErrorCode = -19;
            netResponse.exception = e8.getMessage();
            return netResponse;
        } catch (Throwable th) {
            netResponse.netErrorCode = -10;
            netResponse.exception = th.getMessage();
            return netResponse;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public NetResponse postSync(Map<String, Object> map) {
        Map<String, Object> map2 = this.f58808e;
        Boolean bool = (map2 == null || !(map2.get(LiveNetConstants.EXTRA_KEY_ENABLE_STAT) instanceof Boolean)) ? null : (Boolean) this.f58808e.get(LiveNetConstants.EXTRA_KEY_ENABLE_STAT);
        Map<String, Object> map3 = this.f58808e;
        Integer num = (map3 == null || !(map3.get(LiveNetConstants.EXTRA_KEY_REQUEST_FROM) instanceof Integer)) ? null : (Integer) this.f58808e.get(LiveNetConstants.EXTRA_KEY_REQUEST_FROM);
        Map<String, Object> map4 = this.f58808e;
        if (map4 != null && (map4.get(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM) instanceof Integer)) {
            Integer num2 = (Integer) this.f58808e.get(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM);
        }
        NetResponse netResponse = new NetResponse();
        try {
            PostFormRequest.PostFormRequestBuilder postFormRequest = HttpManager.getDefault(TbadkCoreApplication.getInst()).postFormRequest();
            if (bool != null) {
                postFormRequest.enableStat(bool.booleanValue());
            }
            if (num != null) {
                postFormRequest.requestFrom(num.intValue());
            }
            Response executeSync = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) postFormRequest.url(this.f58804a)).params(a(map)).addHeaders(this.f58807d)).connectionTimeout(this.f58805b)).readTimeout(this.f58806c)).cookieManager(CookieManager.WEBKIT_COOKIES)).build().executeSync();
            try {
                netResponse.responseCode = executeSync.code();
                netResponse.decodedResponseStr = executeSync.body() != null ? executeSync.body().string() : null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return netResponse;
        } catch (ConnectException e3) {
            netResponse.netErrorCode = -22;
            netResponse.exception = e3.getMessage();
            return netResponse;
        } catch (SocketException e4) {
            netResponse.netErrorCode = -12;
            netResponse.exception = e4.getMessage();
            return netResponse;
        } catch (SocketTimeoutException e5) {
            netResponse.netErrorCode = -13;
            netResponse.exception = e5.getMessage();
            return netResponse;
        } catch (UnknownHostException e6) {
            netResponse.netErrorCode = -21;
            netResponse.exception = e6.getMessage();
            return netResponse;
        } catch (SSLException e7) {
            netResponse.netErrorCode = -20;
            netResponse.exception = e7.getMessage();
            return netResponse;
        } catch (IOException e8) {
            netResponse.netErrorCode = -19;
            netResponse.exception = e8.getMessage();
            return netResponse;
        } catch (Throwable th) {
            netResponse.netErrorCode = -10;
            netResponse.exception = th.getMessage();
            return netResponse;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void setConnectTimeout(int i) {
        this.f58805b = i;
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void setExtra(Map<String, Object> map) {
        this.f58808e = map;
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void setHeaderData(HashMap<String, String> hashMap) {
        this.f58807d = hashMap;
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void setReadTimeout(int i) {
        this.f58806c = i;
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void setRetryCount(int i) {
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void setUrl(String str) {
        this.f58804a = str;
    }
}
