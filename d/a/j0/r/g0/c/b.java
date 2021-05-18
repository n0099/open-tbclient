package d.a.j0.r.g0.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ChunkUploadDatabaseService;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import d.a.j0.s.c.q;
import d.a.j0.s.c.r;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public NetWork f49790a;

    /* renamed from: b  reason: collision with root package name */
    public a f49791b;

    /* renamed from: c  reason: collision with root package name */
    public r f49792c;

    /* renamed from: d  reason: collision with root package name */
    public String f49793d;

    /* renamed from: e  reason: collision with root package name */
    public String f49794e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1131b> f49795f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f49796a;

        /* renamed from: b  reason: collision with root package name */
        public String f49797b;

        /* renamed from: c  reason: collision with root package name */
        public q f49798c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f49799d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f49800e = false;

        /* renamed from: f  reason: collision with root package name */
        public String f49801f;

        public a(b bVar, String str, q qVar, String str2, String str3) {
            this.f49796a = null;
            this.f49797b = null;
            this.f49798c = null;
            this.f49801f = null;
            this.f49796a = str;
            this.f49798c = qVar;
            this.f49797b = str2;
            this.f49801f = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x010d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public r a() throws IOException {
            boolean z;
            r rVar = new r();
            long c2 = this.f49798c.c();
            long j = 30720;
            long j2 = c2 / 30720;
            if (c2 % 30720 != 0) {
                j2++;
            }
            int a2 = this.f49798c.a();
            if (a2 < j2) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f49796a), com.baidu.mapsdkplatform.comapi.map.r.f7772a);
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
                                NetWork netWork = new NetWork(this.f49797b);
                                this.f49799d = netWork;
                                netWork.addPostData("voice_chunk", bArr);
                                this.f49799d.addPostData("chunk_md5", this.f49798c.b());
                                this.f49799d.addPostData(CloudStabilityUBCUtils.KEY_LENGTH, String.valueOf(read));
                                this.f49799d.addPostData("offset", String.valueOf(a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.f49799d.addPostData("total_length", String.valueOf(c2));
                                this.f49799d.addPostData("chunk_no", String.valueOf(a2 + 1));
                                this.f49799d.addPostData("total_num", String.valueOf(j2));
                                this.f49799d.addPostData("voice_md5", this.f49801f);
                                if (!this.f49800e) {
                                    if (this.f49799d.postMultiNetData() == null || !this.f49799d.getNetContext().getResponse().isRequestSuccess()) {
                                        this.f49798c.d(a2);
                                        ChunkUploadDatabaseService.saveChunkUploadData(this.f49798c);
                                        randomAccessFile.close();
                                    } else {
                                        z = false;
                                        if (!z) {
                                            rVar.f(this.f49799d.getServerErrorCode());
                                            rVar.g(this.f49799d.getErrorString());
                                            rVar.e(this.f49798c);
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

    /* renamed from: d.a.j0.r.g0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1131b {

        /* renamed from: a  reason: collision with root package name */
        public String f49802a;

        /* renamed from: b  reason: collision with root package name */
        public String f49803b;

        public C1131b(b bVar, String str, String str2) {
            this.f49802a = str;
            this.f49803b = str2;
        }

        public String a() {
            return this.f49802a;
        }

        public String b() {
            return this.f49803b;
        }
    }

    public b(String str, String str2) {
        this.f49793d = str;
        this.f49794e = str2;
    }

    public void a(String str, int i2) {
        this.f49795f.add(new C1131b(this, str, String.valueOf(i2)));
    }

    public final long b(long j) {
        int i2 = ((j % 30720) > 0L ? 1 : ((j % 30720) == 0L ? 0 : -1));
        long j2 = j / 30720;
        return i2 == 0 ? j2 : j2 + 1;
    }

    public final String c(String str, q qVar) {
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f49794e);
        this.f49790a = netWork;
        netWork.addPostData("voice_md5", qVar.b());
        if (ListUtils.getCount(this.f49795f) != 0) {
            for (C1131b c1131b : this.f49795f) {
                if (c1131b != null) {
                    this.f49790a.addPostData(c1131b.a(), c1131b.b());
                }
            }
        }
        String postNetData = this.f49790a.postNetData();
        if (postNetData != null && this.f49790a.getNetContext().getResponse().isRequestSuccess()) {
            ChunkUploadDatabaseService.delChunkUploadData(str);
            return postNetData;
        }
        qVar.d((int) b(qVar.c()));
        ChunkUploadDatabaseService.saveChunkUploadData(qVar);
        this.f49792c.f(this.f49790a.getServerErrorCode());
        this.f49792c.g(this.f49790a.getErrorString());
        this.f49792c.h(false);
        return null;
    }

    public r d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                this.f49790a = new NetWork(TbConfig.SERVER_ADDRESS + this.f49793d);
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
        a aVar = new a(this, str, qVar, TbConfig.SERVER_ADDRESS + this.f49793d, b2);
        this.f49791b = aVar;
        r a2 = aVar.a();
        this.f49792c = a2;
        if (a2.d() && (c2 = c(b2, qVar)) != null && !c2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(c2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                qVar.e(audioInfoData.getVoiceId());
                this.f49792c.e(qVar);
            } else {
                this.f49792c.f(audioInfoData.getErrorCode());
                this.f49792c.g(audioInfoData.getErrorUserMsg());
                this.f49792c.h(false);
            }
        }
        return this.f49792c;
    }
}
