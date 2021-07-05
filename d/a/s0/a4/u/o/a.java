package d.a.s0.a4.u.o;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.tieba.write.write.video.PreviewVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import java.io.File;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57728a;

    /* renamed from: b  reason: collision with root package name */
    public PreviewVideoView f57729b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f57730c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57731d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57732e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57733f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.v3.b f57734g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.e0.b f57735h;

    /* renamed from: i  reason: collision with root package name */
    public VideoInfo f57736i;
    public EditVideoData j;
    public int k;
    public CustomMessageListener l;
    public View.OnClickListener m;

    /* renamed from: d.a.s0.a4.u.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1324a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57737a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1324a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f57737a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue >= 0 && intValue < 100) {
                    this.f57737a.w(1, intValue);
                } else if (intValue == 100) {
                    this.f57737a.w(2, intValue);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57738e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57738e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view != this.f57738e.f57733f) {
                    if (view == this.f57738e.f57729b.f22864g) {
                        if (this.f57738e.f57728a.getPageActivity() instanceof WriteActivity) {
                            this.f57738e.n();
                            ((WriteActivity) this.f57738e.f57728a.getPageActivity()).showPicOrVideo(true, false);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                            return;
                        }
                        return;
                    } else if (view == this.f57738e.f57729b.f22865h) {
                        if (this.f57738e.k != 1 && (this.f57738e.f57728a.getPageActivity() instanceof WriteActivity)) {
                            this.f57738e.n();
                            if (this.f57738e.f57728a == null || this.f57738e.f57736i == null || this.f57738e.f57736i.getMultiMediaData() == null) {
                                return;
                            }
                            TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(this.f57738e.f57728a.getPageActivity());
                            tbEditVideoActivityConfig.getIntent().putExtras(this.f57738e.f57728a.getPageActivity().getIntent());
                            tbEditVideoActivityConfig.setMusicData(null);
                            tbEditVideoActivityConfig.setMultiMediaData(TbEditVideoActivityConfig.convert2MultiMedia(this.f57738e.f57736i));
                            tbEditVideoActivityConfig.setVideoFrom(3);
                            tbEditVideoActivityConfig.setVideoRatio(this.f57738e.f57736i.getMultiMediaData().videoRatio);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbEditVideoActivityConfig));
                            return;
                        }
                        return;
                    } else if (view == this.f57738e.f57729b.f22866i) {
                        if (this.f57738e.k != 1 && (this.f57738e.f57728a.getPageActivity() instanceof WriteActivity)) {
                            this.f57738e.n();
                            if (this.f57738e.f57728a == null || this.f57738e.f57736i == null || this.f57738e.f57736i.getMultiMediaData() == null) {
                                return;
                            }
                            TbEditVideoActivityConfig tbEditVideoActivityConfig2 = new TbEditVideoActivityConfig(this.f57738e.f57728a.getPageActivity());
                            tbEditVideoActivityConfig2.getIntent().putExtras(this.f57738e.f57728a.getPageActivity().getIntent());
                            tbEditVideoActivityConfig2.setMultiMediaData(TbEditVideoActivityConfig.convert2MultiMedia(this.f57738e.f57736i));
                            tbEditVideoActivityConfig2.setVideoFrom(3);
                            tbEditVideoActivityConfig2.setVideoRatio(this.f57738e.f57736i.getMultiMediaData().videoRatio);
                            tbEditVideoActivityConfig2.setPageModeType(3);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbEditVideoActivityConfig2));
                            return;
                        }
                        return;
                    } else if (this.f57738e.k == 1 || this.f57738e.f57736i == null) {
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbPreviewVideoActivityConfig(this.f57738e.f57728a.getPageActivity(), this.f57738e.f57736i)));
                        return;
                    }
                }
                this.f57738e.u();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends d.a.s0.v3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f57739i;

        /* renamed from: d.a.s0.a4.u.o.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1325a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f57740e;

            public RunnableC1325a(c cVar) {
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
                this.f57740e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f57740e.f57739i.w(1, 50);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f57741e;

            public b(c cVar) {
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
                this.f57741e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f57741e.f57739i.w(3, 0);
                    this.f57741e.f57739i.t();
                }
            }
        }

        /* renamed from: d.a.s0.a4.u.o.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1326c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f57742e;

            public RunnableC1326c(c cVar) {
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
                this.f57742e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f57742e.f57739i.w(1, 100);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f57743e;

            public d(c cVar) {
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
                this.f57743e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f57743e.f57739i.w(3, 0);
                    this.f57743e.f57739i.t();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f57744e;

            public e(c cVar) {
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
                this.f57744e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f57744e.f57739i.w(2, 100);
                    if (this.f57744e.f57739i.f57728a == null || !(this.f57744e.f57739i.f57728a.getPageActivity() instanceof WriteActivity)) {
                        return;
                    }
                    ((WriteActivity) this.f57744e.f57739i.f57728a.getPageActivity()).refreshPostButton();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, BaseActivity baseActivity, EditVideoData editVideoData) {
            super(baseActivity, editVideoData);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, baseActivity, editVideoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((BaseActivity) objArr2[0], (EditVideoData) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57739i = aVar;
        }

        @Override // d.a.s0.v3.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.c();
            }
        }

        @Override // d.a.s0.v3.b
        public void d(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                super.d(i2, str);
                this.f57739i.f57728a.getPageActivity().runOnUiThread(new d(this));
            }
        }

        @Override // d.a.s0.v3.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f57739i.f57728a.getPageActivity().runOnUiThread(new RunnableC1326c(this));
            }
        }

        @Override // d.a.s0.v3.b
        public void f(VideoInfo videoInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, videoInfo) == null) {
                super.f(videoInfo);
                String videoPath = videoInfo.getVideoPath();
                if (!k.isEmpty(videoPath) && videoPath.contains(d.a.s0.v3.c.f68591d)) {
                    File file = new File(videoPath);
                    videoPath = d.a.s0.v3.c.f68592e + file.getName();
                    FileHelper.copyFile(file.getAbsolutePath(), videoPath);
                }
                try {
                    this.f57739i.v(this.f57739i.f57728a.getPageActivity(), videoPath);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f57739i.j.finalPath = videoPath;
                this.f57739i.f57736i.setVideoPath(videoPath);
                this.f57739i.f57736i.setThumbPath(this.f68582c);
                this.f57739i.f57728a.getPageActivity().runOnUiThread(new e(this));
            }
        }

        @Override // d.a.s0.v3.b
        public void g(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                super.g(i2, str);
                this.f57739i.f57728a.getPageActivity().runOnUiThread(new b(this));
            }
        }

        @Override // d.a.s0.v3.b
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f57739i.f57728a.getPageActivity().runOnUiThread(new RunnableC1325a(this));
            }
        }
    }

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.l = new C1324a(this, 2921584);
        this.m = new b(this);
        this.f57728a = tbPageContext;
        PreviewVideoView previewVideoView = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.f57729b = previewVideoView;
        previewVideoView.setOnClickListener(this.m);
        this.f57730c = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.f57731d = (TextView) view.findViewById(R.id.write_video_state_text);
        this.f57732e = (TextView) view.findViewById(R.id.write_video_percent);
        TextView textView = (TextView) view.findViewById(R.id.write_video_retry);
        this.f57733f = textView;
        textView.setOnClickListener(this.m);
        this.l.setTag(this.f57728a.getUniqueId());
        MessageManager.getInstance().registerListener(this.l);
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f57729b.c();
            SkinManager.setViewTextColor(this.f57731d, this.k == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f57732e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f57733f, R.color.CAM_X0302);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.s0.v3.b bVar = this.f57734g;
            if (bVar == null) {
                this.f57734g = new c(this, (WriteActivity) this.f57728a.getPageActivity(), this.j);
            } else {
                bVar.j(this.j);
            }
            this.f57734g.i(false);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k == 2 : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PreviewVideoView previewVideoView = this.f57729b;
            return previewVideoView != null && previewVideoView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.s0.v3.b bVar = this.f57734g;
            if (bVar != null) {
                bVar.i(true);
            }
            d.a.s0.e0.b bVar2 = this.f57735h;
            if (bVar2 != null) {
                bVar2.cancel();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921585));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f57729b.g();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f57729b.d();
        }
    }

    public void s(VideoInfo videoInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, videoInfo, z) == null) {
            if (videoInfo == null) {
                this.j = null;
            } else {
                this.j = videoInfo.getEditVideoData();
            }
            this.f57736i = videoInfo;
            EditVideoData editVideoData = this.j;
            if (editVideoData != null && editVideoData.isLegal()) {
                this.f57730c.setVisibility(0);
                this.f57729b.setVisibility(0);
                this.f57729b.setVideoInfo(this.j);
                if (z) {
                    this.f57729b.j(1.0f);
                    return;
                }
                return;
            }
            this.f57730c.setVisibility(8);
            this.f57729b.setVisibility(8);
            this.f57729b.h();
            d.a.s0.v3.b bVar = this.f57734g;
            if (bVar != null) {
                bVar.i(true);
            }
            d.a.s0.e0.b bVar2 = this.f57735h;
            if (bVar2 != null) {
                bVar2.cancel();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921585));
        }
    }

    public final void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (tbPageContext = this.f57728a) != null && (tbPageContext.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.f57728a.getPageActivity()).showTip(this.f57728a.getString(R.string.write_video_mix_fail));
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.j == null) {
            return;
        }
        k();
        w(1, 10);
        d.a.s0.e0.b bVar = (d.a.s0.e0.b) MessageManager.getInstance().runTask(2921466, d.a.s0.e0.b.class, this.f57734g).getData();
        this.f57735h = bVar;
        if (bVar != null) {
            bVar.start();
        } else {
            w(3, 0);
        }
    }

    public final void v(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, context, str) == null) || context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            new MediaScannerClient(context).saveVideo(str);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(new File(str)));
            context.sendBroadcast(intent);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final void w(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            this.f57732e.setText(String.format(this.f57728a.getString(R.string.video_mix_percent), Integer.valueOf(i3)));
            if (i2 != this.k) {
                this.k = i2;
                SkinManager.setViewTextColor(this.f57731d, i2 == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
                if (i2 == 1) {
                    this.f57731d.setText(this.f57728a.getString(R.string.video_mixing));
                    this.f57732e.setVisibility(0);
                    this.f57733f.setVisibility(8);
                } else if (i2 == 3) {
                    this.f57731d.setText(this.f57728a.getString(R.string.video_mix_failed));
                    this.f57732e.setVisibility(8);
                    this.f57733f.setVisibility(0);
                } else {
                    this.f57731d.setText(this.f57728a.getString(R.string.video_mix_success));
                    this.f57732e.setVisibility(8);
                    this.f57733f.setVisibility(8);
                }
            }
            this.f57729b.j(i3 / 100.0f);
        }
    }
}
