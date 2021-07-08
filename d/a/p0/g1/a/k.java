package d.a.p0.g1.a;

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
import d.a.o0.r.s.a;
/* loaded from: classes8.dex */
public class k extends d.a.c.k.e.a<d.a.p0.g1.c.o, TopicMediaHolder> {
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
    public TbCyberVideoView.h u;
    public Handler v;
    public CyberPlayerManager.OnErrorListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f56332e;

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
            this.f56332e = kVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (!this.f56332e.r) {
                    BdToast.i(this.f56332e.n.getPageContext().getPageActivity(), this.f56332e.n.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).q();
                }
                this.f56332e.E0();
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f56333a;

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
            this.f56333a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f56333a.y0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f56334a;

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
            this.f56334a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f56334a.p == null || this.f56334a.p.f17141b == null || this.f56334a.p.f17145f == null || this.f56334a.p.f17142c == null) {
                return;
            }
            this.f56334a.p.f17141b.setVisibility(0);
            this.f56334a.p.f17145f.setVisibility(8);
            this.f56334a.p.f17142c.stopPlayback();
            this.f56334a.r = true;
            k kVar = this.f56334a;
            kVar.z0(kVar.p);
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f56335a;

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
            this.f56335a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f56335a.p == null || this.f56335a.p.m == null) {
                return;
            }
            int[] iArr = new int[2];
            this.f56335a.p.m.getLocationInWindow(iArr);
            int i2 = iArr[1];
            this.f56335a.p.m.getHeight();
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f56336a;

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
            this.f56336a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f56336a.v != null) {
                    this.f56336a.v.removeMessages(1);
                }
                if (this.f56336a.p == null || this.f56336a.p.f17143d == null || this.f56336a.p.f17144e == null) {
                    return;
                }
                this.f56336a.p.f17143d.j();
                this.f56336a.p.f17144e.e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f56337e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.g1.c.o f56338f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f56339g;

        public g(k kVar, TopicMediaHolder topicMediaHolder, d.a.p0.g1.c.o oVar) {
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
            this.f56339g = kVar;
            this.f56337e = topicMediaHolder;
            this.f56338f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56337e.f17145f.setVisibility(8);
                TbCyberVideoView tbCyberVideoView = this.f56337e.f17142c;
                if (tbCyberVideoView != null) {
                    tbCyberVideoView.setPlayMode("2");
                }
                this.f56337e.f17142c.start();
                this.f56339g.H0(this.f56338f, this.f56337e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f56340e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.g1.c.o f56341f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f56342g;

        public h(k kVar, TopicMediaHolder topicMediaHolder, d.a.p0.g1.c.o oVar) {
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
            this.f56342g = kVar;
            this.f56340e = topicMediaHolder;
            this.f56341f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TopicMediaHolder topicMediaHolder;
            TopicVideoControllerView topicVideoControllerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (topicMediaHolder = this.f56340e) == null || topicMediaHolder.f17142c == null || (topicVideoControllerView = topicMediaHolder.f17143d) == null) {
                return;
            }
            int curProgress = topicVideoControllerView.getCurProgress();
            if (curProgress > 0) {
                float duration = this.f56340e.f17142c.getDuration() * 1.0f * curProgress;
                TopicMediaHolder topicMediaHolder2 = this.f56340e;
                TopicVideoControllerView topicVideoControllerView2 = topicMediaHolder2.f17143d;
                topicMediaHolder2.f17142c.seekTo((int) (duration / 10000.0f));
            }
            Message obtainMessage = this.f56342g.v.obtainMessage(1);
            obtainMessage.obj = this.f56341f;
            this.f56342g.v.sendMessage(obtainMessage);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f56343e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.g1.c.o f56344f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f56345g;

        public i(k kVar, TopicMediaHolder topicMediaHolder, d.a.p0.g1.c.o oVar) {
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
            this.f56345g = kVar;
            this.f56343e = topicMediaHolder;
            this.f56344f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56343e.f17145f.setVisibility(0);
                this.f56345g.A0(this.f56344f, this.f56343e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f56346e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.g1.c.o f56347f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f56348g;

        public j(k kVar, TopicMediaHolder topicMediaHolder, d.a.p0.g1.c.o oVar) {
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
            this.f56348g = kVar;
            this.f56346e = topicMediaHolder;
            this.f56347f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f56346e.f17142c.isPlaying()) {
                    this.f56348g.w0(this.f56346e, this.f56347f);
                    return;
                }
                this.f56346e.f17142c.pause();
                this.f56346e.f17147h.setVisibility(0);
            }
        }
    }

    /* renamed from: d.a.p0.g1.a.k$k  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1381k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.g1.c.o f56349e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f56350f;

        public View$OnClickListenerC1381k(k kVar, d.a.p0.g1.c.o oVar) {
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
            this.f56350f = kVar;
            this.f56349e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56350f.n.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f56350f.n.getActivity()).createNormalConfig(String.valueOf(this.f56349e.f56449e), this.f56349e.f56450f, "")));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f56351e;

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
            this.f56351e = kVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f56351e.p != null && this.f56351e.p.f17142c != null) {
                    this.f56351e.p.f17142c.stopPlayback();
                }
                this.f56351e.E0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f56352a;

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
            this.f56352a = kVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message.what != 1 || this.f56352a.r || this.f56352a.p == null || this.f56352a.p.f17142c == null || this.f56352a.p.f17141b == null || this.f56352a.p.f17145f == null || this.f56352a.p.f17147h == null) {
                return;
            }
            if (this.f56352a.p.f17142c.getCurrentPosition() > 0) {
                this.f56352a.p.f17141b.setVisibility(8);
                this.f56352a.p.f17145f.setVisibility(8);
                this.f56352a.p.f17147h.setVisibility(8);
                k kVar = this.f56352a;
                kVar.H0((d.a.p0.g1.c.o) message.obj, kVar.p);
                k kVar2 = this.f56352a;
                kVar2.z0(kVar2.p);
                return;
            }
            Message obtainMessage = this.f56352a.v.obtainMessage(1);
            obtainMessage.obj = message.obj;
            this.f56352a.v.sendMessageDelayed(obtainMessage, 50L);
        }
    }

    /* loaded from: classes8.dex */
    public class n implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f56353e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.g1.c.o f56354f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f56355g;

        public n(k kVar, TopicMediaHolder topicMediaHolder, d.a.p0.g1.c.o oVar) {
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
            this.f56355g = kVar;
            this.f56353e = topicMediaHolder;
            this.f56354f = oVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TopicMediaHolder topicMediaHolder = this.f56353e;
                if (topicMediaHolder != null && (tbCyberVideoView = topicMediaHolder.f17142c) != null) {
                    tbCyberVideoView.setPlayMode("2");
                }
                this.f56355g.x0(this.f56353e, this.f56354f);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.p0.g1.c.o f56356e;

        /* renamed from: f  reason: collision with root package name */
        public TopicMediaHolder f56357f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f56358g;

        /* loaded from: classes8.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ p f56359e;

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
                this.f56359e = pVar;
            }

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f56359e.b();
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes8.dex */
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

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        public p(k kVar, d.a.p0.g1.c.o oVar, TopicMediaHolder topicMediaHolder) {
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
            this.f56358g = kVar;
            this.f56356e = oVar;
            this.f56357f = topicMediaHolder;
        }

        public final void b() {
            TopicMediaHolder topicMediaHolder;
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56356e == null || (topicMediaHolder = this.f56357f) == null || (tbCyberVideoView = topicMediaHolder.f17142c) == null) {
                return;
            }
            tbCyberVideoView.setPlayMode("2");
            this.f56357f.f17142c.setVideoPath(this.f56356e.f56452h);
            this.f56357f.f17142c.start();
            this.f56358g.r = false;
            this.f56358g.G0(this.f56357f);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicMediaHolder topicMediaHolder;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f56356e == null || (topicMediaHolder = this.f56357f) == null || (view2 = topicMediaHolder.f17148i) == null || topicMediaHolder.f17142c == null) {
                return;
            }
            if (view2.getVisibility() == 0) {
                this.f56357f.f17142c.stopPlayback();
                this.f56358g.r = true;
                this.f56358g.z0(this.f56357f);
            } else if (d.a.c.e.p.j.x()) {
                d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f56358g.n.getPageContext().getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.setPositiveButton(R.string.confirm, new a(this));
                aVar.setNegativeButton(R.string.cancel, new b(this));
                aVar.create(this.f56358g.n.getPageContext()).show();
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

    public final void A0(d.a.p0.g1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, oVar, topicMediaHolder) == null) || oVar == null) {
            return;
        }
        if (!StringUtils.isNull(oVar.f56452h) && oVar.f56453i > 0) {
            topicMediaHolder.f17141b.M(oVar.j, 17, false);
        } else {
            topicMediaHolder.f17141b.M(oVar.f56451g, 17, false);
        }
        topicMediaHolder.f17141b.setNoImageBottomText("");
        if (!StringUtils.isNull(oVar.j)) {
            topicMediaHolder.f17141b.setEvent(new a(this));
        }
        if (this.s) {
            topicMediaHolder.f17144e.g();
        } else {
            topicMediaHolder.f17143d.l(0, oVar.f56453i * 1000);
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
                this.o = LayoutInflater.from(this.f41837e).inflate(R.layout.topic_vedio_item, viewGroup, false);
                this.p = new TopicMediaHolder(this.o);
                View findViewById = this.o.findViewById(R.id.topic_layout_video_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                int k = d.a.c.e.p.l.k(this.f41837e);
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
    public View X(int i2, View view, ViewGroup viewGroup, d.a.p0.g1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, oVar, topicMediaHolder})) == null) {
            if (oVar != null && topicMediaHolder != null) {
                if (!this.q) {
                    this.q = true;
                    if (!StringUtils.isNull(oVar.f56452h) && oVar.f56453i > 0) {
                        this.t = false;
                        topicMediaHolder.j.setVisibility(0);
                        if (this.s) {
                            topicMediaHolder.f17143d.setVisibility(8);
                            topicMediaHolder.f17144e.setVisibility(0);
                        } else {
                            topicMediaHolder.f17143d.setVisibility(0);
                            topicMediaHolder.f17144e.setVisibility(8);
                        }
                    } else {
                        this.t = true;
                        topicMediaHolder.f17143d.setVisibility(8);
                        topicMediaHolder.f17144e.setVisibility(8);
                        topicMediaHolder.j.setVisibility(8);
                    }
                    if (!StringUtils.isNull(oVar.f56452h) && oVar.f56453i > 0) {
                        topicMediaHolder.f17141b.setForegroundDrawable(R.drawable.icon_play_video);
                        topicMediaHolder.f17141b.setOnClickListener(new p(this, oVar, topicMediaHolder));
                    } else {
                        topicMediaHolder.f17141b.setForegroundDrawable(0);
                        topicMediaHolder.f17141b.setOnClickListener(null);
                    }
                    topicMediaHolder.f17141b.setTag(Integer.valueOf(i2));
                    topicMediaHolder.f17141b.setDefaultResource(0);
                    if (!d.a.o0.r.k.c().g()) {
                        topicMediaHolder.f17141b.setNoImageBottomTextColor(R.color.CAM_X0108);
                        topicMediaHolder.f17141b.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                        topicMediaHolder.f17141b.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                        topicMediaHolder.f17141b.setSupportNoImage(true);
                        topicMediaHolder.f17141b.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                    } else {
                        topicMediaHolder.f17141b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                        if (!topicMediaHolder.f17142c.isPlaying()) {
                            A0(oVar, topicMediaHolder);
                        }
                    }
                    topicMediaHolder.f17146g.setOnClickListener(new g(this, topicMediaHolder, oVar));
                    topicMediaHolder.f17142c.setOnPreparedListener(new h(this, topicMediaHolder, oVar));
                    topicMediaHolder.f17142c.setOnCompletionListener(new i(this, topicMediaHolder, oVar));
                    topicMediaHolder.f17142c.setOnErrorListener(this.w);
                    topicMediaHolder.f17142c.setOnSurfaceDestroyedListener(this.u);
                    topicMediaHolder.j.setOnClickListener(new j(this, topicMediaHolder, oVar));
                    if (this.s) {
                        topicMediaHolder.f17144e.setPlayer(topicMediaHolder.f17142c);
                    } else {
                        topicMediaHolder.f17143d.setPlayer(topicMediaHolder.f17142c);
                    }
                    if (StringUtils.isNull(oVar.f56450f)) {
                        topicMediaHolder.k.setVisibility(8);
                        topicMediaHolder.l.setVisibility(8);
                    } else {
                        topicMediaHolder.k.setVisibility(0);
                        topicMediaHolder.l.setVisibility(0);
                        topicMediaHolder.k.setText(oVar.f56450f);
                        topicMediaHolder.k.setOnClickListener(new View$OnClickListenerC1381k(this, oVar));
                    }
                }
                if (topicMediaHolder.f17140a != this.m) {
                    SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
                    topicMediaHolder.f17143d.m(this.m);
                    SkinManager.setImageResource(topicMediaHolder.f17147h, R.drawable.icon_play_video);
                    SkinManager.setViewTextColor(topicMediaHolder.f17146g, R.color.CAM_X0101, 1);
                    topicMediaHolder.f17144e.h(this.m);
                    topicMediaHolder.f17146g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                    SkinManager.setViewTextColor(topicMediaHolder.k, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundColor(topicMediaHolder.l, R.color.CAM_X0204);
                }
                topicMediaHolder.f17140a = this.m;
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (topicMediaHolder = this.p) == null || (foreDrawableImageView = topicMediaHolder.f17141b) == null || topicMediaHolder.f17145f == null) {
            return;
        }
        foreDrawableImageView.setVisibility(0);
        this.p.f17145f.setVisibility(8);
        this.r = true;
        z0(this.p);
        F0(this.p);
    }

    public final void F0(TopicMediaHolder topicMediaHolder) {
        TopicVideoControllerView topicVideoControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, topicMediaHolder) == null) || topicMediaHolder == null || (topicVideoControllerView = topicMediaHolder.f17143d) == null || topicMediaHolder.f17144e == null) {
            return;
        }
        topicVideoControllerView.o();
        topicMediaHolder.f17144e.i();
    }

    public final void G0(TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, topicMediaHolder) == null) || topicMediaHolder == null) {
            return;
        }
        topicMediaHolder.f17148i.setVisibility(0);
        topicMediaHolder.f17141b.setForegroundDrawable(0);
    }

    public final void H0(d.a.p0.g1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, oVar, topicMediaHolder) == null) || oVar == null || topicMediaHolder == null) {
            return;
        }
        if (this.s) {
            topicMediaHolder.f17144e.k();
        } else {
            topicMediaHolder.f17143d.q();
        }
    }

    public final void w0(TopicMediaHolder topicMediaHolder, d.a.p0.g1.c.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, topicMediaHolder, oVar) == null) {
            if (d.a.c.e.p.j.x()) {
                d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.n.getPageContext().getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.setPositiveButton(R.string.confirm, new n(this, topicMediaHolder, oVar));
                aVar.setNegativeButton(R.string.cancel, new o(this));
                aVar.create(this.n.getPageContext()).show();
                return;
            }
            x0(topicMediaHolder, oVar);
        }
    }

    public final void x0(TopicMediaHolder topicMediaHolder, d.a.p0.g1.c.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, topicMediaHolder, oVar) == null) {
            topicMediaHolder.f17142c.start();
            topicMediaHolder.f17147h.setVisibility(8);
            topicMediaHolder.f17145f.setVisibility(8);
            H0(oVar, topicMediaHolder);
        }
    }

    public final void y0() {
        TopicMediaHolder topicMediaHolder;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (topicMediaHolder = this.p) == null || (tbCyberVideoView = topicMediaHolder.f17142c) == null || topicMediaHolder.f17147h == null || topicMediaHolder.f17148i == null) {
            return;
        }
        if (tbCyberVideoView.isPlaying()) {
            this.p.f17142c.pause();
            this.p.f17147h.setVisibility(0);
        } else if (this.p.f17148i.getVisibility() == 0) {
            this.p.f17142c.stopPlayback();
            this.r = true;
            z0(this.p);
        }
    }

    public final void z0(TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, topicMediaHolder) == null) || topicMediaHolder == null) {
            return;
        }
        topicMediaHolder.f17148i.setVisibility(8);
        if (this.t) {
            topicMediaHolder.f17141b.setForegroundDrawable(0);
        } else {
            topicMediaHolder.f17141b.setForegroundDrawable(R.drawable.icon_play_video);
        }
    }
}
