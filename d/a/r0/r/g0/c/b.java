package d.a.r0.r.g0.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ChunkUploadDatabaseService;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.s.c.q;
import d.a.r0.s.c.r;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetWork f55754a;

    /* renamed from: b  reason: collision with root package name */
    public a f55755b;

    /* renamed from: c  reason: collision with root package name */
    public r f55756c;

    /* renamed from: d  reason: collision with root package name */
    public String f55757d;

    /* renamed from: e  reason: collision with root package name */
    public String f55758e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1259b> f55759f;

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f55760a;

        /* renamed from: b  reason: collision with root package name */
        public String f55761b;

        /* renamed from: c  reason: collision with root package name */
        public q f55762c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f55763d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f55764e;

        /* renamed from: f  reason: collision with root package name */
        public String f55765f;

        public a(b bVar, String str, q qVar, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, qVar, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55760a = null;
            this.f55761b = null;
            this.f55762c = null;
            this.f55764e = false;
            this.f55765f = null;
            this.f55760a = str;
            this.f55762c = qVar;
            this.f55761b = str2;
            this.f55765f = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x00f6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0111 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public r a() throws IOException {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                r rVar = new r();
                long c2 = this.f55762c.c();
                long j = 30720;
                long j2 = c2 / 30720;
                if (c2 % 30720 != 0) {
                    j2++;
                }
                int a2 = this.f55762c.a();
                if (a2 < j2) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f55760a), com.baidu.mapsdkplatform.comapi.map.r.f7745a);
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
                                    NetWork netWork = new NetWork(this.f55761b);
                                    this.f55763d = netWork;
                                    netWork.addPostData("voice_chunk", bArr);
                                    this.f55763d.addPostData("chunk_md5", this.f55762c.b());
                                    this.f55763d.addPostData(CloudStabilityUBCUtils.KEY_LENGTH, String.valueOf(read));
                                    this.f55763d.addPostData("offset", String.valueOf(a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                    this.f55763d.addPostData("total_length", String.valueOf(c2));
                                    this.f55763d.addPostData("chunk_no", String.valueOf(a2 + 1));
                                    this.f55763d.addPostData("total_num", String.valueOf(j2));
                                    this.f55763d.addPostData("voice_md5", this.f55765f);
                                    if (!this.f55764e) {
                                        if (this.f55763d.postMultiNetData() == null || !this.f55763d.getNetContext().getResponse().isRequestSuccess()) {
                                            this.f55762c.d(a2);
                                            ChunkUploadDatabaseService.saveChunkUploadData(this.f55762c);
                                            randomAccessFile.close();
                                        } else {
                                            z = false;
                                            if (!z) {
                                                rVar.f(this.f55763d.getServerErrorCode());
                                                rVar.g(this.f55763d.getErrorString());
                                                rVar.e(this.f55762c);
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
            return (r) invokeV.objValue;
        }
    }

    /* renamed from: d.a.r0.r.g0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1259b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f55766a;

        /* renamed from: b  reason: collision with root package name */
        public String f55767b;

        public C1259b(b bVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55766a = str;
            this.f55767b = str2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55766a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55767b : (String) invokeV.objValue;
        }
    }

    public b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55759f = new ArrayList();
        this.f55757d = str;
        this.f55758e = str2;
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            this.f55759f.add(new C1259b(this, str, String.valueOf(i2)));
        }
    }

    public final long b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            int i2 = ((j % 30720) > 0L ? 1 : ((j % 30720) == 0L ? 0 : -1));
            long j2 = j / 30720;
            return i2 == 0 ? j2 : j2 + 1;
        }
        return invokeJ.longValue;
    }

    public final String c(String str, q qVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, qVar)) == null) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f55758e);
            this.f55754a = netWork;
            netWork.addPostData("voice_md5", qVar.b());
            if (ListUtils.getCount(this.f55759f) != 0) {
                for (C1259b c1259b : this.f55759f) {
                    if (c1259b != null) {
                        this.f55754a.addPostData(c1259b.a(), c1259b.b());
                    }
                }
            }
            String postNetData = this.f55754a.postNetData();
            if (postNetData != null && this.f55754a.getNetContext().getResponse().isRequestSuccess()) {
                ChunkUploadDatabaseService.delChunkUploadData(str);
                return postNetData;
            }
            qVar.d((int) b(qVar.c()));
            ChunkUploadDatabaseService.saveChunkUploadData(qVar);
            this.f55756c.f(this.f55754a.getServerErrorCode());
            this.f55756c.g(this.f55754a.getErrorString());
            this.f55756c.h(false);
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public r d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    this.f55754a = new NetWork(TbConfig.SERVER_ADDRESS + this.f55757d);
                    return e(str, file);
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (r) invokeL.objValue;
    }

    public final r e(String str, File file) throws IOException {
        InterceptResult invokeLL;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, file)) == null) {
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
            a aVar = new a(this, str, qVar, TbConfig.SERVER_ADDRESS + this.f55757d, b2);
            this.f55755b = aVar;
            r a2 = aVar.a();
            this.f55756c = a2;
            if (a2.d() && (c2 = c(b2, qVar)) != null && !c2.equals("")) {
                AudioInfoData audioInfoData = new AudioInfoData();
                audioInfoData.parserJson(c2);
                if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                    qVar.e(audioInfoData.getVoiceId());
                    this.f55756c.e(qVar);
                } else {
                    this.f55756c.f(audioInfoData.getErrorCode());
                    this.f55756c.g(audioInfoData.getErrorUserMsg());
                    this.f55756c.h(false);
                }
            }
            return this.f55756c;
        }
        return (r) invokeLL.objValue;
    }
}
