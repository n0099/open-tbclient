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
    public NetWork f50600a;

    /* renamed from: b  reason: collision with root package name */
    public a f50601b;

    /* renamed from: c  reason: collision with root package name */
    public p f50602c;

    /* renamed from: d  reason: collision with root package name */
    public String f50603d;

    /* renamed from: e  reason: collision with root package name */
    public String f50604e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1081b> f50605f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f50606a;

        /* renamed from: b  reason: collision with root package name */
        public String f50607b;

        /* renamed from: c  reason: collision with root package name */
        public o f50608c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f50609d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f50610e = false;

        /* renamed from: f  reason: collision with root package name */
        public String f50611f;

        public a(b bVar, String str, o oVar, String str2, String str3) {
            this.f50606a = null;
            this.f50607b = null;
            this.f50608c = null;
            this.f50611f = null;
            this.f50606a = str;
            this.f50608c = oVar;
            this.f50607b = str2;
            this.f50611f = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x010d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public p a() throws IOException {
            boolean z;
            p pVar = new p();
            long c2 = this.f50608c.c();
            long j = 30720;
            long j2 = c2 / 30720;
            if (c2 % 30720 != 0) {
                j2++;
            }
            int a2 = this.f50608c.a();
            if (a2 < j2) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f50606a), r.f7664a);
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
                                NetWork netWork = new NetWork(this.f50607b);
                                this.f50609d = netWork;
                                netWork.addPostData("voice_chunk", bArr);
                                this.f50609d.addPostData("chunk_md5", this.f50608c.b());
                                this.f50609d.addPostData("length", String.valueOf(read));
                                this.f50609d.addPostData("offset", String.valueOf(a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.f50609d.addPostData("total_length", String.valueOf(c2));
                                this.f50609d.addPostData("chunk_no", String.valueOf(a2 + 1));
                                this.f50609d.addPostData("total_num", String.valueOf(j2));
                                this.f50609d.addPostData("voice_md5", this.f50611f);
                                if (!this.f50610e) {
                                    if (this.f50609d.postMultiNetData() == null || !this.f50609d.getNetContext().getResponse().isRequestSuccess()) {
                                        this.f50608c.d(a2);
                                        ChunkUploadDatabaseService.saveChunkUploadData(this.f50608c);
                                        randomAccessFile.close();
                                    } else {
                                        z = false;
                                        if (!z) {
                                            pVar.f(this.f50609d.getServerErrorCode());
                                            pVar.g(this.f50609d.getErrorString());
                                            pVar.e(this.f50608c);
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
    public class C1081b {

        /* renamed from: a  reason: collision with root package name */
        public String f50612a;

        /* renamed from: b  reason: collision with root package name */
        public String f50613b;

        public C1081b(b bVar, String str, String str2) {
            this.f50612a = str;
            this.f50613b = str2;
        }

        public String a() {
            return this.f50612a;
        }

        public String b() {
            return this.f50613b;
        }
    }

    public b(String str, String str2) {
        this.f50603d = str;
        this.f50604e = str2;
    }

    public void a(String str, int i) {
        this.f50605f.add(new C1081b(this, str, String.valueOf(i)));
    }

    public final long b(long j) {
        int i = ((j % 30720) > 0L ? 1 : ((j % 30720) == 0L ? 0 : -1));
        long j2 = j / 30720;
        return i == 0 ? j2 : j2 + 1;
    }

    public final String c(String str, o oVar) {
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f50604e);
        this.f50600a = netWork;
        netWork.addPostData("voice_md5", oVar.b());
        if (ListUtils.getCount(this.f50605f) != 0) {
            for (C1081b c1081b : this.f50605f) {
                if (c1081b != null) {
                    this.f50600a.addPostData(c1081b.a(), c1081b.b());
                }
            }
        }
        String postNetData = this.f50600a.postNetData();
        if (postNetData != null && this.f50600a.getNetContext().getResponse().isRequestSuccess()) {
            ChunkUploadDatabaseService.delChunkUploadData(str);
            return postNetData;
        }
        oVar.d((int) b(oVar.c()));
        ChunkUploadDatabaseService.saveChunkUploadData(oVar);
        this.f50602c.f(this.f50600a.getServerErrorCode());
        this.f50602c.g(this.f50600a.getErrorString());
        this.f50602c.h(false);
        return null;
    }

    public p d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                this.f50600a = new NetWork(TbConfig.SERVER_ADDRESS + this.f50603d);
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
        a aVar = new a(this, str, oVar, TbConfig.SERVER_ADDRESS + this.f50603d, b2);
        this.f50601b = aVar;
        p a2 = aVar.a();
        this.f50602c = a2;
        if (a2.d() && (c2 = c(b2, oVar)) != null && !c2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(c2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                oVar.e(audioInfoData.getVoiceId());
                this.f50602c.e(oVar);
            } else {
                this.f50602c.f(audioInfoData.getErrorCode());
                this.f50602c.g(audioInfoData.getErrorUserMsg());
                this.f50602c.h(false);
            }
        }
        return this.f50602c;
    }
}
