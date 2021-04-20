package d.b.i0.d3.o0.d.f;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.b.i0.d3.o0.d.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public e f54998a;

    /* renamed from: b  reason: collision with root package name */
    public final String f54999b;

    /* renamed from: c  reason: collision with root package name */
    public final int f55000c;

    /* renamed from: d  reason: collision with root package name */
    public final long f55001d;

    /* renamed from: e  reason: collision with root package name */
    public final String f55002e;

    /* renamed from: f  reason: collision with root package name */
    public final int f55003f;

    public a(String str, int i, int i2, long j, String str2) {
        this.f54999b = str;
        this.f55000c = i2;
        this.f55001d = j;
        this.f55002e = str2;
        this.f55003f = i;
    }

    public abstract void a();

    public byte[] b(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile != null && i >= 0) {
            if (i == this.f55000c) {
                i2 = (int) (this.f55001d - ((i - 1) * this.f55003f));
            } else {
                i2 = this.f55003f;
            }
            byte[] bArr = new byte[i2];
            try {
                synchronized (randomAccessFile) {
                    randomAccessFile.seek((i - 1) * this.f55003f);
                    r3 = randomAccessFile.read(bArr, 0, i2) != -1;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (r3) {
                return bArr;
            }
        }
        return null;
    }

    public abstract boolean c();

    public void d(int i) {
        e eVar = this.f54998a;
        if (eVar != null) {
            eVar.onProgressUpdate(i / 100.0f);
        }
    }

    public final String e(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            if (optJSONObject != null) {
                return optJSONObject.optString("video_url");
            }
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        return null;
    }

    public void f(e eVar) {
        this.f54998a = eVar;
    }

    public abstract d g(ArrayList<Integer> arrayList, String str, int i);

    public d h(RandomAccessFile randomAccessFile, int i, long j, String str) {
        byte[] b2 = b(randomAccessFile, i);
        if (b2 == null) {
            d dVar = new d();
            dVar.f55013b = -1;
            dVar.f55014c = "上传文件不存在";
            return dVar;
        } else if (c()) {
            return null;
        } else {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
            netWork.addPostData("chunk_no", String.valueOf(i));
            netWork.addPostData("chunk_sum", String.valueOf(this.f55000c));
            netWork.addPostData("chunk_size", String.valueOf(b2.length));
            netWork.addPostData("video_size", String.valueOf(this.f55001d));
            netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, this.f55002e);
            netWork.addPostData("video_len", String.valueOf(j));
            netWork.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
            netWork.addPostData("video_chunk", b2);
            netWork.addPostData("upload_id", str);
            if (c()) {
                return null;
            }
            String postMultiNetData = netWork.postMultiNetData();
            if (c()) {
                return null;
            }
            d dVar2 = new d();
            if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                dVar2.f55012a = e(postMultiNetData);
            } else {
                if (netWork.getNetContext().getResponse().isNetSuccess()) {
                    dVar2.f55013b = netWork.getNetContext().getResponse().mServerErrorCode;
                } else {
                    dVar2.f55013b = netWork.getNetContext().getResponse().mNetErrorCode;
                }
                dVar2.f55014c = netWork.getNetContext().getResponse().mErrorString;
            }
            return dVar2;
        }
    }
}
