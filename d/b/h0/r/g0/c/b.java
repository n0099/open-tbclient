package d.b.h0.r.g0.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ChunkUploadDatabaseService;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import d.b.b.e.p.q;
import d.b.h0.s.c.o;
import d.b.h0.s.c.p;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public NetWork f50599a;

    /* renamed from: b  reason: collision with root package name */
    public a f50600b;

    /* renamed from: c  reason: collision with root package name */
    public p f50601c;

    /* renamed from: d  reason: collision with root package name */
    public String f50602d;

    /* renamed from: e  reason: collision with root package name */
    public String f50603e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1080b> f50604f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f50605a;

        /* renamed from: b  reason: collision with root package name */
        public String f50606b;

        /* renamed from: c  reason: collision with root package name */
        public o f50607c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f50608d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f50609e = false;

        /* renamed from: f  reason: collision with root package name */
        public String f50610f;

        public a(b bVar, String str, o oVar, String str2, String str3) {
            this.f50605a = null;
            this.f50606b = null;
            this.f50607c = null;
            this.f50610f = null;
            this.f50605a = str;
            this.f50607c = oVar;
            this.f50606b = str2;
            this.f50610f = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x010d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public p a() throws IOException {
            boolean z;
            p pVar = new p();
            long c2 = this.f50607c.c();
            long j = 30720;
            long j2 = c2 / 30720;
            if (c2 % 30720 != 0) {
                j2++;
            }
            int a2 = this.f50607c.a();
            if (a2 < j2) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f50605a), r.f7663a);
                int i = a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                if (randomAccessFile.skipBytes(i) >= i) {
                    while (true) {
                        long j3 = a2;
                        if (j3 < j2) {
                            long j4 = j2 - 1;
                            int i2 = j3 == j4 ? (int) (c2 - (j4 * j)) : TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                            byte[] bArr = new byte[i2];
                            int read = randomAccessFile.read(bArr, 0, i2);
                            if (read != -1) {
                                NetWork netWork = new NetWork(this.f50606b);
                                this.f50608d = netWork;
                                netWork.addPostData("voice_chunk", bArr);
                                this.f50608d.addPostData("chunk_md5", this.f50607c.b());
                                this.f50608d.addPostData("length", String.valueOf(read));
                                this.f50608d.addPostData("offset", String.valueOf(a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.f50608d.addPostData("total_length", String.valueOf(c2));
                                this.f50608d.addPostData("chunk_no", String.valueOf(a2 + 1));
                                this.f50608d.addPostData("total_num", String.valueOf(j2));
                                this.f50608d.addPostData("voice_md5", this.f50610f);
                                if (!this.f50609e) {
                                    if (this.f50608d.postMultiNetData() == null || !this.f50608d.getNetContext().getResponse().isRequestSuccess()) {
                                        this.f50607c.d(a2);
                                        ChunkUploadDatabaseService.saveChunkUploadData(this.f50607c);
                                        randomAccessFile.close();
                                    } else {
                                        z = false;
                                        if (!z) {
                                            pVar.f(this.f50608d.getServerErrorCode());
                                            pVar.g(this.f50608d.getErrorString());
                                            pVar.e(this.f50607c);
                                            pVar.h(false);
                                            return pVar;
                                        }
                                    }
                                }
                                z = true;
                                if (!z) {
                                }
                            }
                            a2++;
                            j = 30720;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    pVar.h(false);
                    randomAccessFile.close();
                    return pVar;
                }
            }
            pVar.h(true);
            return pVar;
        }
    }

    /* renamed from: d.b.h0.r.g0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1080b {

        /* renamed from: a  reason: collision with root package name */
        public String f50611a;

        /* renamed from: b  reason: collision with root package name */
        public String f50612b;

        public C1080b(b bVar, String str, String str2) {
            this.f50611a = str;
            this.f50612b = str2;
        }

        public String a() {
            return this.f50611a;
        }

        public String b() {
            return this.f50612b;
        }
    }

    public b(String str, String str2) {
        this.f50602d = str;
        this.f50603e = str2;
    }

    public void a(String str, int i) {
        this.f50604f.add(new C1080b(this, str, String.valueOf(i)));
    }

    public final long b(long j) {
        int i = ((j % 30720) > 0L ? 1 : ((j % 30720) == 0L ? 0 : -1));
        long j2 = j / 30720;
        return i == 0 ? j2 : j2 + 1;
    }

    public final String c(String str, o oVar) {
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f50603e);
        this.f50599a = netWork;
        netWork.addPostData("voice_md5", oVar.b());
        if (ListUtils.getCount(this.f50604f) != 0) {
            for (C1080b c1080b : this.f50604f) {
                if (c1080b != null) {
                    this.f50599a.addPostData(c1080b.a(), c1080b.b());
                }
            }
        }
        String postNetData = this.f50599a.postNetData();
        if (postNetData != null && this.f50599a.getNetContext().getResponse().isRequestSuccess()) {
            ChunkUploadDatabaseService.delChunkUploadData(str);
            return postNetData;
        }
        oVar.d((int) b(oVar.c()));
        ChunkUploadDatabaseService.saveChunkUploadData(oVar);
        this.f50601c.f(this.f50599a.getServerErrorCode());
        this.f50601c.g(this.f50599a.getErrorString());
        this.f50601c.h(false);
        return null;
    }

    public p d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                this.f50599a = new NetWork(TbConfig.SERVER_ADDRESS + this.f50602d);
                return e(str, file);
            }
            return null;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public final p e(String str, File file) throws IOException {
        String c2;
        String b2 = q.b(FileHelper.GetStreamFromFile(file));
        if (b2 != null && b2.length() > 0) {
            b2 = b2.toLowerCase();
        }
        o chunkUploadDataByMd5 = ChunkUploadDatabaseService.getChunkUploadDataByMd5(b2);
        if (chunkUploadDataByMd5 == null) {
            chunkUploadDataByMd5 = new o();
            chunkUploadDataByMd5.e(b2);
            chunkUploadDataByMd5.d(0);
            chunkUploadDataByMd5.f(file.length());
        }
        o oVar = chunkUploadDataByMd5;
        a aVar = new a(this, str, oVar, TbConfig.SERVER_ADDRESS + this.f50602d, b2);
        this.f50600b = aVar;
        p a2 = aVar.a();
        this.f50601c = a2;
        if (a2.d() && (c2 = c(b2, oVar)) != null && !c2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(c2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                oVar.e(audioInfoData.getVoiceId());
                this.f50601c.e(oVar);
            } else {
                this.f50601c.f(audioInfoData.getErrorCode());
                this.f50601c.g(audioInfoData.getErrorUserMsg());
                this.f50601c.h(false);
            }
        }
        return this.f50601c;
    }
}
