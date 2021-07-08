package d.a.o0.r.g0.c;

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
import d.a.o0.s.c.q;
import d.a.o0.s.c.r;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetWork f52460a;

    /* renamed from: b  reason: collision with root package name */
    public a f52461b;

    /* renamed from: c  reason: collision with root package name */
    public r f52462c;

    /* renamed from: d  reason: collision with root package name */
    public String f52463d;

    /* renamed from: e  reason: collision with root package name */
    public String f52464e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1208b> f52465f;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f52466a;

        /* renamed from: b  reason: collision with root package name */
        public String f52467b;

        /* renamed from: c  reason: collision with root package name */
        public q f52468c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f52469d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f52470e;

        /* renamed from: f  reason: collision with root package name */
        public String f52471f;

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
            this.f52466a = null;
            this.f52467b = null;
            this.f52468c = null;
            this.f52470e = false;
            this.f52471f = null;
            this.f52466a = str;
            this.f52468c = qVar;
            this.f52467b = str2;
            this.f52471f = str3;
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
                long c2 = this.f52468c.c();
                long j = 30720;
                long j2 = c2 / 30720;
                if (c2 % 30720 != 0) {
                    j2++;
                }
                int a2 = this.f52468c.a();
                if (a2 < j2) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f52466a), com.baidu.mapsdkplatform.comapi.map.r.f7762a);
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
                                    NetWork netWork = new NetWork(this.f52467b);
                                    this.f52469d = netWork;
                                    netWork.addPostData("voice_chunk", bArr);
                                    this.f52469d.addPostData("chunk_md5", this.f52468c.b());
                                    this.f52469d.addPostData(CloudStabilityUBCUtils.KEY_LENGTH, String.valueOf(read));
                                    this.f52469d.addPostData("offset", String.valueOf(a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                    this.f52469d.addPostData("total_length", String.valueOf(c2));
                                    this.f52469d.addPostData("chunk_no", String.valueOf(a2 + 1));
                                    this.f52469d.addPostData("total_num", String.valueOf(j2));
                                    this.f52469d.addPostData("voice_md5", this.f52471f);
                                    if (!this.f52470e) {
                                        if (this.f52469d.postMultiNetData() == null || !this.f52469d.getNetContext().getResponse().isRequestSuccess()) {
                                            this.f52468c.d(a2);
                                            ChunkUploadDatabaseService.saveChunkUploadData(this.f52468c);
                                            randomAccessFile.close();
                                        } else {
                                            z = false;
                                            if (!z) {
                                                rVar.f(this.f52469d.getServerErrorCode());
                                                rVar.g(this.f52469d.getErrorString());
                                                rVar.e(this.f52468c);
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

    /* renamed from: d.a.o0.r.g0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1208b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f52472a;

        /* renamed from: b  reason: collision with root package name */
        public String f52473b;

        public C1208b(b bVar, String str, String str2) {
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
            this.f52472a = str;
            this.f52473b = str2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52472a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52473b : (String) invokeV.objValue;
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
        this.f52465f = new ArrayList();
        this.f52463d = str;
        this.f52464e = str2;
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            this.f52465f.add(new C1208b(this, str, String.valueOf(i2)));
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
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f52464e);
            this.f52460a = netWork;
            netWork.addPostData("voice_md5", qVar.b());
            if (ListUtils.getCount(this.f52465f) != 0) {
                for (C1208b c1208b : this.f52465f) {
                    if (c1208b != null) {
                        this.f52460a.addPostData(c1208b.a(), c1208b.b());
                    }
                }
            }
            String postNetData = this.f52460a.postNetData();
            if (postNetData != null && this.f52460a.getNetContext().getResponse().isRequestSuccess()) {
                ChunkUploadDatabaseService.delChunkUploadData(str);
                return postNetData;
            }
            qVar.d((int) b(qVar.c()));
            ChunkUploadDatabaseService.saveChunkUploadData(qVar);
            this.f52462c.f(this.f52460a.getServerErrorCode());
            this.f52462c.g(this.f52460a.getErrorString());
            this.f52462c.h(false);
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
                    this.f52460a = new NetWork(TbConfig.SERVER_ADDRESS + this.f52463d);
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
            a aVar = new a(this, str, qVar, TbConfig.SERVER_ADDRESS + this.f52463d, b2);
            this.f52461b = aVar;
            r a2 = aVar.a();
            this.f52462c = a2;
            if (a2.d() && (c2 = c(b2, qVar)) != null && !c2.equals("")) {
                AudioInfoData audioInfoData = new AudioInfoData();
                audioInfoData.parserJson(c2);
                if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                    qVar.e(audioInfoData.getVoiceId());
                    this.f52462c.e(qVar);
                } else {
                    this.f52462c.f(audioInfoData.getErrorCode());
                    this.f52462c.g(audioInfoData.getErrorUserMsg());
                    this.f52462c.h(false);
                }
            }
            return this.f52462c;
        }
        return (r) invokeLL.objValue;
    }
}
