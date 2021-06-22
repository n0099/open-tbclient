package d.a.n0.r.g0.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ChunkUploadDatabaseService;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import d.a.n0.s.c.q;
import d.a.n0.s.c.r;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public NetWork f53616a;

    /* renamed from: b  reason: collision with root package name */
    public a f53617b;

    /* renamed from: c  reason: collision with root package name */
    public r f53618c;

    /* renamed from: d  reason: collision with root package name */
    public String f53619d;

    /* renamed from: e  reason: collision with root package name */
    public String f53620e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1199b> f53621f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f53622a;

        /* renamed from: b  reason: collision with root package name */
        public String f53623b;

        /* renamed from: c  reason: collision with root package name */
        public q f53624c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f53625d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f53626e = false;

        /* renamed from: f  reason: collision with root package name */
        public String f53627f;

        public a(b bVar, String str, q qVar, String str2, String str3) {
            this.f53622a = null;
            this.f53623b = null;
            this.f53624c = null;
            this.f53627f = null;
            this.f53622a = str;
            this.f53624c = qVar;
            this.f53623b = str2;
            this.f53627f = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x010d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public r a() throws IOException {
            boolean z;
            r rVar = new r();
            long c2 = this.f53624c.c();
            long j = 30720;
            long j2 = c2 / 30720;
            if (c2 % 30720 != 0) {
                j2++;
            }
            int a2 = this.f53624c.a();
            if (a2 < j2) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f53622a), com.baidu.mapsdkplatform.comapi.map.r.f7715a);
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
                                NetWork netWork = new NetWork(this.f53623b);
                                this.f53625d = netWork;
                                netWork.addPostData("voice_chunk", bArr);
                                this.f53625d.addPostData("chunk_md5", this.f53624c.b());
                                this.f53625d.addPostData(CloudStabilityUBCUtils.KEY_LENGTH, String.valueOf(read));
                                this.f53625d.addPostData("offset", String.valueOf(a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.f53625d.addPostData("total_length", String.valueOf(c2));
                                this.f53625d.addPostData("chunk_no", String.valueOf(a2 + 1));
                                this.f53625d.addPostData("total_num", String.valueOf(j2));
                                this.f53625d.addPostData("voice_md5", this.f53627f);
                                if (!this.f53626e) {
                                    if (this.f53625d.postMultiNetData() == null || !this.f53625d.getNetContext().getResponse().isRequestSuccess()) {
                                        this.f53624c.d(a2);
                                        ChunkUploadDatabaseService.saveChunkUploadData(this.f53624c);
                                        randomAccessFile.close();
                                    } else {
                                        z = false;
                                        if (!z) {
                                            rVar.f(this.f53625d.getServerErrorCode());
                                            rVar.g(this.f53625d.getErrorString());
                                            rVar.e(this.f53624c);
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

    /* renamed from: d.a.n0.r.g0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1199b {

        /* renamed from: a  reason: collision with root package name */
        public String f53628a;

        /* renamed from: b  reason: collision with root package name */
        public String f53629b;

        public C1199b(b bVar, String str, String str2) {
            this.f53628a = str;
            this.f53629b = str2;
        }

        public String a() {
            return this.f53628a;
        }

        public String b() {
            return this.f53629b;
        }
    }

    public b(String str, String str2) {
        this.f53619d = str;
        this.f53620e = str2;
    }

    public void a(String str, int i2) {
        this.f53621f.add(new C1199b(this, str, String.valueOf(i2)));
    }

    public final long b(long j) {
        int i2 = ((j % 30720) > 0L ? 1 : ((j % 30720) == 0L ? 0 : -1));
        long j2 = j / 30720;
        return i2 == 0 ? j2 : j2 + 1;
    }

    public final String c(String str, q qVar) {
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f53620e);
        this.f53616a = netWork;
        netWork.addPostData("voice_md5", qVar.b());
        if (ListUtils.getCount(this.f53621f) != 0) {
            for (C1199b c1199b : this.f53621f) {
                if (c1199b != null) {
                    this.f53616a.addPostData(c1199b.a(), c1199b.b());
                }
            }
        }
        String postNetData = this.f53616a.postNetData();
        if (postNetData != null && this.f53616a.getNetContext().getResponse().isRequestSuccess()) {
            ChunkUploadDatabaseService.delChunkUploadData(str);
            return postNetData;
        }
        qVar.d((int) b(qVar.c()));
        ChunkUploadDatabaseService.saveChunkUploadData(qVar);
        this.f53618c.f(this.f53616a.getServerErrorCode());
        this.f53618c.g(this.f53616a.getErrorString());
        this.f53618c.h(false);
        return null;
    }

    public r d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                this.f53616a = new NetWork(TbConfig.SERVER_ADDRESS + this.f53619d);
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
        a aVar = new a(this, str, qVar, TbConfig.SERVER_ADDRESS + this.f53619d, b2);
        this.f53617b = aVar;
        r a2 = aVar.a();
        this.f53618c = a2;
        if (a2.d() && (c2 = c(b2, qVar)) != null && !c2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(c2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                qVar.e(audioInfoData.getVoiceId());
                this.f53618c.e(qVar);
            } else {
                this.f53618c.f(audioInfoData.getErrorCode());
                this.f53618c.g(audioInfoData.getErrorUserMsg());
                this.f53618c.h(false);
            }
        }
        return this.f53618c;
    }
}
