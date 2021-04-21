package d.b.i0.r.g0.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ChunkUploadDatabaseService;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import d.b.i0.s.c.q;
import d.b.i0.s.c.r;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public NetWork f51343a;

    /* renamed from: b  reason: collision with root package name */
    public a f51344b;

    /* renamed from: c  reason: collision with root package name */
    public r f51345c;

    /* renamed from: d  reason: collision with root package name */
    public String f51346d;

    /* renamed from: e  reason: collision with root package name */
    public String f51347e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1116b> f51348f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f51349a;

        /* renamed from: b  reason: collision with root package name */
        public String f51350b;

        /* renamed from: c  reason: collision with root package name */
        public q f51351c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f51352d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f51353e = false;

        /* renamed from: f  reason: collision with root package name */
        public String f51354f;

        public a(b bVar, String str, q qVar, String str2, String str3) {
            this.f51349a = null;
            this.f51350b = null;
            this.f51351c = null;
            this.f51354f = null;
            this.f51349a = str;
            this.f51351c = qVar;
            this.f51350b = str2;
            this.f51354f = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x010d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public r a() throws IOException {
            boolean z;
            r rVar = new r();
            long c2 = this.f51351c.c();
            long j = 30720;
            long j2 = c2 / 30720;
            if (c2 % 30720 != 0) {
                j2++;
            }
            int a2 = this.f51351c.a();
            if (a2 < j2) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f51349a), com.baidu.mapsdkplatform.comapi.map.r.f7699a);
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
                                NetWork netWork = new NetWork(this.f51350b);
                                this.f51352d = netWork;
                                netWork.addPostData("voice_chunk", bArr);
                                this.f51352d.addPostData("chunk_md5", this.f51351c.b());
                                this.f51352d.addPostData("length", String.valueOf(read));
                                this.f51352d.addPostData("offset", String.valueOf(a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.f51352d.addPostData("total_length", String.valueOf(c2));
                                this.f51352d.addPostData("chunk_no", String.valueOf(a2 + 1));
                                this.f51352d.addPostData("total_num", String.valueOf(j2));
                                this.f51352d.addPostData("voice_md5", this.f51354f);
                                if (!this.f51353e) {
                                    if (this.f51352d.postMultiNetData() == null || !this.f51352d.getNetContext().getResponse().isRequestSuccess()) {
                                        this.f51351c.d(a2);
                                        ChunkUploadDatabaseService.saveChunkUploadData(this.f51351c);
                                        randomAccessFile.close();
                                    } else {
                                        z = false;
                                        if (!z) {
                                            rVar.f(this.f51352d.getServerErrorCode());
                                            rVar.g(this.f51352d.getErrorString());
                                            rVar.e(this.f51351c);
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

    /* renamed from: d.b.i0.r.g0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1116b {

        /* renamed from: a  reason: collision with root package name */
        public String f51355a;

        /* renamed from: b  reason: collision with root package name */
        public String f51356b;

        public C1116b(b bVar, String str, String str2) {
            this.f51355a = str;
            this.f51356b = str2;
        }

        public String a() {
            return this.f51355a;
        }

        public String b() {
            return this.f51356b;
        }
    }

    public b(String str, String str2) {
        this.f51346d = str;
        this.f51347e = str2;
    }

    public void a(String str, int i) {
        this.f51348f.add(new C1116b(this, str, String.valueOf(i)));
    }

    public final long b(long j) {
        int i = ((j % 30720) > 0L ? 1 : ((j % 30720) == 0L ? 0 : -1));
        long j2 = j / 30720;
        return i == 0 ? j2 : j2 + 1;
    }

    public final String c(String str, q qVar) {
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f51347e);
        this.f51343a = netWork;
        netWork.addPostData("voice_md5", qVar.b());
        if (ListUtils.getCount(this.f51348f) != 0) {
            for (C1116b c1116b : this.f51348f) {
                if (c1116b != null) {
                    this.f51343a.addPostData(c1116b.a(), c1116b.b());
                }
            }
        }
        String postNetData = this.f51343a.postNetData();
        if (postNetData != null && this.f51343a.getNetContext().getResponse().isRequestSuccess()) {
            ChunkUploadDatabaseService.delChunkUploadData(str);
            return postNetData;
        }
        qVar.d((int) b(qVar.c()));
        ChunkUploadDatabaseService.saveChunkUploadData(qVar);
        this.f51345c.f(this.f51343a.getServerErrorCode());
        this.f51345c.g(this.f51343a.getErrorString());
        this.f51345c.h(false);
        return null;
    }

    public r d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                this.f51343a = new NetWork(TbConfig.SERVER_ADDRESS + this.f51346d);
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
        a aVar = new a(this, str, qVar, TbConfig.SERVER_ADDRESS + this.f51346d, b2);
        this.f51344b = aVar;
        r a2 = aVar.a();
        this.f51345c = a2;
        if (a2.d() && (c2 = c(b2, qVar)) != null && !c2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(c2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                qVar.e(audioInfoData.getVoiceId());
                this.f51345c.e(qVar);
            } else {
                this.f51345c.f(audioInfoData.getErrorCode());
                this.f51345c.g(audioInfoData.getErrorUserMsg());
                this.f51345c.h(false);
            }
        }
        return this.f51345c;
    }
}
