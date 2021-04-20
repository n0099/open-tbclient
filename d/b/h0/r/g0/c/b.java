package d.b.h0.r.g0.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ChunkUploadDatabaseService;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import d.b.h0.s.c.q;
import d.b.h0.s.c.r;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public NetWork f51007a;

    /* renamed from: b  reason: collision with root package name */
    public a f51008b;

    /* renamed from: c  reason: collision with root package name */
    public r f51009c;

    /* renamed from: d  reason: collision with root package name */
    public String f51010d;

    /* renamed from: e  reason: collision with root package name */
    public String f51011e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1094b> f51012f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f51013a;

        /* renamed from: b  reason: collision with root package name */
        public String f51014b;

        /* renamed from: c  reason: collision with root package name */
        public q f51015c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f51016d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f51017e = false;

        /* renamed from: f  reason: collision with root package name */
        public String f51018f;

        public a(b bVar, String str, q qVar, String str2, String str3) {
            this.f51013a = null;
            this.f51014b = null;
            this.f51015c = null;
            this.f51018f = null;
            this.f51013a = str;
            this.f51015c = qVar;
            this.f51014b = str2;
            this.f51018f = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x010d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public r a() throws IOException {
            boolean z;
            r rVar = new r();
            long c2 = this.f51015c.c();
            long j = 30720;
            long j2 = c2 / 30720;
            if (c2 % 30720 != 0) {
                j2++;
            }
            int a2 = this.f51015c.a();
            if (a2 < j2) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f51013a), com.baidu.mapsdkplatform.comapi.map.r.f7699a);
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
                                NetWork netWork = new NetWork(this.f51014b);
                                this.f51016d = netWork;
                                netWork.addPostData("voice_chunk", bArr);
                                this.f51016d.addPostData("chunk_md5", this.f51015c.b());
                                this.f51016d.addPostData("length", String.valueOf(read));
                                this.f51016d.addPostData("offset", String.valueOf(a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.f51016d.addPostData("total_length", String.valueOf(c2));
                                this.f51016d.addPostData("chunk_no", String.valueOf(a2 + 1));
                                this.f51016d.addPostData("total_num", String.valueOf(j2));
                                this.f51016d.addPostData("voice_md5", this.f51018f);
                                if (!this.f51017e) {
                                    if (this.f51016d.postMultiNetData() == null || !this.f51016d.getNetContext().getResponse().isRequestSuccess()) {
                                        this.f51015c.d(a2);
                                        ChunkUploadDatabaseService.saveChunkUploadData(this.f51015c);
                                        randomAccessFile.close();
                                    } else {
                                        z = false;
                                        if (!z) {
                                            rVar.f(this.f51016d.getServerErrorCode());
                                            rVar.g(this.f51016d.getErrorString());
                                            rVar.e(this.f51015c);
                                            rVar.h(false);
                                            return rVar;
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
                    rVar.h(false);
                    randomAccessFile.close();
                    return rVar;
                }
            }
            rVar.h(true);
            return rVar;
        }
    }

    /* renamed from: d.b.h0.r.g0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1094b {

        /* renamed from: a  reason: collision with root package name */
        public String f51019a;

        /* renamed from: b  reason: collision with root package name */
        public String f51020b;

        public C1094b(b bVar, String str, String str2) {
            this.f51019a = str;
            this.f51020b = str2;
        }

        public String a() {
            return this.f51019a;
        }

        public String b() {
            return this.f51020b;
        }
    }

    public b(String str, String str2) {
        this.f51010d = str;
        this.f51011e = str2;
    }

    public void a(String str, int i) {
        this.f51012f.add(new C1094b(this, str, String.valueOf(i)));
    }

    public final long b(long j) {
        int i = ((j % 30720) > 0L ? 1 : ((j % 30720) == 0L ? 0 : -1));
        long j2 = j / 30720;
        return i == 0 ? j2 : j2 + 1;
    }

    public final String c(String str, q qVar) {
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f51011e);
        this.f51007a = netWork;
        netWork.addPostData("voice_md5", qVar.b());
        if (ListUtils.getCount(this.f51012f) != 0) {
            for (C1094b c1094b : this.f51012f) {
                if (c1094b != null) {
                    this.f51007a.addPostData(c1094b.a(), c1094b.b());
                }
            }
        }
        String postNetData = this.f51007a.postNetData();
        if (postNetData != null && this.f51007a.getNetContext().getResponse().isRequestSuccess()) {
            ChunkUploadDatabaseService.delChunkUploadData(str);
            return postNetData;
        }
        qVar.d((int) b(qVar.c()));
        ChunkUploadDatabaseService.saveChunkUploadData(qVar);
        this.f51009c.f(this.f51007a.getServerErrorCode());
        this.f51009c.g(this.f51007a.getErrorString());
        this.f51009c.h(false);
        return null;
    }

    public r d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                this.f51007a = new NetWork(TbConfig.SERVER_ADDRESS + this.f51010d);
                return e(str, file);
            }
            return null;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public final r e(String str, File file) throws IOException {
        String c2;
        String b2 = d.b.c.e.p.q.b(FileHelper.GetStreamFromFile(file));
        if (b2 != null && b2.length() > 0) {
            b2 = b2.toLowerCase();
        }
        q chunkUploadDataByMd5 = ChunkUploadDatabaseService.getChunkUploadDataByMd5(b2);
        if (chunkUploadDataByMd5 == null) {
            chunkUploadDataByMd5 = new q();
            chunkUploadDataByMd5.e(b2);
            chunkUploadDataByMd5.d(0);
            chunkUploadDataByMd5.f(file.length());
        }
        q qVar = chunkUploadDataByMd5;
        a aVar = new a(this, str, qVar, TbConfig.SERVER_ADDRESS + this.f51010d, b2);
        this.f51008b = aVar;
        r a2 = aVar.a();
        this.f51009c = a2;
        if (a2.d() && (c2 = c(b2, qVar)) != null && !c2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(c2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                qVar.e(audioInfoData.getVoiceId());
                this.f51009c.e(qVar);
            } else {
                this.f51009c.f(audioInfoData.getErrorCode());
                this.f51009c.g(audioInfoData.getErrorUserMsg());
                this.f51009c.h(false);
            }
        }
        return this.f51009c;
    }
}
