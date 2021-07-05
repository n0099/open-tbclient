package com.kwad.sdk.emotion.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.emotion.model.CDNUrl;
import com.kwad.sdk.emotion.model.EmotionInfo;
import com.kwai.filedownloader.i;
import com.kwai.filedownloader.q;
import java.io.File;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile Queue<com.kwai.filedownloader.a> f37194a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Queue<com.kwai.filedownloader.a> f37195b;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void a(String str);
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37194a = new ConcurrentLinkedQueue();
        this.f37195b = new ConcurrentLinkedQueue();
    }

    @Nullable
    public static Bitmap a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, str, z)) == null) {
            if (b.a().b(str, z)) {
                return BitmapFactory.decodeFile(b.a().a(str, z));
            }
            return null;
        }
        return (Bitmap) invokeLZ.objValue;
    }

    private String a(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            if (str2 != null) {
                String substring = str2.substring(str2.lastIndexOf("/") + 1);
                str3 = substring.substring(substring.lastIndexOf("."));
            } else {
                str3 = EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
            }
            return str + str3;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            synchronized (d.class) {
                if (this.f37194a.isEmpty() && this.f37195b.isEmpty()) {
                    return;
                }
                int size = 10 - this.f37195b.size();
                int size2 = this.f37194a.size();
                for (int i2 = 0; i2 < size && i2 < size2; i2++) {
                    com.kwai.filedownloader.a poll = this.f37194a.poll();
                    if (poll != null && !poll.c()) {
                        this.f37195b.offer(poll);
                        poll.e();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String[] strArr, String str, boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), strArr, str, Boolean.valueOf(z), aVar}) == null) {
            if (i2 >= strArr.length) {
                aVar.a();
                return;
            }
            b a2 = b.a();
            String a3 = a(str, strArr[i2]);
            com.kwai.filedownloader.a a4 = q.a().a(strArr[i2]);
            StringBuilder sb = new StringBuilder();
            sb.append(z ? a2.c() : a2.b());
            sb.append(File.separator);
            sb.append(a3);
            this.f37194a.offer(a4.a(sb.toString()).b(false).a((i) new c(this, aVar, a2, str, a3, z, i2, strArr) { // from class: com.kwad.sdk.emotion.b.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f37196a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f37197b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f37198c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f37199d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ boolean f37200e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ int f37201f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String[] f37202g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ d f37203h;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, a2, str, a3, Boolean.valueOf(z), Integer.valueOf(i2), strArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37203h = this;
                    this.f37196a = aVar;
                    this.f37197b = a2;
                    this.f37198c = str;
                    this.f37199d = a3;
                    this.f37200e = z;
                    this.f37201f = i2;
                    this.f37202g = strArr;
                }

                @Override // com.kwad.sdk.emotion.b.c, com.kwai.filedownloader.i
                public void a(com.kwai.filedownloader.a aVar2, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, aVar2, th) == null) {
                        this.f37203h.f37195b.remove(aVar2);
                        this.f37203h.a(this.f37201f + 1, this.f37202g, this.f37198c, this.f37200e, this.f37196a);
                        this.f37203h.a();
                    }
                }

                @Override // com.kwai.filedownloader.i
                public void c(com.kwai.filedownloader.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2) == null) {
                        this.f37203h.f37195b.remove(aVar2);
                        a aVar3 = this.f37196a;
                        if (aVar3 != null) {
                            aVar3.a(aVar2.o());
                        }
                        this.f37197b.a(this.f37198c, this.f37199d, this.f37200e);
                        this.f37203h.a();
                    }
                }
            }));
        }
    }

    private void a(List<CDNUrl> list, String str, boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{list, str, Boolean.valueOf(z), aVar}) == null) {
            String a2 = b.a().a(str, z);
            if (a2 != null) {
                if (aVar != null) {
                    aVar.a(a2);
                }
            } else if (list == null || list.isEmpty()) {
            } else {
                a(0, com.kwad.sdk.emotion.b.a.a(list, null), str, z, aVar);
            }
        }
    }

    public void a(EmotionInfo emotionInfo, boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{emotionInfo, Boolean.valueOf(z), aVar}) == null) {
            a(z ? emotionInfo.emotionImageBigUrl : emotionInfo.emotionImageSmallUrl, emotionInfo.id, z, aVar);
            a();
        }
    }
}
