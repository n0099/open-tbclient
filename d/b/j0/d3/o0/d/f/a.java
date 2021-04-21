package d.b.j0.d3.o0.d.f;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.b.j0.d3.o0.d.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public e f55419a;

    /* renamed from: b  reason: collision with root package name */
    public final String f55420b;

    /* renamed from: c  reason: collision with root package name */
    public final int f55421c;

    /* renamed from: d  reason: collision with root package name */
    public final long f55422d;

    /* renamed from: e  reason: collision with root package name */
    public final String f55423e;

    /* renamed from: f  reason: collision with root package name */
    public final int f55424f;

    public a(String str, int i, int i2, long j, String str2) {
        this.f55420b = str;
        this.f55421c = i2;
        this.f55422d = j;
        this.f55423e = str2;
        this.f55424f = i;
    }

    public abstract void a();

    public byte[] b(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile != null && i >= 0) {
            if (i == this.f55421c) {
                i2 = (int) (this.f55422d - ((i - 1) * this.f55424f));
            } else {
                i2 = this.f55424f;
            }
            byte[] bArr = new byte[i2];
            try {
                synchronized (randomAccessFile) {
                    randomAccessFile.seek((i - 1) * this.f55424f);
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
        e eVar = this.f55419a;
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
        this.f55419a = eVar;
    }

    public abstract d g(ArrayList<Integer> arrayList, String str, int i);

    public d h(RandomAccessFile randomAccessFile, int i, long j, String str) {
        byte[] b2 = b(randomAccessFile, i);
        if (b2 == null) {
            d dVar = new d();
            dVar.f55434b = -1;
            dVar.f55435c = "上传文件不存在";
            return dVar;
        } else if (c()) {
            return null;
        } else {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
            netWork.addPostData("chunk_no", String.valueOf(i));
            netWork.addPostData("chunk_sum", String.valueOf(this.f55421c));
            netWork.addPostData("chunk_size", String.valueOf(b2.length));
            netWork.addPostData("video_size", String.valueOf(this.f55422d));
            netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, this.f55423e);
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
                dVar2.f55433a = e(postMultiNetData);
            } else {
                if (netWork.getNetContext().getResponse().isNetSuccess()) {
                    dVar2.f55434b = netWork.getNetContext().getResponse().mServerErrorCode;
                } else {
                    dVar2.f55434b = netWork.getNetContext().getResponse().mNetErrorCode;
                }
                dVar2.f55435c = netWork.getNetContext().getResponse().mErrorString;
            }
            return dVar2;
        }
    }
}
