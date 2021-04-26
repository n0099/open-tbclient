package d.a.j0.d3.o0.d.f;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.a.j0.d3.o0.d.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public e f53261a;

    /* renamed from: b  reason: collision with root package name */
    public final String f53262b;

    /* renamed from: c  reason: collision with root package name */
    public final int f53263c;

    /* renamed from: d  reason: collision with root package name */
    public final long f53264d;

    /* renamed from: e  reason: collision with root package name */
    public final String f53265e;

    /* renamed from: f  reason: collision with root package name */
    public final int f53266f;

    public a(String str, int i2, int i3, long j, String str2) {
        this.f53262b = str;
        this.f53263c = i3;
        this.f53264d = j;
        this.f53265e = str2;
        this.f53266f = i2;
    }

    public abstract void a();

    public byte[] b(RandomAccessFile randomAccessFile, int i2) {
        int i3;
        if (randomAccessFile != null && i2 >= 0) {
            if (i2 == this.f53263c) {
                i3 = (int) (this.f53264d - ((i2 - 1) * this.f53266f));
            } else {
                i3 = this.f53266f;
            }
            byte[] bArr = new byte[i3];
            try {
                synchronized (randomAccessFile) {
                    randomAccessFile.seek((i2 - 1) * this.f53266f);
                    r3 = randomAccessFile.read(bArr, 0, i3) != -1;
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

    public void d(int i2) {
        e eVar = this.f53261a;
        if (eVar != null) {
            eVar.onProgressUpdate(i2 / 100.0f);
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
        this.f53261a = eVar;
    }

    public abstract d g(ArrayList<Integer> arrayList, String str, int i2);

    public d h(RandomAccessFile randomAccessFile, int i2, long j, String str) {
        byte[] b2 = b(randomAccessFile, i2);
        if (b2 == null) {
            d dVar = new d();
            dVar.f53278b = -1;
            dVar.f53279c = "上传文件不存在";
            return dVar;
        } else if (c()) {
            return null;
        } else {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
            netWork.addPostData("chunk_no", String.valueOf(i2));
            netWork.addPostData("chunk_sum", String.valueOf(this.f53263c));
            netWork.addPostData("chunk_size", String.valueOf(b2.length));
            netWork.addPostData("video_size", String.valueOf(this.f53264d));
            netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, this.f53265e);
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
                dVar2.f53277a = e(postMultiNetData);
            } else {
                if (netWork.getNetContext().getResponse().isNetSuccess()) {
                    dVar2.f53278b = netWork.getNetContext().getResponse().mServerErrorCode;
                } else {
                    dVar2.f53278b = netWork.getNetContext().getResponse().mNetErrorCode;
                }
                dVar2.f53279c = netWork.getNetContext().getResponse().mErrorString;
            }
            return dVar2;
        }
    }
}
