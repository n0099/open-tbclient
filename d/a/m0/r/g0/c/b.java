package d.a.m0.r.g0.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ChunkUploadDatabaseService;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import d.a.m0.s.c.q;
import d.a.m0.s.c.r;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public NetWork f53509a;

    /* renamed from: b  reason: collision with root package name */
    public a f53510b;

    /* renamed from: c  reason: collision with root package name */
    public r f53511c;

    /* renamed from: d  reason: collision with root package name */
    public String f53512d;

    /* renamed from: e  reason: collision with root package name */
    public String f53513e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1196b> f53514f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f53515a;

        /* renamed from: b  reason: collision with root package name */
        public String f53516b;

        /* renamed from: c  reason: collision with root package name */
        public q f53517c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f53518d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f53519e = false;

        /* renamed from: f  reason: collision with root package name */
        public String f53520f;

        public a(b bVar, String str, q qVar, String str2, String str3) {
            this.f53515a = null;
            this.f53516b = null;
            this.f53517c = null;
            this.f53520f = null;
            this.f53515a = str;
            this.f53517c = qVar;
            this.f53516b = str2;
            this.f53520f = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x010d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public r a() throws IOException {
            boolean z;
            r rVar = new r();
            long c2 = this.f53517c.c();
            long j = 30720;
            long j2 = c2 / 30720;
            if (c2 % 30720 != 0) {
                j2++;
            }
            int a2 = this.f53517c.a();
            if (a2 < j2) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f53515a), com.baidu.mapsdkplatform.comapi.map.r.f7715a);
                int i2 = a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                if (randomAccessFile.skipBytes(i2) >= i2) {
                    while (true) {
                        long j3 = a2;
                        if (j3 < j2) {
                            long j4 = j2 - 1;
                            int i3 = j3 == j4 ? (int) (c2 - (j4 * j)) : TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                            byte[] bArr = new byte[i3];
                            int read = randomAccessFile.read(bArr, 0, i3);
                            if (read != -1) {
                                NetWork netWork = new NetWork(this.f53516b);
                                this.f53518d = netWork;
                                netWork.addPostData("voice_chunk", bArr);
                                this.f53518d.addPostData("chunk_md5", this.f53517c.b());
                                this.f53518d.addPostData(CloudStabilityUBCUtils.KEY_LENGTH, String.valueOf(read));
                                this.f53518d.addPostData("offset", String.valueOf(a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.f53518d.addPostData("total_length", String.valueOf(c2));
                                this.f53518d.addPostData("chunk_no", String.valueOf(a2 + 1));
                                this.f53518d.addPostData("total_num", String.valueOf(j2));
                                this.f53518d.addPostData("voice_md5", this.f53520f);
                                if (!this.f53519e) {
                                    if (this.f53518d.postMultiNetData() == null || !this.f53518d.getNetContext().getResponse().isRequestSuccess()) {
                                        this.f53517c.d(a2);
                                        ChunkUploadDatabaseService.saveChunkUploadData(this.f53517c);
                                        randomAccessFile.close();
                                    } else {
                                        z = false;
                                        if (!z) {
                                            rVar.f(this.f53518d.getServerErrorCode());
                                            rVar.g(this.f53518d.getErrorString());
                                            rVar.e(this.f53517c);
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

    /* renamed from: d.a.m0.r.g0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1196b {

        /* renamed from: a  reason: collision with root package name */
        public String f53521a;

        /* renamed from: b  reason: collision with root package name */
        public String f53522b;

        public C1196b(b bVar, String str, String str2) {
            this.f53521a = str;
            this.f53522b = str2;
        }

        public String a() {
            return this.f53521a;
        }

        public String b() {
            return this.f53522b;
        }
    }

    public b(String str, String str2) {
        this.f53512d = str;
        this.f53513e = str2;
    }

    public void a(String str, int i2) {
        this.f53514f.add(new C1196b(this, str, String.valueOf(i2)));
    }

    public final long b(long j) {
        int i2 = ((j % 30720) > 0L ? 1 : ((j % 30720) == 0L ? 0 : -1));
        long j2 = j / 30720;
        return i2 == 0 ? j2 : j2 + 1;
    }

    public final String c(String str, q qVar) {
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f53513e);
        this.f53509a = netWork;
        netWork.addPostData("voice_md5", qVar.b());
        if (ListUtils.getCount(this.f53514f) != 0) {
            for (C1196b c1196b : this.f53514f) {
                if (c1196b != null) {
                    this.f53509a.addPostData(c1196b.a(), c1196b.b());
                }
            }
        }
        String postNetData = this.f53509a.postNetData();
        if (postNetData != null && this.f53509a.getNetContext().getResponse().isRequestSuccess()) {
            ChunkUploadDatabaseService.delChunkUploadData(str);
            return postNetData;
        }
        qVar.d((int) b(qVar.c()));
        ChunkUploadDatabaseService.saveChunkUploadData(qVar);
        this.f53511c.f(this.f53509a.getServerErrorCode());
        this.f53511c.g(this.f53509a.getErrorString());
        this.f53511c.h(false);
        return null;
    }

    public r d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                this.f53509a = new NetWork(TbConfig.SERVER_ADDRESS + this.f53512d);
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
        String b2 = d.a.c.e.p.q.b(FileHelper.GetStreamFromFile(file));
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
        a aVar = new a(this, str, qVar, TbConfig.SERVER_ADDRESS + this.f53512d, b2);
        this.f53510b = aVar;
        r a2 = aVar.a();
        this.f53511c = a2;
        if (a2.d() && (c2 = c(b2, qVar)) != null && !c2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(c2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                qVar.e(audioInfoData.getVoiceId());
                this.f53511c.e(qVar);
            } else {
                this.f53511c.f(audioInfoData.getErrorCode());
                this.f53511c.g(audioInfoData.getErrorUserMsg());
                this.f53511c.h(false);
            }
        }
        return this.f53511c;
    }
}
