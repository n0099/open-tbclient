package d.b.i0.c3.o0.d.f;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.b.i0.c3.o0.d.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public e f53553a;

    /* renamed from: b  reason: collision with root package name */
    public final String f53554b;

    /* renamed from: c  reason: collision with root package name */
    public final int f53555c;

    /* renamed from: d  reason: collision with root package name */
    public final long f53556d;

    /* renamed from: e  reason: collision with root package name */
    public final String f53557e;

    /* renamed from: f  reason: collision with root package name */
    public final int f53558f;

    public a(String str, int i, int i2, long j, String str2) {
        this.f53554b = str;
        this.f53555c = i2;
        this.f53556d = j;
        this.f53557e = str2;
        this.f53558f = i;
    }

    public abstract void a();

    public byte[] b(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile != null && i >= 0) {
            if (i == this.f53555c) {
                i2 = (int) (this.f53556d - ((i - 1) * this.f53558f));
            } else {
                i2 = this.f53558f;
            }
            byte[] bArr = new byte[i2];
            try {
                synchronized (randomAccessFile) {
                    randomAccessFile.seek((i - 1) * this.f53558f);
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
        e eVar = this.f53553a;
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
        this.f53553a = eVar;
    }

    public abstract d g(ArrayList<Integer> arrayList, String str, int i);

    public d h(RandomAccessFile randomAccessFile, int i, long j, String str) {
        byte[] b2 = b(randomAccessFile, i);
        if (b2 == null) {
            d dVar = new d();
            dVar.f53568b = -1;
            dVar.f53569c = "上传文件不存在";
            return dVar;
        } else if (c()) {
            return null;
        } else {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
            netWork.addPostData("chunk_no", String.valueOf(i));
            netWork.addPostData("chunk_sum", String.valueOf(this.f53555c));
            netWork.addPostData("chunk_size", String.valueOf(b2.length));
            netWork.addPostData("video_size", String.valueOf(this.f53556d));
            netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, this.f53557e);
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
                dVar2.f53567a = e(postMultiNetData);
            } else {
                if (netWork.getNetContext().getResponse().isNetSuccess()) {
                    dVar2.f53568b = netWork.getNetContext().getResponse().mServerErrorCode;
                } else {
                    dVar2.f53568b = netWork.getNetContext().getResponse().mNetErrorCode;
                }
                dVar2.f53569c = netWork.getNetContext().getResponse().mErrorString;
            }
            return dVar2;
        }
    }
}
