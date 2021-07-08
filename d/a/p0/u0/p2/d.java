package d.a.p0.u0.p2;

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
import d.a.p0.u0.h1.g;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i f63594a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.u0.h1.g f63595b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.n2.c f63596c;

    /* renamed from: d  reason: collision with root package name */
    public View f63597d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f63598e;

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

    public final void a(d.a.p0.u0.h1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, gVar, videoSerializeVideoThreadInfo) == null) || videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f62859a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f62860b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f62861c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f62865g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f62864f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f62862d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f62863e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f62866h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f62866h.f62871e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f62866h.f62872f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f62866h.f62868b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f62866h.f62869c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f62866h.f62870d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f62875c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f62876d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f62877e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f62878f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f62879g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f62880h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
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
        gVar.f62848e = videoSerializeVideoThreadInfo.forumId;
        gVar.f62849f = videoSerializeVideoThreadInfo.threadId;
        gVar.f62851h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f62852i = videoSerializeVideoThreadInfo.createTime;
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

    public d.a.p0.u0.h1.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f63595b == null) {
                this.f63595b = new d.a.p0.u0.h1.g();
            }
            a(this.f63595b, this.f63594a.e());
            return this.f63595b;
        }
        return (d.a.p0.u0.h1.g) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.f63598e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f63598e = null;
            }
            View view = this.f63597d;
            if (view != null) {
                view.clearAnimation();
            }
            d();
        }
    }

    public void d() {
        d.a.p0.n2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f63596c) == null) {
            return;
        }
        cVar.v0();
        this.f63596c = null;
    }

    public void e(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.f63594a = iVar;
        }
    }
}
