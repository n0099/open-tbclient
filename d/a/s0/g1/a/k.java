package d.a.s0.g1.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.holder.TopicMediaHolder;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.s.a;
/* loaded from: classes9.dex */
public class k extends d.a.c.k.e.a<d.a.s0.g1.c.o, TopicMediaHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public int m;
    public BaseActivity<?> n;
    public View o;
    public TopicMediaHolder p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public TbCyberVideoView.g u;
    public Handler v;
    public CyberPlayerManager.OnErrorListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes9.dex */
    public class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f59590e;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59590e = kVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (!this.f59590e.r) {
                    BdToast.i(this.f59590e.n.getPageContext().getPageActivity(), this.f59590e.n.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).q();
                }
                this.f59590e.E0();
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f59591a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k kVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59591a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f59591a.y0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f59592a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(k kVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59592a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f59592a.p == null || this.f59592a.p.f17102b == null || this.f59592a.p.f17106f == null || this.f59592a.p.f17103c == null) {
                return;
            }
            this.f59592a.p.f17102b.setVisibility(0);
            this.f59592a.p.f17106f.setVisibility(8);
            this.f59592a.p.f17103c.stopPlayback();
            this.f59592a.r = true;
            k kVar = this.f59592a;
            kVar.z0(kVar.p);
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f59593a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(k kVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59593a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f59593a.p == null || this.f59593a.p.m == null) {
                return;
            }
            int[] iArr = new int[2];
            this.f59593a.p.m.getLocationInWindow(iArr);
            int i2 = iArr[1];
            this.f59593a.p.m.getHeight();
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f59594a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(k kVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59594a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f59594a.v != null) {
                    this.f59594a.v.removeMessages(1);
                }
                if (this.f59594a.p == null || this.f59594a.p.f17104d == null || this.f59594a.p.f17105e == null) {
                    return;
                }
                this.f59594a.p.f17104d.j();
                this.f59594a.p.f17105e.e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f59595e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.g1.c.o f59596f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f59597g;

        public g(k kVar, TopicMediaHolder topicMediaHolder, d.a.s0.g1.c.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, topicMediaHolder, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59597g = kVar;
            this.f59595e = topicMediaHolder;
            this.f59596f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f59595e.f17106f.setVisibility(8);
                TbCyberVideoView tbCyberVideoView = this.f59595e.f17103c;
                if (tbCyberVideoView != null) {
                    tbCyberVideoView.setPlayMode("2");
                }
                this.f59595e.f17103c.start();
                this.f59597g.H0(this.f59596f, this.f59595e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f59598e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.g1.c.o f59599f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f59600g;

        public h(k kVar, TopicMediaHolder topicMediaHolder, d.a.s0.g1.c.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, topicMediaHolder, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59600g = kVar;
            this.f59598e = topicMediaHolder;
            this.f59599f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TopicMediaHolder topicMediaHolder;
            TopicVideoControllerView topicVideoControllerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (topicMediaHolder = this.f59598e) == null || topicMediaHolder.f17103c == null || (topicVideoControllerView = topicMediaHolder.f17104d) == null) {
                return;
            }
            int curProgress = topicVideoControllerView.getCurProgress();
            if (curProgress > 0) {
                float duration = this.f59598e.f17103c.getDuration() * 1.0f * curProgress;
                TopicMediaHolder topicMediaHolder2 = this.f59598e;
                TopicVideoControllerView topicVideoControllerView2 = topicMediaHolder2.f17104d;
                topicMediaHolder2.f17103c.seekTo((int) (duration / 10000.0f));
            }
            Message obtainMessage = this.f59600g.v.obtainMessage(1);
            obtainMessage.obj = this.f59599f;
            this.f59600g.v.sendMessage(obtainMessage);
        }
    }

    /* loaded from: classes9.dex */
    public class i implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f59601e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.g1.c.o f59602f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f59603g;

        public i(k kVar, TopicMediaHolder topicMediaHolder, d.a.s0.g1.c.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, topicMediaHolder, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59603g = kVar;
            this.f59601e = topicMediaHolder;
            this.f59602f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59601e.f17106f.setVisibility(0);
                this.f59603g.A0(this.f59602f, this.f59601e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f59604e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.g1.c.o f59605f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f59606g;

        public j(k kVar, TopicMediaHolder topicMediaHolder, d.a.s0.g1.c.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, topicMediaHolder, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59606g = kVar;
            this.f59604e = topicMediaHolder;
            this.f59605f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f59604e.f17103c.isPlaying()) {
                    this.f59606g.w0(this.f59604e, this.f59605f);
                    return;
                }
                this.f59604e.f17103c.pause();
                this.f59604e.f17108h.setVisibility(0);
            }
        }
    }

    /* renamed from: d.a.s0.g1.a.k$k  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1427k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.g1.c.o f59607e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f59608f;

        public View$OnClickListenerC1427k(k kVar, d.a.s0.g1.c.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59608f = kVar;
            this.f59607e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f59608f.n.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f59608f.n.getActivity()).createNormalConfig(String.valueOf(this.f59607e.f59707e), this.f59607e.f59708f, "")));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements TbCyberVideoView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f59609e;

        public l(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59609e = kVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f59609e.p != null && this.f59609e.p.f17103c != null) {
                    this.f59609e.p.f17103c.stopPlayback();
                }
                this.f59609e.E0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f59610a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(k kVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59610a = kVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message.what != 1 || this.f59610a.r || this.f59610a.p == null || this.f59610a.p.f17103c == null || this.f59610a.p.f17102b == null || this.f59610a.p.f17106f == null || this.f59610a.p.f17108h == null) {
                return;
            }
            if (this.f59610a.p.f17103c.getCurrentPosition() > 0) {
                this.f59610a.p.f17102b.setVisibility(8);
                this.f59610a.p.f17106f.setVisibility(8);
                this.f59610a.p.f17108h.setVisibility(8);
                k kVar = this.f59610a;
                kVar.H0((d.a.s0.g1.c.o) message.obj, kVar.p);
                k kVar2 = this.f59610a;
                kVar2.z0(kVar2.p);
                return;
            }
            Message obtainMessage = this.f59610a.v.obtainMessage(1);
            obtainMessage.obj = message.obj;
            this.f59610a.v.sendMessageDelayed(obtainMessage, 50L);
        }
    }

    /* loaded from: classes9.dex */
    public class n implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f59611e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.g1.c.o f59612f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f59613g;

        public n(k kVar, TopicMediaHolder topicMediaHolder, d.a.s0.g1.c.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, topicMediaHolder, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59613g = kVar;
            this.f59611e = topicMediaHolder;
            this.f59612f = oVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TopicMediaHolder topicMediaHolder = this.f59611e;
                if (topicMediaHolder != null && (tbCyberVideoView = topicMediaHolder.f17103c) != null) {
                    tbCyberVideoView.setPlayMode("2");
                }
                this.f59613g.x0(this.f59611e, this.f59612f);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.s0.g1.c.o f59614e;

        /* renamed from: f  reason: collision with root package name */
        public TopicMediaHolder f59615f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f59616g;

        /* loaded from: classes9.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ p f59617e;

            public a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59617e = pVar;
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f59617e.b();
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        public p(k kVar, d.a.s0.g1.c.o oVar, TopicMediaHolder topicMediaHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, oVar, topicMediaHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59616g = kVar;
            this.f59614e = oVar;
            this.f59615f = topicMediaHolder;
        }

        public final void b() {
            TopicMediaHolder topicMediaHolder;
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59614e == null || (topicMediaHolder = this.f59615f) == null || (tbCyberVideoView = topicMediaHolder.f17103c) == null) {
                return;
            }
            tbCyberVideoView.setPlayMode("2");
            this.f59615f.f17103c.setVideoPath(this.f59614e.f59710h);
            this.f59615f.f17103c.start();
            this.f59616g.r = false;
            this.f59616g.G0(this.f59615f);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicMediaHolder topicMediaHolder;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f59614e == null || (topicMediaHolder = this.f59615f) == null || (view2 = topicMediaHolder.f17109i) == null || topicMediaHolder.f17103c == null) {
                return;
            }
            if (view2.getVisibility() == 0) {
                this.f59615f.f17103c.stopPlayback();
                this.f59616g.r = true;
                this.f59616g.z0(this.f59615f);
            } else if (d.a.c.e.p.j.x()) {
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f59616g.n.getPageContext().getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.setPositiveButton(R.string.confirm, new a(this));
                aVar.setNegativeButton(R.string.cancel, new b(this));
                aVar.create(this.f59616g.n.getPageContext()).show();
            } else {
                b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = new l(this);
        this.v = new m(this, Looper.getMainLooper());
        this.w = new b(this);
        this.x = new c(this, 2004011);
        this.y = new d(this, 2004012);
        this.z = new e(this, 2004013);
        this.A = new f(this, 2004014);
        this.n = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.x);
            baseActivity.registerListener(this.y);
            baseActivity.registerListener(this.z);
            baseActivity.registerListener(this.A);
        }
    }

    public final void A0(d.a.s0.g1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, oVar, topicMediaHolder) == null) || oVar == null) {
            return;
        }
        if (!StringUtils.isNull(oVar.f59710h) && oVar.f59711i > 0) {
            topicMediaHolder.f17102b.M(oVar.j, 17, false);
        } else {
            topicMediaHolder.f17102b.M(oVar.f59709g, 17, false);
        }
        topicMediaHolder.f17102b.setNoImageBottomText("");
        if (!StringUtils.isNull(oVar.j)) {
            topicMediaHolder.f17102b.setEvent(new a(this));
        }
        if (this.s) {
            topicMediaHolder.f17105e.g();
        } else {
            topicMediaHolder.f17104d.l(0, oVar.f59711i * 1000);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: B0 */
    public TopicMediaHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            if (this.o == null) {
                this.o = LayoutInflater.from(this.f44821e).inflate(R.layout.topic_vedio_item, viewGroup, false);
                this.p = new TopicMediaHolder(this.o);
                View findViewById = this.o.findViewById(R.id.topic_layout_video_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                int k = d.a.c.e.p.l.k(this.f44821e);
                if (layoutParams != null) {
                    layoutParams.height = (int) (k / 1.8d);
                    findViewById.setLayoutParams(layoutParams);
                }
            } else {
                E0();
            }
            return this.p;
        }
        return (TopicMediaHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: C0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.s0.g1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, oVar, topicMediaHolder})) == null) {
            if (oVar != null && topicMediaHolder != null) {
                if (!this.q) {
                    this.q = true;
                    if (!StringUtils.isNull(oVar.f59710h) && oVar.f59711i > 0) {
                        this.t = false;
                        topicMediaHolder.j.setVisibility(0);
                        if (this.s) {
                            topicMediaHolder.f17104d.setVisibility(8);
                            topicMediaHolder.f17105e.setVisibility(0);
                        } else {
                            topicMediaHolder.f17104d.setVisibility(0);
                            topicMediaHolder.f17105e.setVisibility(8);
                        }
                    } else {
                        this.t = true;
                        topicMediaHolder.f17104d.setVisibility(8);
                        topicMediaHolder.f17105e.setVisibility(8);
                        topicMediaHolder.j.setVisibility(8);
                    }
                    if (!StringUtils.isNull(oVar.f59710h) && oVar.f59711i > 0) {
                        topicMediaHolder.f17102b.setForegroundDrawable(R.drawable.icon_play_video);
                        topicMediaHolder.f17102b.setOnClickListener(new p(this, oVar, topicMediaHolder));
                    } else {
                        topicMediaHolder.f17102b.setForegroundDrawable(0);
                        topicMediaHolder.f17102b.setOnClickListener(null);
                    }
                    topicMediaHolder.f17102b.setTag(Integer.valueOf(i2));
                    topicMediaHolder.f17102b.setDefaultResource(0);
                    if (!d.a.r0.r.k.c().g()) {
                        topicMediaHolder.f17102b.setNoImageBottomTextColor(R.color.CAM_X0108);
                        topicMediaHolder.f17102b.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                        topicMediaHolder.f17102b.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                        topicMediaHolder.f17102b.setSupportNoImage(true);
                        topicMediaHolder.f17102b.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                    } else {
                        topicMediaHolder.f17102b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                        if (!topicMediaHolder.f17103c.isPlaying()) {
                            A0(oVar, topicMediaHolder);
                        }
                    }
                    topicMediaHolder.f17107g.setOnClickListener(new g(this, topicMediaHolder, oVar));
                    topicMediaHolder.f17103c.setOnPreparedListener(new h(this, topicMediaHolder, oVar));
                    topicMediaHolder.f17103c.setOnCompletionListener(new i(this, topicMediaHolder, oVar));
                    topicMediaHolder.f17103c.setOnErrorListener(this.w);
                    topicMediaHolder.f17103c.setOnSurfaceDestroyedListener(this.u);
                    topicMediaHolder.j.setOnClickListener(new j(this, topicMediaHolder, oVar));
                    if (this.s) {
                        topicMediaHolder.f17105e.setPlayer(topicMediaHolder.f17103c);
                    } else {
                        topicMediaHolder.f17104d.setPlayer(topicMediaHolder.f17103c);
                    }
                    if (StringUtils.isNull(oVar.f59708f)) {
                        topicMediaHolder.k.setVisibility(8);
                        topicMediaHolder.l.setVisibility(8);
                    } else {
                        topicMediaHolder.k.setVisibility(0);
                        topicMediaHolder.l.setVisibility(0);
                        topicMediaHolder.k.setText(oVar.f59708f);
                        topicMediaHolder.k.setOnClickListener(new View$OnClickListenerC1427k(this, oVar));
                    }
                }
                if (topicMediaHolder.f17101a != this.m) {
                    SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
                    topicMediaHolder.f17104d.m(this.m);
                    SkinManager.setImageResource(topicMediaHolder.f17108h, R.drawable.icon_play_video);
                    SkinManager.setViewTextColor(topicMediaHolder.f17107g, R.color.CAM_X0101, 1);
                    topicMediaHolder.f17105e.h(this.m);
                    topicMediaHolder.f17107g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                    SkinManager.setViewTextColor(topicMediaHolder.k, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundColor(topicMediaHolder.l, R.color.CAM_X0204);
                }
                topicMediaHolder.f17101a = this.m;
            }
            return this.o;
        }
        return (View) invokeCommon.objValue;
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.q = false;
        }
    }

    public final void E0() {
        TopicMediaHolder topicMediaHolder;
        ForeDrawableImageView foreDrawableImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (topicMediaHolder = this.p) == null || (foreDrawableImageView = topicMediaHolder.f17102b) == null || topicMediaHolder.f17106f == null) {
            return;
        }
        foreDrawableImageView.setVisibility(0);
        this.p.f17106f.setVisibility(8);
        this.r = true;
        z0(this.p);
        F0(this.p);
    }

    public final void F0(TopicMediaHolder topicMediaHolder) {
        TopicVideoControllerView topicVideoControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, topicMediaHolder) == null) || topicMediaHolder == null || (topicVideoControllerView = topicMediaHolder.f17104d) == null || topicMediaHolder.f17105e == null) {
            return;
        }
        topicVideoControllerView.o();
        topicMediaHolder.f17105e.i();
    }

    public final void G0(TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, topicMediaHolder) == null) || topicMediaHolder == null) {
            return;
        }
        topicMediaHolder.f17109i.setVisibility(0);
        topicMediaHolder.f17102b.setForegroundDrawable(0);
    }

    public final void H0(d.a.s0.g1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, oVar, topicMediaHolder) == null) || oVar == null || topicMediaHolder == null) {
            return;
        }
        if (this.s) {
            topicMediaHolder.f17105e.k();
        } else {
            topicMediaHolder.f17104d.q();
        }
    }

    public final void w0(TopicMediaHolder topicMediaHolder, d.a.s0.g1.c.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, topicMediaHolder, oVar) == null) {
            if (d.a.c.e.p.j.x()) {
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.n.getPageContext().getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.setPositiveButton(R.string.confirm, new n(this, topicMediaHolder, oVar));
                aVar.setNegativeButton(R.string.cancel, new o(this));
                aVar.create(this.n.getPageContext()).show();
                return;
            }
            x0(topicMediaHolder, oVar);
        }
    }

    public final void x0(TopicMediaHolder topicMediaHolder, d.a.s0.g1.c.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, topicMediaHolder, oVar) == null) {
            topicMediaHolder.f17103c.start();
            topicMediaHolder.f17108h.setVisibility(8);
            topicMediaHolder.f17106f.setVisibility(8);
            H0(oVar, topicMediaHolder);
        }
    }

    public final void y0() {
        TopicMediaHolder topicMediaHolder;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (topicMediaHolder = this.p) == null || (tbCyberVideoView = topicMediaHolder.f17103c) == null || topicMediaHolder.f17108h == null || topicMediaHolder.f17109i == null) {
            return;
        }
        if (tbCyberVideoView.isPlaying()) {
            this.p.f17103c.pause();
            this.p.f17108h.setVisibility(0);
        } else if (this.p.f17109i.getVisibility() == 0) {
            this.p.f17103c.stopPlayback();
            this.r = true;
            z0(this.p);
        }
    }

    public final void z0(TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, topicMediaHolder) == null) || topicMediaHolder == null) {
            return;
        }
        topicMediaHolder.f17109i.setVisibility(8);
        if (this.t) {
            topicMediaHolder.f17102b.setForegroundDrawable(0);
        } else {
            topicMediaHolder.f17102b.setForegroundDrawable(R.drawable.icon_play_video);
        }
    }
}
