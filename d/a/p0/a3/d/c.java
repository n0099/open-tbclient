package d.a.p0.a3.d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.tauth.IUiListener;
import d.a.p0.a3.d.b;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class c extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IUiListener n;
    public final d.a.c.e.l.c<EmotionShareLoaderProc.EmotionShare> o;

    /* loaded from: classes7.dex */
    public class a extends d.a.c.e.l.c<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f54027a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54027a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i2) == null) {
                super.onLoaded(emotionShare, str, i2);
                if (emotionShare == null || emotionShare.image == null || TextUtils.isEmpty(emotionShare.path)) {
                    this.f54027a.w(2, 4);
                }
                this.f54027a.G(emotionShare.path);
            }
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                this.f54027a.w(3, 4);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.f54021i = 4;
    }

    public final void F(ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, shareEntity) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("req_type", 1);
            bundle.putString("title", shareEntity.getTitle());
            bundle.putString("summary", shareEntity.getContent());
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            ArrayList<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(shareEntity.getImgUrl())) {
                arrayList.add(shareEntity.getImgUrl());
            }
            bundle.putStringArrayList("imageUrl", arrayList);
            IUiListener iUiListener = this.n;
            if (iUiListener != null) {
                this.f54020h.shareToQzone((Activity) this.f54017b, bundle, iUiListener);
            }
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 1);
            IUiListener iUiListener = this.n;
            if (iUiListener != null) {
                this.f54020h.shareToQQ((Activity) this.f54017b, bundle, iUiListener);
            }
        }
    }

    public final void H(ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareEntity) == null) {
            if (n(shareEntity.getLocalFile())) {
                G(shareEntity.getLocalFile());
            } else if (m(shareEntity.getImageUri())) {
                G(shareEntity.getImageUri().getPath());
            } else {
                d.a.c.e.l.d.h().k(shareEntity.getImgUrl(), 34, this.o, 0, 0, h(), new Object[0]);
            }
        }
    }

    @Override // d.a.p0.a3.d.b, d.a.p0.a3.e.a
    public void a(ShareEntity shareEntity, d.a.p0.a3.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, shareEntity, bVar) == null) {
            if (shareEntity != null && this.f54020h != null) {
                Context context = this.f54017b;
                if (context != null && (context instanceof Activity)) {
                    this.n = new b.c(this, bVar);
                    if (shareEntity.getShareType() != 0) {
                        H(shareEntity);
                        return;
                    } else {
                        F(shareEntity);
                        return;
                    }
                }
                w(2, 4);
                if (bVar != null) {
                    bVar.onShare(0, 2);
                    return;
                }
                return;
            }
            w(2, 4);
            if (bVar != null) {
                bVar.onShare(0, 2);
            }
        }
    }
}
