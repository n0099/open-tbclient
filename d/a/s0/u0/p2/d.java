package d.a.s0.u0.p2;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.u0.h1.g;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i f66813a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.u0.h1.g f66814b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.n2.c f66815c;

    /* renamed from: d  reason: collision with root package name */
    public View f66816d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f66817e;

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
            }
        }
    }

    public final void a(d.a.s0.u0.h1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, gVar, videoSerializeVideoThreadInfo) == null) || videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f66078a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f66079b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f66080c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f66084g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f66083f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f66081d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f66082e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f66085h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f66085h.f66090e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f66085h.f66091f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f66085h.f66087b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f66085h.f66088c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f66085h.f66089d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f66094c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f66095d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f66096e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f66097f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f66098g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f66099h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
            cVar.j = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailUrl;
            String str4 = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            gVar.j = videoSerializeVideoThreadInfo.playCount;
        }
        gVar.z = cVar;
        if (videoSerializeVideoThreadInfo.getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = new BaijiahaoData();
            baijiahaoData.oriUgcNid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcNid;
            baijiahaoData.oriUgcTid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcTid;
            baijiahaoData.oriUgcType = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcType;
            baijiahaoData.oriUgcVid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcVid;
            baijiahaoData.forwardUrl = videoSerializeVideoThreadInfo.getBaijiahaoData().forwardUrl;
            gVar.A = baijiahaoData;
        }
        gVar.f66067e = videoSerializeVideoThreadInfo.forumId;
        gVar.f66068f = videoSerializeVideoThreadInfo.threadId;
        gVar.f66070h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f66071i = videoSerializeVideoThreadInfo.createTime;
        gVar.k = videoSerializeVideoThreadInfo.postNum;
        gVar.m = videoSerializeVideoThreadInfo.agreeNum;
        gVar.n = videoSerializeVideoThreadInfo.disAgreeNum;
        gVar.o = videoSerializeVideoThreadInfo.agreeType;
        gVar.p = videoSerializeVideoThreadInfo.hasAgree;
        if (gVar.d() != null && videoSerializeVideoThreadInfo.mAgreeData != null) {
            gVar.d().threadId = videoSerializeVideoThreadInfo.mAgreeData.threadId;
            gVar.d().agreeType = videoSerializeVideoThreadInfo.mAgreeData.agreeType;
            gVar.d().hasAgree = videoSerializeVideoThreadInfo.mAgreeData.hasAgree;
            gVar.d().agreeNum = videoSerializeVideoThreadInfo.mAgreeData.agreeNum;
            gVar.d().disAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.disAgreeNum;
            gVar.d().diffAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.diffAgreeNum;
        }
        gVar.l = videoSerializeVideoThreadInfo.shareNum;
        gVar.x = videoSerializeVideoThreadInfo.title;
        gVar.q = videoSerializeVideoThreadInfo.source;
        gVar.s = videoSerializeVideoThreadInfo.extra;
        gVar.t = videoSerializeVideoThreadInfo.ab_tag;
        gVar.r = videoSerializeVideoThreadInfo.weight;
        gVar.E = videoSerializeVideoThreadInfo.mWorksInfoData;
    }

    public d.a.s0.u0.h1.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f66814b == null) {
                this.f66814b = new d.a.s0.u0.h1.g();
            }
            a(this.f66814b, this.f66813a.e());
            return this.f66814b;
        }
        return (d.a.s0.u0.h1.g) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.f66817e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f66817e = null;
            }
            View view = this.f66816d;
            if (view != null) {
                view.clearAnimation();
            }
            d();
        }
    }

    public void d() {
        d.a.s0.n2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f66815c) == null) {
            return;
        }
        cVar.v0();
        this.f66815c = null;
    }

    public void e(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.f66813a = iVar;
        }
    }
}
