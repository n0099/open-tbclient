package d.a.p0.h2.k.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.o0.r.f0.f;
import d.a.o0.r.q.a1;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.x1;
import d.a.o0.r.s.a;
import d.a.o0.r.s.b;
import d.a.o0.r.s.l;
import d.a.p0.h.g;
import d.a.p0.h.j;
import d.a.p0.h2.i.a;
import d.a.p0.h2.p.c;
import d.a.p0.h3.g0.a;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class t0 {
    public static /* synthetic */ Interceptable $ic;
    public static final int W1;
    public static int X1;
    public static int Y1;
    public static int Z1;
    public static int a2;
    public static int b2;
    public static int c2;
    public static final int d2;
    public static a.f e2;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.o0.r.s.a A;
    public d.a.p0.h2.h.e A0;
    public final TbImageView A1;
    public d.a.o0.r.s.b B;
    public PostData B0;
    public final d.a.p0.h2.o.j.a B1;
    public View C;
    public int C0;
    public RightFloatLayerView C1;
    public EditText D;
    public int D0;
    public final CustomMessageListener D1;
    public d.a.p0.h2.p.i E;
    public boolean E0;
    public boolean E1;
    public PbListView F;
    public ViewStub F0;
    public String F1;
    public d.a.p0.h2.p.e G;
    public PbInterviewStatusView G0;
    public CustomMessageListener G1;
    public View H;
    public FrameLayout H0;
    public Runnable H1;
    public View I;
    public TextView I0;
    public CustomMessageListener I1;
    public View.OnClickListener J;
    public View J0;
    public Handler J1;
    public TbRichTextView.x K;
    public View K0;
    public Runnable K1;
    public NoNetworkView.b L;
    public View L0;
    public CustomMessageListener L1;
    public d.a.o0.r.s.j M;
    public PbReplyTitleViewHolder M0;
    public PbFragment.s2 M1;
    public View.OnClickListener N;
    public View N0;
    public boolean N1;
    public d.a.o0.r.s.a O;
    public int O0;
    public View.OnClickListener O1;
    public Dialog P;
    public boolean P0;
    public boolean P1;
    public Dialog Q;
    public m0 Q0;
    public String Q1;
    public View R;
    public PbEmotionBar R0;
    public f.g R1;
    public LinearLayout S;
    public int S0;
    public final List<TbImageView> S1;
    public CompoundButton.OnCheckedChangeListener T;
    public int T0;
    public int T1;
    public TextView U;
    public Runnable U0;
    public boolean U1;
    public TextView V;
    public PbFakeFloorModel V0;
    public boolean V1;
    public String W;
    public d.a.p0.h2.k.e.u W0;
    public d.a.o0.r.s.j X;
    public o0 X0;
    public d.a.o0.r.s.j Y;
    public boolean Y0;
    public d.a.o0.r.s.e Z;
    public int Z0;

    /* renamed from: a  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f57424a;
    public boolean a0;
    public boolean a1;

    /* renamed from: b  reason: collision with root package name */
    public int f57425b;
    public boolean b0;
    public boolean b1;

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f57426c;
    public String c0;
    public boolean c1;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f57427d;
    public String d0;
    public int d1;

    /* renamed from: e  reason: collision with root package name */
    public View f57428e;
    public d.a.p0.h2.i.c e0;
    public PbTopTipView e1;

    /* renamed from: f  reason: collision with root package name */
    public int f57429f;
    public ScrollView f0;
    public PopupWindow f1;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f57430g;
    public EditorTools g0;
    public TextView g1;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.p0.h2.k.e.g1.c f57431h;
    public boolean h0;
    public List<String> h1;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.h2.k.e.g1.b f57432i;
    public View i0;
    public d.a.p0.h2.k.e.b1.c i1;
    public ViewStub j;
    public View j0;
    public d.a.p0.h2.k.d.a j1;
    public ViewStub k;
    public Button k0;
    public PbLandscapeListView.c k1;
    public PbLandscapeListView l;
    public View l0;
    public boolean l1;
    public NoNetworkView m;
    public View m0;
    public d.a.p0.h2.k.e.h0 m1;
    public List<CustomBlueCheckRadioButton> n;
    public LinearLayout n0;
    public NavigationBarCoverTip n1;
    public PbThreadPostView o;
    public HeadImageView o0;
    public d.a.p0.h.g o1;
    public d.a.p0.h2.k.e.a1.f p;
    public TextView p0;
    public d.a.p0.h.j p1;
    public d.a.p0.h2.k.e.a1.a q;
    public ImageView q0;
    public String q1;
    public d.a.p0.h2.k.e.a1.c r;
    public ImageView r0;
    public PermissionJudgePolicy r1;
    public d.a.p0.h2.k.e.a1.e s;
    public ImageView s0;
    public long s1;
    public d.a.p0.h2.k.e.a1.b t;
    public d.a.p0.h2.p.h t0;
    public boolean t1;
    public d.a.p0.h2.k.e.a1.d u;
    public TextView u0;
    public int u1;
    public LinearLayout v;
    public TextView v0;
    public int v1;
    public TextView w;
    public boolean w0;
    public boolean w1;
    public TextView x;
    public int x0;
    public d.a.p0.h2.p.g x1;
    public ObservedChangeRelativeLayout y;
    public d.a.o0.r.f0.a y0;
    public MaskView y1;
    public d.a.p0.h2.k.e.i z;
    public boolean z0;
    public final FallingView z1;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57433e;

        public a(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57433e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 1);
                    this.f57433e.f57426c.b4(sparseArray);
                    return;
                }
                this.f57433e.W1(view);
            } else if (booleanValue2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.f57433e.f57426c.b4(sparseArray);
            } else if (booleanValue3) {
                this.f57433e.S1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57434e;

        public a0(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57434e = t0Var;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f57434e.a0();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57435e;

        public b(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57435e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57435e.j2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57436e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b0 f57437e;

            public a(b0 b0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {b0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57437e = b0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f57437e.f57436e.f57426c.HidenSoftKeyPad((InputMethodManager) this.f57437e.f57436e.f57426c.getBaseFragmentActivity().getSystemService("input_method"), this.f57437e.f57436e.f57427d);
                }
            }
        }

        public b0(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57436e = t0Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f57436e.U0 == null) {
                    this.f57436e.U0 = new a(this);
                }
                d.a.c.e.m.e.a().postDelayed(this.f57436e.U0, 150L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f57438a;

        public c(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57438a = t0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f57438a.V0.E(postData);
                this.f57438a.z.V();
                this.f57438a.W0.c();
                this.f57438a.g0.q();
                this.f57438a.Y2(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
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
    public class d extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.t.a f57439a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f57440b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ t0 f57441c;

        public d(t0 t0Var, d.a.o0.t.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57441c = t0Var;
            this.f57439a = aVar;
            this.f57440b = i2;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.f57441c.v3(this.f57439a, bitmap, this.f57440b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d0(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
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
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57442e;

        public e(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57442e = t0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57442e.A1 == null) {
                return;
            }
            d.a.p0.h2.p.d.b(this.f57442e.A1);
        }
    }

    /* loaded from: classes8.dex */
    public static class e0 implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e0() {
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

        @Override // d.a.p0.h3.g0.a.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f57443a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(t0 t0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, Integer.valueOf(i2)};
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
            this.f57443a = t0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.f57443a.z == null) {
                return;
            }
            this.f57443a.z.V();
        }
    }

    /* loaded from: classes8.dex */
    public class f0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57444e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f57445f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f57446g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View f57447h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ t0 f57448i;

        public f0(t0 t0Var, int i2, int i3, int i4, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57448i = t0Var;
            this.f57444e = i2;
            this.f57445f = i3;
            this.f57446g = i4;
            this.f57447h = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f57444e;
                if (i2 == this.f57445f || i2 - this.f57446g >= 0) {
                    this.f57448i.f1.showAsDropDown(this.f57448i.m0, this.f57447h.getLeft(), -this.f57448i.m0.getHeight());
                } else {
                    this.f57448i.f1.showAsDropDown(this.f57447h);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57449e;

        public g(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57449e = t0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f57449e.v == null) {
                    this.f57449e.i1();
                }
                this.f57449e.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57450e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f57451f;

        public g0(t0 t0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57451f = t0Var;
            this.f57450e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57451f.C1.k();
                if (!StringUtils.isNull(this.f57450e)) {
                    this.f57451f.C1(this.f57450e);
                }
                this.f57451f.e1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2).param("obj_param1", 0));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f57452a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(t0 t0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, Integer.valueOf(i2)};
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
            this.f57452a = t0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f57452a.w0 = false;
        }
    }

    /* loaded from: classes8.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57453e;

        public h0(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57453e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57453e.C1.k();
                this.f57453e.e1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", 2).param("obj_locate", 2));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f57454a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(t0 t0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, Integer.valueOf(i2)};
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
            this.f57454a = t0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921552) {
                this.f57454a.e1();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f57455a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(t0 t0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, Integer.valueOf(i2)};
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
            this.f57455a = t0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.f57455a.F1 = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f57456a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f57457b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f57458c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f57459d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f57461f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ t0 f57462g;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f57463e;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57463e = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57463e.f57462g.N0 == null || this.f57463e.f57462g.N0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.f57463e.f57462g.N0.getLayoutParams();
                layoutParams.height = this.f57463e.f57462g.T0;
                this.f57463e.f57462g.N0.setLayoutParams(layoutParams);
            }
        }

        public j(t0 t0Var, int i2, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, Integer.valueOf(i2), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57462g = t0Var;
            this.f57456a = i2;
            this.f57457b = pbReplyTitleViewHolder;
            this.f57458c = z;
            this.f57459d = i3;
            this.f57460e = i4;
            this.f57461f = i5;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = this.f57456a;
                if (i3 >= 0 && i3 <= this.f57462g.f57427d.getMeasuredHeight()) {
                    int O0 = this.f57462g.O0(this.f57457b);
                    int i4 = this.f57456a;
                    int i5 = O0 - i4;
                    if (this.f57458c && i5 != 0 && i4 <= (i2 = this.f57459d)) {
                        i5 = O0 - i2;
                    }
                    if (this.f57462g.N0 == null || (layoutParams = this.f57462g.N0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i5 == 0 || i5 > this.f57462g.f57427d.getMeasuredHeight() || O0 >= this.f57462g.f57427d.getMeasuredHeight()) {
                        layoutParams.height = this.f57462g.T0;
                    } else {
                        if (layoutParams != null) {
                            int i6 = layoutParams.height;
                            if (i6 + i5 > 0 && i6 + i5 <= this.f57462g.f57427d.getMeasuredHeight()) {
                                layoutParams.height += i5;
                                this.f57462g.l.setSelectionFromTop(this.f57460e, this.f57461f);
                            }
                        }
                        layoutParams.height = this.f57462g.T0;
                    }
                    this.f57462g.N0.setLayoutParams(layoutParams);
                    d.a.c.e.m.e.a().post(new a(this));
                }
                this.f57462g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f57464e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f57465f;

        public j0(t0 t0Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57465f = t0Var;
            this.f57464e = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57465f.w1 || this.f57464e == null || this.f57465f.f57426c.y() == null || !this.f57465f.f57426c.y().c1()) {
                return;
            }
            this.f57465f.w1 = true;
            this.f57464e.Y3(false);
        }
    }

    /* loaded from: classes8.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57466e;

        public k(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57466e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57466e.j2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k0 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f57467a;

        public k0(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57467a = t0Var;
        }

        @Override // d.a.p0.h2.i.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57467a.f57426c.a5();
            }
        }

        @Override // d.a.p0.h2.i.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f57467a.l == null) {
                return;
            }
            if (this.f57467a.p != null) {
                this.f57467a.p.u();
            }
            this.f57467a.l.setSelection(0);
        }
    }

    /* loaded from: classes8.dex */
    public class l implements d.a.o0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57468e;

        public l(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57468e = t0Var;
        }

        @Override // d.a.o0.w.b
        public void onAction(d.a.o0.w.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f53489c;
                if (obj instanceof d.a.o0.s.c.v) {
                    if (((d.a.o0.s.c.v) obj).f() == EmotionGroupType.BIG_EMOTION || ((d.a.o0.s.c.v) aVar.f53489c).f() == EmotionGroupType.USER_COLLECT) {
                        if (this.f57468e.r1 == null) {
                            this.f57468e.r1 = new PermissionJudgePolicy();
                        }
                        this.f57468e.r1.clearRequestPermissionList();
                        this.f57468e.r1.appendRequestPermission(this.f57468e.f57426c.getBaseFragmentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                        if (this.f57468e.r1.startRequestPermission(this.f57468e.f57426c.getBaseFragmentActivity())) {
                            return;
                        }
                        this.f57468e.f57426c.M4().h((d.a.o0.s.c.v) aVar.f53489c);
                        this.f57468e.f57426c.M4().z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57469e;

        public l0(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57469e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new d.a.o0.r.q.s0(this.f57469e.f57426c.getActivity(), "pb_huitie"))) {
                this.f57469e.f57426c.C5();
                if (this.f57469e.f57426c == null || this.f57469e.f57426c.y() == null || this.f57469e.f57426c.y().D0() == null || this.f57469e.f57426c.y().D0().N() == null || this.f57469e.f57426c.y().D0().N().H() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f57469e.f57426c.y().U0()).param("fid", this.f57469e.f57426c.y().D0().n()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f57469e.f57426c.y().f19421e).param("fid", this.f57469e.f57426c.y().D0().n()).param("obj_locate", 1).param("uid", this.f57469e.f57426c.y().D0().N().H().getUserId()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57470e;

        public m(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57470e = t0Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f57470e.f57426c.E0 == null || this.f57470e.f57426c.E0.e() == null) {
                return;
            }
            if (!this.f57470e.f57426c.E0.e().e()) {
                this.f57470e.f57426c.E0.a(false);
            }
            this.f57470e.f57426c.E0.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int i5;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f57470e.g0 == null || this.f57470e.g0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2)) {
                return;
            }
            String substring = charSequence.toString().substring(i2, i5);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.f57470e.i1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.f57470e.g0.getId());
                t0 t0Var = this.f57470e;
                t0Var.i1 = new d.a.p0.h2.k.e.b1.c(t0Var.f57426c.getPageContext(), this.f57470e.f57427d, layoutParams);
                if (!ListUtils.isEmpty(this.f57470e.h1)) {
                    this.f57470e.i1.q(this.f57470e.h1);
                }
                this.f57470e.i1.r(this.f57470e.g0);
            }
            this.f57470e.i1.p(substring);
        }
    }

    /* loaded from: classes8.dex */
    public static class m0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f57471a;

        /* renamed from: b  reason: collision with root package name */
        public int f57472b;

        /* renamed from: c  reason: collision with root package name */
        public PbReplyTitleViewHolder f57473c;

        public m0() {
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
    }

    /* loaded from: classes8.dex */
    public class n implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f57474e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f57475f;

        public n(t0 t0Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57475f = t0Var;
            this.f57474e = z;
        }

        @Override // d.a.o0.r.s.l.e
        public void onItemClick(d.a.o0.r.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f57475f.M.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f57475f.S1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f57475f.M1 != null) {
                            this.f57475f.M1.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f57475f.f57426c.X4(this.f57474e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
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
    public class p implements g.InterfaceC1395g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f57476a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t0 f57477b;

        public p(t0 t0Var, d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57477b = t0Var;
            this.f57476a = aVar;
        }

        @Override // d.a.p0.h.g.InterfaceC1395g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f57477b.f57426c.k4(this.f57476a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f57478a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t0 f57479b;

        public q(t0 t0Var, d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57479b = t0Var;
            this.f57478a = aVar;
        }

        @Override // d.a.p0.h.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f57479b.f57426c.k4(this.f57478a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57480e;

        public r(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57480e = t0Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f57480e.W = (String) compoundButton.getTag();
                if (this.f57480e.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f57480e.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f57480e.W != null && !str.equals(this.f57480e.W)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57481e;

        public s(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57481e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f57481e.Q instanceof Dialog)) {
                d.a.c.e.m.g.b(this.f57481e.Q, this.f57481e.f57426c.getPageContext());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f57482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f57483f;

        public t(t0 t0Var, b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57483f = t0Var;
            this.f57482e = cVar;
        }

        @Override // d.a.o0.r.s.l.e
        public void onItemClick(d.a.o0.r.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f57483f.Y.dismiss();
                this.f57482e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f57484e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f57485f;

        public u(t0 t0Var, b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57485f = t0Var;
            this.f57484e = cVar;
        }

        @Override // d.a.o0.r.s.l.e
        public void onItemClick(d.a.o0.r.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f57485f.Y.dismiss();
                this.f57484e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57486e;

        public v(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57486e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!(view instanceof HeadImageView) || this.f57486e.A0 == null || this.f57486e.A0.N() == null || this.f57486e.A0.N().H() == null || this.f57486e.A0.N().H().getAlaInfo() == null || this.f57486e.A0.N().H().getAlaInfo().live_status != 1) {
                    if (this.f57486e.a1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.f57486e.a1 && this.f57486e.A0 != null && this.f57486e.A0.N() != null && this.f57486e.A0.N().H() != null && this.f57486e.A0.N().H().isBigV()) {
                        TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                    }
                    if (this.f57486e.f57426c.z() != null) {
                        this.f57486e.f57426c.z().mEvent.f57170b.onClick(view);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c11851");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c13715");
                statisticItem2.param("fid", this.f57486e.A0.n());
                statisticItem2.param("fname", this.f57486e.A0.o());
                statisticItem2.param("obj_param1", this.f57486e.A0.N().H().getAlaInfo().user_info != null ? this.f57486e.A0.N().H().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.f57486e.A0.P());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.f57486e.A0.N().H().getAlaInfo()));
                if (this.f57486e.A0.N().H().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.f57486e.A0.N().H().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.f57486e.A0.N().H().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.f57486e.f57426c.getPageContext(), this.f57486e.A0.N().H().getAlaInfo());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f57487e;

        public w(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57487e = t0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            t0 t0Var;
            d.a.p0.h2.k.e.g1.c cVar;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57487e.z == null || (cVar = (t0Var = this.f57487e).f57431h) == null || cVar.f57321i == null || t0Var.A0 == null || this.f57487e.A0.N() == null || this.f57487e.A0.N().q2() || this.f57487e.y1() || this.f57487e.A0.m() == null || d.a.c.e.p.k.isEmpty(this.f57487e.A0.m().getName())) {
                return;
            }
            if ((this.f57487e.z.H() == null || !this.f57487e.z.H().isShown()) && (linearLayout = this.f57487e.f57431h.f57321i) != null) {
                linearLayout.setVisibility(0);
                if (this.f57487e.f57426c == null || this.f57487e.f57426c.y() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", this.f57487e.f57426c.y().T0());
                statisticItem.param("fid", this.f57487e.f57426c.y().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57488e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f57489f;

        public x(t0 t0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57489f = t0Var;
            this.f57488e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (d.a.c.e.p.l.D()) {
                    UrlManager.getInstance().dealOneLink(this.f57489f.f57426c.getPageContext(), new String[]{this.f57488e});
                    this.f57489f.f57426c.finish();
                    return;
                }
                this.f57489f.f57426c.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Parcelable f57490e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f57491f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.h2.h.e f57492g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ t0 f57493h;

        public y(t0 t0Var, Parcelable parcelable, ArrayList arrayList, d.a.p0.h2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, parcelable, arrayList, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57493h = t0Var;
            this.f57490e = parcelable;
            this.f57491f = arrayList;
            this.f57492g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57493h.l.onRestoreInstanceState(this.f57490e);
                if (ListUtils.getCount(this.f57491f) <= 1 || this.f57492g.x().b() <= 0) {
                    return;
                }
                this.f57493h.F.f();
                this.f57493h.F.A(this.f57493h.f57426c.getString(R.string.pb_load_more_without_point));
                this.f57493h.F.v();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class z implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f57494a;

        public z(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57494a = t0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i2, int i3, float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) && this.f57494a.f57426c != null && this.f57494a.f57426c.isAdded()) {
                if (i2 < 0 && f2 > this.f57494a.d1) {
                    this.f57494a.a0();
                    this.f57494a.L1();
                }
                this.f57494a.h0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1551151626, "Ld/a/p0/h2/k/e/t0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1551151626, "Ld/a/p0/h2/k/e/t0;");
                return;
            }
        }
        W1 = UtilHelper.getLightStatusBarHeight();
        X1 = 3;
        Y1 = 0;
        Z1 = 3;
        a2 = 4;
        b2 = 5;
        c2 = 6;
        d2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        e2 = new e0();
    }

    public t0(PbFragment pbFragment, View.OnClickListener onClickListener, d.a.p0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57426c = null;
        this.f57427d = null;
        this.f57428e = null;
        this.f57429f = 0;
        this.f57430g = new Handler();
        this.l = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = false;
        this.b0 = false;
        this.c0 = null;
        this.d0 = null;
        this.f0 = null;
        this.h0 = false;
        this.k0 = null;
        this.m0 = null;
        this.p0 = null;
        this.w0 = true;
        this.y0 = null;
        this.z0 = false;
        this.D0 = 3;
        this.E0 = false;
        this.F0 = null;
        this.O0 = 0;
        this.P0 = true;
        this.Q0 = new m0();
        this.S0 = 0;
        this.Y0 = false;
        this.Z0 = 0;
        this.a1 = false;
        this.b1 = false;
        this.c1 = false;
        this.d1 = 0;
        this.l1 = false;
        this.s1 = 0L;
        this.v1 = 0;
        this.D1 = new i(this, 2921552);
        this.G1 = new i0(this, 2921306);
        this.H1 = new e(this);
        this.I1 = new f(this, 2005016);
        this.J1 = new Handler();
        this.L1 = new h(this, 2004009);
        this.N1 = true;
        this.O1 = new v(this);
        this.P1 = false;
        this.Q1 = null;
        this.S1 = new ArrayList();
        this.U1 = false;
        this.s1 = System.currentTimeMillis();
        this.f57426c = pbFragment;
        this.J = onClickListener;
        this.e0 = cVar;
        this.d1 = d.a.c.e.p.l.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f57426c.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.f57427d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.i0 = this.f57427d.findViewById(R.id.bottom_shadow);
        this.n1 = (NavigationBarCoverTip) this.f57427d.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.f57428e = this.f57427d.findViewById(R.id.statebar_view);
        this.C1 = (RightFloatLayerView) this.f57427d.findViewById(R.id.right_layer_view);
        this.f57426c.registerListener(this.D1);
        this.y = (ObservedChangeRelativeLayout) this.f57427d.findViewById(R.id.title_wrapper);
        this.m = (NoNetworkView) this.f57427d.findViewById(R.id.view_no_network);
        this.l = (PbLandscapeListView) this.f57427d.findViewById(R.id.new_pb_list);
        this.H0 = (FrameLayout) this.f57427d.findViewById(R.id.root_float_header);
        this.I0 = new TextView(this.f57426c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.a.c.e.p.l.g(this.f57426c.getActivity(), R.dimen.ds88));
        this.l.x(this.I0, 0);
        this.l.setTextViewAdded(true);
        this.T0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.N0 = new View(this.f57426c.getPageContext().getPageActivity());
        if (d.a.o0.c1.b.e.d()) {
            this.N0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.N0.setLayoutParams(new AbsListView.LayoutParams(-1, this.T0));
        }
        this.N0.setVisibility(4);
        this.l.addFooterView(this.N0);
        this.l.setOnTouchListener(this.f57426c.w2);
        this.f57424a = new j0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.f57424a);
        this.f57431h = new d.a.p0.h2.k.e.g1.c(pbFragment, this.f57427d);
        if (this.f57426c.E4()) {
            ViewStub viewStub = (ViewStub) this.f57427d.findViewById(R.id.manga_view_stub);
            this.j = viewStub;
            viewStub.setVisibility(0);
            d.a.p0.h2.k.e.g1.b bVar = new d.a.p0.h2.k.e.g1.b(pbFragment);
            this.f57432i = bVar;
            bVar.c();
            this.f57431h.f57313a.setVisibility(8);
            layoutParams.height = d.a.c.e.p.l.g(this.f57426c.getActivity(), R.dimen.ds120);
        }
        this.I0.setLayoutParams(layoutParams);
        this.f57431h.i().setOnTouchListener(new d.a.p0.h2.i.a(new k0(this)));
        this.l0 = this.f57427d.findViewById(R.id.view_comment_top_line);
        this.m0 = this.f57427d.findViewById(R.id.pb_editor_tool_comment);
        d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.x0 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
        HeadImageView headImageView = (HeadImageView) this.f57427d.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.o0 = headImageView;
        headImageView.setVisibility(0);
        this.o0.setIsRound(true);
        this.o0.setBorderWidth(d.a.c.e.p.l.g(this.f57426c.getContext(), R.dimen.L_X01));
        this.o0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.o0.setPlaceHolder(0);
        F1();
        this.p0 = (TextView) this.f57427d.findViewById(R.id.pb_editor_tool_comment_reply_text);
        LinearLayout linearLayout = (LinearLayout) this.f57427d.findViewById(R.id.pb_editer_tool_comment_layout);
        this.n0 = linearLayout;
        linearLayout.setOnClickListener(new l0(this));
        this.q0 = (ImageView) this.f57427d.findViewById(R.id.pb_editor_tool_comment_icon);
        this.y1 = (MaskView) this.f57427d.findViewById(R.id.mask_view);
        this.q0.setOnClickListener(this.J);
        boolean booleanExtra = this.f57426c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.f57427d.findViewById(R.id.pb_editor_tool_collection);
        this.r0 = imageView;
        imageView.setOnClickListener(this.J);
        if (booleanExtra) {
            this.r0.setVisibility(8);
        } else {
            this.r0.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) this.f57427d.findViewById(R.id.pb_editor_tool_share);
        this.s0 = imageView2;
        imageView2.setOnClickListener(this.J);
        d.a.p0.h2.p.h hVar = new d.a.p0.h2.p.h(this.s0);
        this.t0 = hVar;
        hVar.d();
        TextView textView = (TextView) this.f57427d.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.u0 = textView;
        textView.setVisibility(0);
        this.F0 = (ViewStub) this.f57427d.findViewById(R.id.interview_status_stub);
        this.q = new d.a.p0.h2.k.e.a1.a(this.f57426c, cVar);
        this.s = new d.a.p0.h2.k.e.a1.e(this.f57426c, cVar, this.J);
        d.a.p0.h2.k.e.i iVar = new d.a.p0.h2.k.e.i(this.f57426c, this.l);
        this.z = iVar;
        iVar.o0(this.J);
        this.z.q0(this.e0);
        this.z.l0(this.K);
        this.z.n0(this.f57426c.V1);
        a aVar = new a(this);
        this.N = aVar;
        this.z.k0(aVar);
        m1();
        g1();
        d.a.p0.h2.k.e.a1.d dVar = new d.a.p0.h2.k.e.a1.d(this.f57426c);
        this.u = dVar;
        dVar.f57082f = 2;
        this.r.a(this.l);
        this.s.g(this.l);
        this.q.a(this.l);
        PbListView pbListView = new PbListView(this.f57426c.getPageContext().getPageActivity());
        this.F = pbListView;
        View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
        this.H = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this.J);
            SkinManager.setBackgroundResource(this.H, R.drawable.pb_foot_more_trans_selector);
        }
        this.F.x();
        this.F.n(R.drawable.pb_foot_more_trans_selector);
        this.F.o(R.drawable.pb_foot_more_trans_selector);
        this.I = this.f57427d.findViewById(R.id.viewstub_progress);
        this.f57426c.registerListener(this.L1);
        this.V0 = new PbFakeFloorModel(this.f57426c.getPageContext());
        d.a.p0.h2.k.e.u uVar = new d.a.p0.h2.k.e.u(this.f57426c.getPageContext(), this.V0, this.f57427d);
        this.W0 = uVar;
        uVar.k(new b(this));
        this.W0.m(this.f57426c.Z1);
        this.V0.H(new c(this));
        if (this.f57426c.y() != null && !StringUtils.isNull(this.f57426c.y().G0())) {
            PbFragment pbFragment2 = this.f57426c;
            pbFragment2.showToast(pbFragment2.y().G0());
        }
        this.J0 = this.f57427d.findViewById(R.id.pb_expand_blank_view);
        this.K0 = this.f57427d.findViewById(R.id.bottom_rec_float_title);
        View findViewById2 = this.f57427d.findViewById(R.id.sticky_view);
        this.L0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f57426c.y() != null && this.f57426c.y().q0()) {
            this.J0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.L0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = W1;
            this.L0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f57426c.getPageContext(), this.f57427d.findViewById(R.id.pb_reply_expand_view));
        this.M0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.q(pbFragment.l0);
        this.M0.f19462g.setVisibility(8);
        this.M0.p(this.J);
        this.M0.o(this.f57426c.V1);
        this.f57426c.registerListener(this.I1);
        this.f57426c.registerListener(this.G1);
        PbFragment pbFragment3 = this.f57426c;
        this.x1 = new d.a.p0.h2.p.g(pbFragment3, pbFragment3.getUniqueId());
        this.z1 = (FallingView) this.f57427d.findViewById(R.id.falling_view);
        TbImageView tbImageView = (TbImageView) this.f57427d.findViewById(R.id.falling_ad_view);
        this.A1 = tbImageView;
        tbImageView.setPlaceHolder(2);
        V();
        i2(false);
        this.j0 = this.f57427d.findViewById(R.id.pb_comment_container);
        U(d.a.o0.c1.b.e.d());
        this.B1 = new d.a.p0.h2.o.j.a();
    }

    public static /* synthetic */ float D1(Random random) {
        return (random.nextInt(2) * 0.1f) + 0.8f;
    }

    public int A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (this.p != null) {
                if (lastVisiblePosition == this.l.getCount() - 1) {
                    lastVisiblePosition--;
                }
                if (lastVisiblePosition < 0) {
                    lastVisiblePosition = 0;
                }
            }
            return u0(lastVisiblePosition);
        }
        return invokeV.intValue;
    }

    public boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.E1 : invokeV.booleanValue;
    }

    public void A2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) {
            this.Y0 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.Z0 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void A3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) {
            this.f57431h.z(z2);
            if (z2 && this.E0) {
                this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                this.l.setNextPage(this.F);
                this.f57429f = 2;
            }
            F1();
        }
    }

    public BdTypeListView B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (BdTypeListView) invokeV.objValue;
    }

    public boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            EditorTools editorTools = this.g0;
            return editorTools != null && editorTools.u();
        }
        return invokeV.booleanValue;
    }

    public void B2(PbFragment.t2 t2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t2Var) == null) {
        }
    }

    public void B3(d.a.p0.h2.h.c cVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) || cVar == null) {
            return;
        }
        this.f57431h.A();
        if (!StringUtils.isNull(cVar.f56888b)) {
            this.f57431h.x(cVar.f56888b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
        int d3 = d.a.c.e.m.b.d(cVar.f56887a, 0);
        if (d3 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.self);
        } else if (d3 != 300) {
            string = d3 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.system);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.bawu);
        }
        this.f57426c.showNetRefreshView(this.f57427d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new x(this, cVar.f56889c));
    }

    public SparseArray<Object> C0(d.a.p0.h2.h.e eVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData t0;
        d.a.o0.r.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (eVar == null || (t0 = t0(eVar, z2)) == null) {
                return null;
            }
            String userId = t0.t().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, t0.E());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.U()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (t0.t() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, t0.t().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, t0.t().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, t0.t().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, t0.E());
                }
                sparseArray.put(R.id.tag_del_post_id, t0.E());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.U()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<x1> q2 = eVar.q();
                if (ListUtils.getCount(q2) > 0) {
                    sb = new StringBuilder();
                    for (x1 x1Var : q2) {
                        if (x1Var != null && !StringUtils.isNull(x1Var.g()) && (e0Var = x1Var.f52820g) != null && e0Var.f52641a && !e0Var.f52643c && ((i3 = e0Var.f52642b) == 1 || i3 == 2)) {
                            sb.append(d.a.c.e.p.k.cutString(x1Var.g(), 12));
                            sb.append(this.f57426c.getString(R.string.forum));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f57426c.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public final void C1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f57426c.getPageContext().getPageActivity(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public void C2(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xVar) == null) {
            this.K = xVar;
            this.z.l0(xVar);
            this.j1.q(this.K);
        }
    }

    public void C3(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            if (eVar != null && AntiHelper.o(eVar.N())) {
                d.a.p0.h2.p.h hVar = this.t0;
                if (hVar != null) {
                    hVar.h(false);
                    this.t0.g();
                }
                ViewGroup.LayoutParams layoutParams = this.s0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.s0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            d.a.p0.h2.p.h hVar2 = this.t0;
            if (hVar2 == null || !hVar2.e()) {
                ViewGroup.LayoutParams layoutParams2 = this.s0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.s0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public d.a.p0.h2.k.d.a D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j1 : (d.a.p0.h2.k.d.a) invokeV.objValue;
    }

    public void D2(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.L = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public boolean D3(d.a.p0.h2.h.e eVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, eVar, z2)) == null) {
            if (eVar == null) {
                return false;
            }
            if (this.r != null) {
                if (eVar.N() != null && eVar.N().j0() == 0 && !eVar.N().q2() && !this.E1) {
                    if (eVar.N() != null) {
                        b2 N = eVar.N();
                        N.J2(true, a3(eVar));
                        N.S3(3);
                        N.N3("2");
                    }
                    if (eVar.N().E1()) {
                        this.s.s(this.l);
                        this.r.d(this.l);
                        this.r.a(this.l);
                        this.s.g(this.l);
                        this.s.w(this.A0);
                        if (q1(eVar)) {
                            this.r.d(this.l);
                        } else {
                            this.r.e(eVar);
                        }
                    } else {
                        this.s.w(this.A0);
                        if (q1(eVar)) {
                            this.r.d(this.l);
                        } else {
                            this.r.g(eVar);
                        }
                    }
                } else if (eVar.N().j0() == 1) {
                    if (eVar.N() != null) {
                        this.r.d(this.l);
                        this.s.w(this.A0);
                    }
                } else {
                    this.r.d(this.l);
                    this.s.w(this.A0);
                }
            }
            s3(eVar);
            this.z0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final int E0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.G0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public /* synthetic */ void E1(d.a.o0.t.a aVar, int i2, View view) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<BaseFragmentActivity> pageContext = this.f57426c.getPageContext();
        urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + d.a.c.e.p.k.getUrlEncode(aVar.d())});
        TiebaStatic.log(new StatisticItem("c14126").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void E2(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public final void E3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.f57426c.E4()) {
            if (this.f57426c.J4() == -1) {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0110, 1);
            }
            if (this.f57426c.I4() == -1) {
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0110, 1);
            }
        }
    }

    public View F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.H : (View) invokeV.objValue;
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.o0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.o0.setImageResource(0);
                this.o0.M(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.o0.setImageResource(R.drawable.transparent_bg);
        }
    }

    public void F2(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public void F3(d.a.p0.h2.h.e eVar) {
        d.a.p0.h2.k.e.a1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, eVar) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.h(eVar, this.z0);
    }

    public PbListView G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.F : (PbListView) invokeV.objValue;
    }

    public void G1(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || this.D0 == i2) {
            return;
        }
        this.D0 = i2;
        t3(this.A0, this.z0);
        d2(this.A0, this.z0, this.C0, i2);
        this.f57426c.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f57426c.getBaseFragmentActivity().getLayoutMode().j(this.f57427d);
        SkinManager.setBackgroundColor(this.f57427d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.i0, R.color.CAM_X0203);
        d.a.p0.h2.k.e.a1.f fVar = this.p;
        if (fVar != null) {
            fVar.h(i2);
        }
        d.a.p0.h2.k.e.a1.b bVar = this.t;
        if (bVar != null) {
            bVar.c(i2);
        }
        d.a.p0.h2.k.e.a1.a aVar = this.q;
        if (aVar != null) {
            aVar.e(i2);
        }
        d.a.p0.h2.k.e.a1.c cVar = this.r;
        if (cVar != null) {
            cVar.c(i2);
        }
        d.a.p0.h2.k.e.a1.e eVar = this.s;
        if (eVar != null) {
            eVar.p(i2);
        }
        d.a.p0.h2.k.e.a1.d dVar = this.u;
        if (dVar != null) {
            dVar.d();
        }
        MaskView maskView = this.y1;
        if (maskView != null) {
            maskView.c();
        }
        PbListView pbListView = this.F;
        if (pbListView != null) {
            pbListView.d(i2);
        }
        if (this.H != null) {
            this.f57426c.getBaseFragmentActivity().getLayoutMode().j(this.H);
            SkinManager.setBackgroundResource(this.H, R.drawable.pb_foot_more_trans_selector);
        }
        d.a.o0.r.s.a aVar2 = this.A;
        if (aVar2 != null) {
            aVar2.autoChangeSkinType(this.f57426c.getPageContext());
        }
        z3(this.a0);
        this.z.V();
        d.a.p0.h2.p.i iVar = this.E;
        if (iVar != null) {
            iVar.I(i2);
        }
        EditorTools editorTools = this.g0;
        if (editorTools != null) {
            editorTools.w(i2);
        }
        d.a.p0.h2.p.e eVar2 = this.G;
        if (eVar2 != null) {
            eVar2.f(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        E3();
        UtilHelper.setStatusBarBackground(this.f57428e, i2);
        UtilHelper.setStatusBarBackground(this.L0, i2);
        if (this.v != null) {
            d.a.o0.s0.a.a(this.f57426c.getPageContext(), this.v);
        }
        d.a.p0.h2.k.e.u uVar = this.W0;
        if (uVar != null) {
            uVar.h(i2);
        }
        d.a.p0.h2.k.e.g1.c cVar2 = this.f57431h;
        if (cVar2 != null) {
            d.a.p0.h2.k.e.a1.f fVar2 = this.p;
            if (fVar2 != null) {
                fVar2.i(i2);
            } else {
                cVar2.m(i2);
            }
        }
        HeadImageView headImageView = this.o0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.n0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f57426c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        d.a.p0.h2.h.e eVar3 = this.A0;
        if (eVar3 != null && eVar3.s()) {
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.q0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        C3(this.A0);
        SkinManager.setBackgroundColor(this.m0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.l0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.g1, R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.p0, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.v0, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.u0, R.color.CAM_X0107);
        TextView textView = this.u0;
        int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        int i3 = R.color.CAM_X0207;
        SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3);
        d.a.p0.h2.k.d.a aVar3 = this.j1;
        if (aVar3 != null) {
            aVar3.m(i2);
        }
        PbEmotionBar pbEmotionBar = this.R0;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        d.a.p0.h2.p.h hVar = this.t0;
        if (hVar != null) {
            hVar.f();
        }
        d.a.p0.h2.p.g gVar = this.x1;
        if (gVar != null) {
            gVar.c();
        }
        RightFloatLayerView rightFloatLayerView = this.C1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.K0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.K0.findViewById(R.id.tv_title), R.color.CAM_X0105);
    }

    public void G2(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.z.p0(onClickListener);
        }
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            try {
                return Integer.parseInt(this.D.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public void H1(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, configuration) == null) || configuration == null) {
            return;
        }
        a0();
        if (configuration.orientation == 2) {
            X0();
            Z0();
        } else {
            j2();
        }
        d.a.p0.h2.k.e.u uVar = this.W0;
        if (uVar != null) {
            uVar.c();
        }
        this.f57426c.a5();
        this.y.setVisibility(8);
        this.f57431h.t(false);
        this.f57426c.Q5(false);
        if (this.p != null) {
            if (configuration.orientation == 1) {
                U0().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.V1 = true;
                this.l.setIsLandscape(true);
                this.l.smoothScrollToPosition(0);
            } else {
                this.V1 = false;
                this.l.setIsLandscape(false);
                int i2 = this.T1;
                if (i2 > 0) {
                    this.l.smoothScrollBy(i2, 0);
                }
            }
            this.p.j(configuration);
            this.H0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void H2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.u1 = i2;
        }
    }

    public View I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.J0 : (View) invokeV.objValue;
    }

    public void I1() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            RelativeLayout relativeLayout = this.f57427d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.f57427d.getHandler().removeCallbacksAndMessages(null);
            }
            d.a.p0.h2.p.h hVar = this.t0;
            if (hVar != null) {
                hVar.g();
            }
            o0 o0Var = this.X0;
            if (o0Var != null) {
                o0Var.a();
            }
            d.a.p0.h2.k.e.h0 h0Var = this.m1;
            if (h0Var != null) {
                h0Var.c();
            }
            PbTopTipView pbTopTipView = this.e1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.f57426c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.L) != null) {
                noNetworkView.d(bVar);
            }
            a0();
            g0();
            if (this.U0 != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.U0);
            }
            PbInterviewStatusView pbInterviewStatusView = this.G0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            this.J1 = null;
            this.f57430g.removeCallbacksAndMessages(null);
            this.z.W(3);
            View view = this.f57428e;
            if (view != null) {
                view.setBackgroundDrawable(null);
            }
            d.a.p0.h2.k.e.a1.f fVar = this.p;
            if (fVar != null) {
                fVar.a();
            }
            d.a.p0.h2.k.e.i iVar = this.z;
            if (iVar != null) {
                iVar.X();
            }
            this.l.setOnLayoutListener(null);
            d.a.p0.h2.k.e.b1.c cVar = this.i1;
            if (cVar != null) {
                cVar.l();
            }
            PbEmotionBar pbEmotionBar = this.R0;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            d.a.p0.h2.k.e.a1.e eVar = this.s;
            if (eVar != null) {
                eVar.q();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.f57424a);
            }
        }
    }

    public void I2(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onLongClickListener) == null) {
            this.s.t(onLongClickListener);
            this.z.m0(onLongClickListener);
            d.a.p0.h2.k.d.a aVar = this.j1;
            if (aVar != null) {
                aVar.r(onLongClickListener);
            }
        }
    }

    public PbFakeFloorModel J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.V0 : (PbFakeFloorModel) invokeV.objValue;
    }

    public void J1(TbRichText tbRichText) {
        d.a.p0.h2.h.e eVar;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, tbRichText) == null) || (eVar = this.A0) == null || eVar.E() == null || this.A0.E().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i2 = 0; i2 < this.A0.E().size() && (postData = this.A0.E().get(i2)) != null && postData.t() != null && !StringUtils.isNull(postData.t().getUserId()); i2++) {
            if (this.A0.E().get(i2).t().getUserId().equals(tbRichText.getAuthorId())) {
                d.a.p0.h2.k.d.a aVar = this.j1;
                if (aVar != null && aVar.l()) {
                    Y2(false);
                }
                PbEmotionBar pbEmotionBar = this.R0;
                if (pbEmotionBar != null) {
                    pbEmotionBar.q(true);
                }
                postData.t().getName_show();
                return;
            }
        }
    }

    public final void J2(PostData postData, d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, postData, eVar) == null) {
            this.s.u(postData, eVar);
        }
    }

    public d.a.p0.h2.k.e.u K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.W0 : (d.a.p0.h2.k.e.u) invokeV.objValue;
    }

    public boolean K1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
            d.a.p0.h2.k.e.a1.f fVar = this.p;
            if (fVar != null) {
                return fVar.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void K2(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048613, this, z2, postWriteCallBackData) == null) {
            this.f57426c.hideProgressBar();
            if (z2) {
                a0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                b0();
            } else {
                a0();
            }
        }
    }

    public d.a.p0.h2.k.e.a1.f L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.p : (d.a.p0.h2.k.e.a1.f) invokeV.objValue;
    }

    public void L1() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.f57426c == null) {
            return;
        }
        if ((this.t1 || this.u1 == 17) && d.a.o0.b.d.c0()) {
            d.a.p0.h2.h.e eVar = this.A0;
            if (eVar == null || eVar.m() == null || d.a.c.e.p.k.isEmpty(this.A0.m().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57426c.getContext()).createNormalCfg(this.A0.m().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.A0.P()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.A0.m().getId()));
        } else if (!this.b1 || this.a1 || (postData = this.B0) == null || postData.t() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.f57426c.isSimpleForum() ? 2 : 1).param("obj_type", this.a1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f57426c.getPageContext().getPageActivity(), this.B0.t().getUserId(), this.B0.t().getUserName(), this.f57426c.y().f0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.f57426c.hideProgressBar();
            g0();
            this.l.A(0L);
            d0();
        }
    }

    public final PostData M0(d.a.p0.h2.h.e eVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null || eVar.N().H() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData H = eVar.N().H();
            String userId = H.getUserId();
            HashMap<String, MetaData> u1 = eVar.N().u1();
            if (u1 != null && (metaData = u1.get(userId)) != null && metaData.getUserId() != null) {
                H = metaData;
            }
            postData.i0(1);
            postData.l0(eVar.N().T());
            postData.x0(eVar.N().getTitle());
            postData.w0(eVar.N().N());
            postData.g0(H);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void M1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z2) == null) {
            if (z2) {
                d3();
            } else {
                a1();
            }
            this.Q0.f57473c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Q0));
            Y1(this.Q0.f57473c, false);
        }
    }

    public void M2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (pbFragment = this.f57426c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        d.a.c.e.p.l.x(this.f57426c.getPageContext().getPageActivity(), this.f57426c.getBaseFragmentActivity().getCurrentFocus());
    }

    public String N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (!d.a.c.e.p.k.isEmpty(this.q1)) {
                return this.q1;
            }
            if (this.f57426c != null) {
                this.q1 = TbadkCoreApplication.getInst().getResources().getString(r0.b());
            }
            return this.q1;
        }
        return (String) invokeV.objValue;
    }

    public void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            y3();
            this.z.W(1);
            d.a.p0.h2.k.e.a1.f fVar = this.p;
            if (fVar != null) {
                fVar.l();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.F.x();
            this.F.O();
        }
    }

    public final int O0(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, pbReplyTitleViewHolder)) == null) {
            if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.a() == null) {
                return 0;
            }
            if (pbReplyTitleViewHolder.a().getTop() != 0 || pbReplyTitleViewHolder.a().isShown()) {
                return pbReplyTitleViewHolder.a().getBottom();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.z.W(2);
            d.a.p0.h2.k.e.a1.f fVar = this.p;
            if (fVar != null) {
                fVar.m();
                if (TbSingleton.getInstance().isNotchScreen(this.f57426c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f57426c.getFragmentActivity())) {
                    return;
                }
                V0().setSystemUiVisibility(4);
            }
        }
    }

    public void O2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) {
            this.s.v(z2);
        }
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? R.id.richText : invokeV.intValue;
    }

    public void P1(AbsListView absListView, int i2, int i3, int i4) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        d.a.p0.h2.k.e.a1.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048627, this, absListView, i2, i3, i4) == null) {
            d.a.p0.h2.k.e.a1.f fVar = this.p;
            if (fVar != null) {
                fVar.n(absListView, i2, i3, i4);
            }
            d.a.p0.h2.k.e.g1.c cVar = this.f57431h;
            if (cVar != null && (eVar = this.s) != null) {
                cVar.o(eVar.l());
            }
            m0 m0Var = this.Q0;
            m0Var.f57471a = i2;
            m0Var.f57472b = this.l.getHeaderViewsCount();
            this.Q0.f57473c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Q0));
            X2(Q(absListView, i2));
            int i5 = 0;
            Y1(this.Q0.f57473c, false);
            Z();
            if (!this.F.m() || this.F.C) {
                return;
            }
            m0 m0Var2 = this.Q0;
            if (m0Var2 != null && (pbReplyTitleViewHolder = m0Var2.f57473c) != null && pbReplyTitleViewHolder.a() != null) {
                i5 = this.Q0.f57473c.a().getTop() < 0 ? this.Q0.f57473c.a().getHeight() : this.Q0.f57473c.a().getBottom();
            }
            this.F.e(i5);
            this.F.C = true;
        }
    }

    public void P2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.p0.performClick();
            if (StringUtils.isNull(str) || this.f57426c.M4() == null || this.f57426c.M4().v() == null || this.f57426c.M4().v().i() == null) {
                return;
            }
            EditText i2 = this.f57426c.M4().v().i();
            i2.setText(str);
            i2.setSelection(str.length());
        }
    }

    public final boolean Q(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048629, this, absListView, i2)) == null) {
            if (absListView == null) {
                return false;
            }
            boolean z2 = i2 > 0;
            if (z2 || absListView.getChildCount() <= 0) {
                return z2;
            }
            return absListView.getChildAt(0).getTop() < absListView.getListPaddingTop();
        }
        return invokeLI.booleanValue;
    }

    public final int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            View childAt = this.l.getChildAt(0);
            if (childAt == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public void Q1(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048631, this, absListView, i2) == null) {
            d.a.p0.h2.k.e.a1.f fVar = this.p;
            if (fVar != null) {
                fVar.o(absListView, i2);
            }
            if (!this.V1 && i2 == 0) {
                this.T1 = Q0();
                this.Q0.f57473c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Q0));
                Y1(this.Q0.f57473c, true);
                Z();
                this.z.Z(true);
            }
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.C1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.C1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i2 != 2 || (rightFloatLayerView = this.C1) == null) {
            } else {
                rightFloatLayerView.r();
            }
        }
    }

    public void Q2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            this.l.setSelection(i2);
        }
    }

    public boolean R(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048633, this, z2)) == null) {
            EditorTools editorTools = this.g0;
            if (editorTools == null || !editorTools.u()) {
                return false;
            }
            this.g0.q();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public int R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.D0 : invokeV.intValue;
    }

    public void R1(ArrayList<d.a.o0.r.q.m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, arrayList) == null) {
            if (this.R == null) {
                this.R = LayoutInflater.from(this.f57426c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f57426c.getBaseFragmentActivity().getLayoutMode().j(this.R);
            if (this.Q == null) {
                Dialog dialog = new Dialog(this.f57426c.getPageContext().getPageActivity(), R.style.common_alert_dialog);
                this.Q = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.Q.setCancelable(true);
                this.f0 = (ScrollView) this.R.findViewById(R.id.good_scroll);
                this.Q.setContentView(this.R);
                WindowManager.LayoutParams attributes = this.Q.getWindow().getAttributes();
                attributes.width = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
                this.Q.getWindow().setAttributes(attributes);
                this.T = new r(this);
                this.S = (LinearLayout) this.R.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.R.findViewById(R.id.dialog_button_cancel);
                this.V = textView;
                textView.setOnClickListener(new s(this));
                TextView textView2 = (TextView) this.R.findViewById(R.id.dialog_button_ok);
                this.U = textView2;
                textView2.setOnClickListener(this.J);
            }
            this.S.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton W = W("0", this.f57426c.getPageContext().getString(R.string.thread_good_class));
            this.n.add(W);
            W.setChecked(true);
            this.S.addView(W);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    d.a.o0.r.q.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton W2 = W(String.valueOf(m0Var.a()), m0Var.b());
                        this.n.add(W2);
                        View view = new View(this.f57426c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.S.addView(view);
                        this.S.addView(W2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.f0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = d.a.c.e.p.l.e(this.f57426c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = d.a.c.e.p.l.e(this.f57426c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = d.a.c.e.p.l.e(this.f57426c.getPageContext().getPageActivity(), 186.0f);
                }
                this.f0.setLayoutParams(layoutParams2);
                this.f0.removeAllViews();
                LinearLayout linearLayout = this.S;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.f0.addView(this.S);
                }
            }
            d.a.c.e.m.g.j(this.Q, this.f57426c.getPageContext());
        }
    }

    public void R2(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048636, this, i2, i3) == null) {
            this.l.setSelectionFromTop(i2, i3);
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            PbListView pbListView = this.F;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.F.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
        }
        return invokeV.booleanValue;
    }

    public View S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.f57428e : (View) invokeV.objValue;
    }

    public void S1(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            T1(i2, str, i3, z2, null);
        }
    }

    public void S2(int i2) {
        NavigationBar navigationBar;
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048640, this, i2) == null) || this.l == null) {
            return;
        }
        d.a.p0.h2.k.e.g1.c cVar = this.f57431h;
        int i3 = 0;
        if (cVar != null && (navigationBar = cVar.f57313a) != null) {
            int fixedNavHeight = navigationBar.getFixedNavHeight();
            if (!(this.f57426c.x4() != -1)) {
                View view = this.L0;
                if (view != null && (layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams()) != null) {
                    layoutParams.height = 0;
                    this.L0.setLayoutParams(layoutParams);
                }
                i2--;
            }
            i3 = fixedNavHeight;
        }
        this.l.setSelectionFromTop(i2, i3);
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (!this.f57426c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.d0));
            } else if (this.f57426c.c4()) {
                d.a.o0.w.w.e M4 = this.f57426c.M4();
                if (M4 != null && (M4.B() || M4.D())) {
                    this.f57426c.M4().z(false, null);
                    return;
                }
                if (this.g0 != null) {
                    j1();
                }
                EditorTools editorTools = this.g0;
                if (editorTools != null) {
                    this.w0 = false;
                    if (editorTools.n(2) != null) {
                        d.a.p0.h3.g0.a.c(this.f57426c.getPageContext(), (View) this.g0.n(2).k, false, e2);
                    }
                }
                X0();
            }
        }
    }

    public PbThreadPostView T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public void T1(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            U1(i2, str, i3, z2, str2, false);
        }
    }

    public void T2(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, list) == null) {
            this.h1 = list;
            d.a.p0.h2.k.e.b1.c cVar = this.i1;
            if (cVar != null) {
                cVar.q(list);
            }
        }
    }

    public void U(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z2) == null) {
            if (z2) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            } else {
                this.l.setBackgroundResource(0);
            }
            View view = this.j0;
            if (view != null) {
                view.setVisibility(z2 ? 8 : 0);
            }
            PbListView pbListView = this.F;
            if (pbListView != null) {
                pbListView.I(z2 ? 8 : 0);
            }
            View view2 = this.H;
            if (view2 != null) {
                view2.setVisibility(z2 ? 8 : 0);
            }
        }
    }

    public RelativeLayout U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.y : (RelativeLayout) invokeV.objValue;
    }

    public void U1(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(Y1, Integer.valueOf(Z1));
            int i4 = R.string.del_all_post_confirm;
            if (i3 == 1002 && !z2) {
                i4 = R.string.report_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z2) {
                    i4 = R.string.report_thread_confirm;
                } else {
                    i4 = R.string.del_thread_confirm;
                }
            }
            this.O = new d.a.o0.r.s.a(this.f57426c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.O.setMessageId(i4);
            } else {
                this.O.setOnlyMessageShowCenter(false);
                this.O.setMessage(str2);
            }
            this.O.setYesButtonTag(sparseArray);
            this.O.setPositiveButton(R.string.dialog_ok, this.f57426c);
            this.O.setNegativeButton(R.string.dialog_cancel, new o(this));
            this.O.setCancelable(true);
            this.O.create(this.f57426c.getPageContext());
            if (z3) {
                this.O.show();
            } else if (z2) {
                this.O.show();
            } else if (U2()) {
                d.a.p0.h.i iVar = new d.a.p0.h.i(this.f57426c.y().D0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f57426c.y().D0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f57426c.y().D0().p().has_forum_rule.intValue());
                iVar.i(this.f57426c.y().D0().m().getId(), this.f57426c.y().D0().m().getName());
                iVar.h(this.f57426c.y().D0().m().getImage_url());
                iVar.j(this.f57426c.y().D0().m().getUser_level());
                g3(this.O, i2, iVar, this.f57426c.y().D0().T());
            } else {
                o3(this.O, i2);
            }
        }
    }

    public final boolean U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            PbFragment pbFragment = this.f57426c;
            return (pbFragment == null || pbFragment.y().D0().m().getDeletedReasonInfo() == null || 1 != this.f57426c.y().D0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            d.a.p0.h2.k.d.a aVar = new d.a.p0.h2.k.d.a(this.f57426c, this, (ViewStub) this.f57427d.findViewById(R.id.more_god_reply_popup));
            this.j1 = aVar;
            aVar.o(this.J);
            this.j1.p(this.N);
            this.j1.q(this.K);
            this.j1.o(this.J);
            this.j1.s(this.e0);
        }
    }

    public View V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.f57427d : (View) invokeV.objValue;
    }

    public void V1(SparseArray<Object> sparseArray, boolean z2) {
        d.a.o0.r.s.h hVar;
        d.a.o0.r.s.h hVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048651, this, sparseArray, z2) == null) {
            d.a.o0.r.s.l lVar = new d.a.o0.r.s.l(this.f57426c.getContext());
            lVar.q(this.f57426c.getString(R.string.bar_manager));
            lVar.n(new n(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                    hVar2 = new d.a.o0.r.s.h(10, this.f57426c.getString(R.string.delete_post), lVar);
                } else {
                    hVar2 = new d.a.o0.r.s.h(10, this.f57426c.getString(R.string.delete), lVar);
                }
                SparseArray sparseArray2 = new SparseArray();
                int i2 = R.id.tag_del_post_id;
                sparseArray2.put(i2, sparseArray.get(i2));
                int i3 = R.id.tag_del_post_type;
                sparseArray2.put(i3, sparseArray.get(i3));
                int i4 = R.id.tag_del_post_is_self;
                sparseArray2.put(i4, sparseArray.get(i4));
                int i5 = R.id.tag_manage_user_identity;
                sparseArray2.put(i5, sparseArray.get(i5));
                hVar2.f52897d.setTag(sparseArray2);
                arrayList.add(hVar2);
            }
            if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !A1()) {
                SparseArray sparseArray3 = new SparseArray();
                int i6 = R.id.tag_forbid_user_name;
                sparseArray3.put(i6, sparseArray.get(i6));
                int i7 = R.id.tag_forbid_user_name_show;
                sparseArray3.put(i7, sparseArray.get(i7));
                int i8 = R.id.tag_forbid_user_portrait;
                sparseArray3.put(i8, sparseArray.get(i8));
                int i9 = R.id.tag_manage_user_identity;
                sparseArray3.put(i9, sparseArray.get(i9));
                int i10 = R.id.tag_forbid_user_post_id;
                sparseArray3.put(i10, sparseArray.get(i10));
                d.a.o0.r.s.h hVar3 = new d.a.o0.r.s.h(11, this.f57426c.getString(R.string.forbidden_person), lVar);
                hVar3.f52897d.setTag(sparseArray3);
                arrayList.add(hVar3);
            }
            if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                int i11 = R.id.tag_is_mem;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = R.id.tag_user_mute_mute_userid;
                sparseArray4.put(i12, sparseArray.get(i12));
                int i13 = R.id.tag_user_mute_mute_username;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = R.id.tag_user_mute_mute_nameshow;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = R.id.tag_user_mute_post_id;
                sparseArray4.put(i15, sparseArray.get(i15));
                int i16 = R.id.tag_user_mute_thread_id;
                sparseArray4.put(i16, sparseArray.get(i16));
                int i17 = R.id.tag_user_mute_msg;
                sparseArray4.put(i17, sparseArray.get(i17));
                if (z2) {
                    hVar = new d.a.o0.r.s.h(12, this.f57426c.getString(R.string.un_mute), lVar);
                } else {
                    hVar = new d.a.o0.r.s.h(12, this.f57426c.getString(R.string.mute), lVar);
                }
                hVar.f52897d.setTag(sparseArray4);
                arrayList.add(hVar);
            }
            d.a.p0.h2.k.e.f1.a.e(arrayList);
            if (d.a.o0.b.d.J()) {
                lVar.l(arrayList, false);
            } else {
                lVar.l(arrayList, true);
            }
            d.a.o0.r.s.j jVar = new d.a.o0.r.s.j(this.f57426c.getPageContext(), lVar);
            this.M = jVar;
            jVar.l();
        }
    }

    public void V2() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.H0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            d.a.p0.h2.k.e.g1.c cVar = this.f57431h;
            if (cVar == null || (view = cVar.f57316d) == null) {
                return;
            }
            view.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public final CustomBlueCheckRadioButton W(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048653, this, str, str2)) == null) {
            Activity pageActivity = this.f57426c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, d.a.c.e.p.l.g(pageActivity, R.dimen.ds100));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.T);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void W0() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.H0.setVisibility(8);
            }
            d.a.p0.h2.k.e.g1.c cVar = this.f57431h;
            if (cVar == null || (view = cVar.f57316d) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public void W1(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048655, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        V1(sparseArray, false);
    }

    public void W2() {
        d.a.p0.h2.k.e.a1.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048656, this) == null) || (fVar = this.p) == null) {
            return;
        }
        fVar.v(this.l);
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048657, this) == null) || this.U1) {
            return;
        }
        TiebaStatic.log("c10490");
        this.U1 = true;
        d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f57426c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(Y1, Integer.valueOf(a2));
        aVar.setTitle(R.string.grade_thread_tips);
        View inflate = LayoutInflater.from(this.f57426c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
        ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
        aVar.setContentView(inflate);
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(R.string.grade_button_tips, this.f57426c);
        aVar.setNegativeButton(R.string.look_again, new c0(this));
        aVar.create(this.f57426c.getPageContext()).show();
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048658, this) == null) || this.m0 == null) {
            return;
        }
        this.l0.setVisibility(8);
        this.m0.setVisibility(8);
        this.w0 = false;
        PbEmotionBar pbEmotionBar = this.R0;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            i2(false);
        }
    }

    public void X1(d.a.o0.t.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048659, this, aVar, i2) == null) && r0.a(aVar, i2)) {
            this.A1.M(aVar.f(), 10, false);
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.e())).setProgressiveRenderingEnabled(true).build(), this.f57426c.getContext()).subscribe(new d(this, aVar, i2), CallerThreadExecutor.getInstance());
        }
    }

    public void X2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z2) == null) {
            this.i0.setVisibility(z2 ? 0 : 8);
        }
    }

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f57426c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f57426c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            aVar.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(Y1, Integer.valueOf(b2));
            aVar.setYesButtonTag(sparseArray);
            aVar.setPositiveButton(R.string.view, this.f57426c);
            aVar.setNegativeButton(R.string.cancel, new d0(this));
            aVar.create(this.f57426c.getPageContext()).show();
        }
    }

    public void Y0(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048662, this, z2) == null) || this.m0 == null || this.p0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        d.a.p0.h2.h.e eVar = this.A0;
        boolean z3 = eVar != null && eVar.g0();
        d.a.p0.h2.h.e eVar2 = this.A0;
        this.p0.setText(tbSingleton.getAdVertiComment(z3, eVar2 != null && eVar2.h0(), N0()));
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.m0.startAnimation(alphaAnimation);
        }
        this.l0.setVisibility(0);
        this.m0.setVisibility(0);
        this.w0 = true;
        if (this.R0 == null || this.j1.l()) {
            return;
        }
        this.R0.setVisibility(0);
        i2(true);
    }

    public final void Y1(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048663, this, pbReplyTitleViewHolder, z2) == null) || this.a1 || this.J0 == null || this.f57431h.i() == null) {
            return;
        }
        View r2 = l0().r();
        if (r2 != null) {
            int[] iArr = new int[2];
            r2.getLocationInWindow(iArr);
            int i3 = iArr[1];
            if (i3 != 0) {
                if (this.J0.getVisibility() == 0 && i3 - this.f57431h.i().getBottom() <= this.J0.getHeight()) {
                    this.K0.setVisibility(0);
                    if (i3 > this.f57431h.i().getBottom()) {
                        i2 = -(((this.J0.getHeight() + this.K0.getHeight()) + this.f57431h.i().getBottom()) - r2.getBottom());
                    } else {
                        i2 = -this.J0.getHeight();
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J0.getLayoutParams();
                    if (layoutParams.topMargin != i2) {
                        layoutParams.topMargin = i2;
                        this.J0.setLayoutParams(layoutParams);
                    }
                } else {
                    this.K0.setVisibility(4);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.J0.getLayoutParams();
                    if (layoutParams2.topMargin != 0) {
                        layoutParams2.topMargin = 0;
                        this.J0.setLayoutParams(layoutParams2);
                    }
                }
            }
        }
        int G = this.z.G();
        if (G > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.a().getParent() == null)) {
            if (G > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                this.J0.setVisibility(4);
                return;
            }
            this.J0.setVisibility(0);
            X2(false);
            this.f57431h.f57313a.hideBottomLine();
            if (this.J0.getParent() == null || ((ViewGroup) this.J0.getParent()).getHeight() > this.J0.getTop()) {
                return;
            }
            this.J0.getParent().requestLayout();
        } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.a() != null && pbReplyTitleViewHolder.f19462g != null) {
            int top = pbReplyTitleViewHolder.a().getTop();
            if (pbReplyTitleViewHolder.a().getParent() != null) {
                if (this.P0) {
                    this.O0 = top;
                    this.P0 = false;
                }
                int i4 = this.O0;
                if (top < i4) {
                    i4 = top;
                }
                this.O0 = i4;
            }
            if (top != 0 || pbReplyTitleViewHolder.a().isShown()) {
                if (this.y.getY() < 0.0f) {
                    measuredHeight = W1 - pbReplyTitleViewHolder.f19462g.getMeasuredHeight();
                } else {
                    measuredHeight = this.f57431h.i().getMeasuredHeight() - pbReplyTitleViewHolder.f19462g.getMeasuredHeight();
                    this.f57431h.f57313a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.a().getParent() == null && top <= this.O0) {
                    this.J0.setVisibility(0);
                    X2(false);
                } else if (top < measuredHeight) {
                    this.J0.setVisibility(0);
                    X2(false);
                } else {
                    this.J0.setVisibility(4);
                    this.f57431h.f57313a.hideBottomLine();
                }
                if (z2) {
                    this.P0 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.J0.setVisibility(4);
            this.f57431h.f57313a.hideBottomLine();
        }
    }

    public void Y2(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048664, this, z2) == null) || this.m0 == null) {
            return;
        }
        q2(this.f57426c.M4().C());
        if (this.h0) {
            b3(z2);
        } else {
            Y0(z2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.v1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Z() {
        d.a.p0.h2.p.g gVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048665, this) == null) || (gVar = this.x1) == null) {
            return;
        }
        if (((gVar.a() == null || this.x1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.x1.a())) != -1) {
            if (this.x1.a().getTop() + d2 <= this.J0.getBottom()) {
                this.v1 = 1;
                z2 = true;
            } else {
                this.v1 = 0;
                z2 = false;
            }
        }
        this.M0.s(this.v1 == 1);
        this.x1.e(z2);
    }

    public void Z0() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048666, this) == null) || (editorTools = this.g0) == null) {
            return;
        }
        editorTools.o();
        d.a.p0.h2.k.e.b1.c cVar = this.i1;
        if (cVar != null) {
            cVar.m();
        }
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            this.s.r(this.A0, this.B0, this.b1, this.a1);
        }
    }

    public void Z2(d.a.p0.h2.h.e eVar) {
        PostData postData;
        d.a.p0.h2.k.e.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048668, this, eVar) == null) || eVar == null || (postData = this.B0) == null || postData.t() == null || (cVar = this.f57431h) == null) {
            return;
        }
        boolean z2 = !this.a1;
        this.b1 = z2;
        cVar.y(z2);
        if (this.f57426c.N4() != null) {
            this.f57426c.N4().s(this.b1);
        }
        Z1();
        PbFragment pbFragment = this.f57426c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(eVar.q())) {
            x1 x1Var = eVar.q().get(0);
            if (x1Var != null) {
                this.f57431h.B(x1Var.g(), x1Var.a());
            }
        } else if (eVar.m() != null) {
            this.f57431h.B(eVar.m().getName(), eVar.m().getImage_url());
        }
        if (this.b1) {
            this.s.B(eVar, this.B0, this.b0);
            View view = this.L0;
            if (view != null) {
                view.setVisibility(8);
            }
            if (this.k1 == null) {
                this.k1 = new z(this);
            }
            this.l.setListViewDragListener(this.k1);
            return;
        }
        View view2 = this.L0;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.s.B(eVar, this.B0, this.b0);
        this.k1 = null;
        this.l.setListViewDragListener(null);
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            this.f57431h.e();
            d.a.p0.h2.k.e.a1.e eVar = this.s;
            if (eVar != null) {
                eVar.j();
            }
            PbFragment pbFragment = this.f57426c;
            if (pbFragment != null) {
                d.a.c.e.p.l.x(pbFragment.getContext(), this.D);
            }
            Z0();
            d.a.o0.r.s.j jVar = this.X;
            if (jVar != null) {
                jVar.dismiss();
            }
            e0();
            d.a.o0.r.s.a aVar = this.A;
            if (aVar != null) {
                aVar.dismiss();
            }
            d.a.o0.r.s.b bVar = this.B;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void a1() {
        d.a.p0.h2.k.e.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048671, this) == null) || (cVar = this.f57431h) == null) {
            return;
        }
        cVar.j();
    }

    public void a2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048672, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.Z0;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.Q0.f57473c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Q0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.Q0.f57473c;
        int O0 = O0(pbReplyTitleViewHolder);
        int measuredHeight = this.y.getMeasuredHeight() + ((int) this.y.getY());
        boolean z2 = this.J0.getVisibility() == 0;
        boolean z3 = this.y.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.z.G() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.f19462g.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.z.G() + this.l.getHeaderViewsCount(), W1 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.z.G() + this.l.getHeaderViewsCount(), this.f57431h.i().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.a1 && this.p != null) {
            this.l.setSelectionFromTop(this.z.G() + this.l.getHeaderViewsCount(), this.p.d());
        } else if (this.C0 != 6) {
        } else {
            this.l.setOnLayoutListener(new j(this, O0, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public final boolean a3(d.a.p0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null) {
                return false;
            }
            return eVar.N().g0() == 1 || eVar.N().j1() == 33 || !(eVar.N().q1() == null || eVar.N().q1().a() == 0) || eVar.N().m0() == 1 || eVar.N().l0() == 1 || eVar.N().B1() || eVar.N().T1() || eVar.N().t2() || eVar.N().y1() != null || !d.a.c.e.p.k.isEmpty(eVar.N().L()) || eVar.N().Q1() || eVar.N().e2();
        }
        return invokeL.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            this.f57431h.e();
            d.a.p0.h2.k.e.a1.e eVar = this.s;
            if (eVar != null) {
                eVar.j();
            }
            d.a.o0.r.s.j jVar = this.X;
            if (jVar != null) {
                jVar.dismiss();
            }
            e0();
            d.a.o0.r.s.a aVar = this.A;
            if (aVar != null) {
                aVar.dismiss();
            }
            d.a.o0.r.s.b bVar = this.B;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void b1() {
        d.a.o0.r.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048675, this) == null) || (aVar = this.y0) == null) {
            return;
        }
        aVar.h(false);
    }

    public final void b2(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048676, this, eVar) == null) || eVar == null || eVar.N() == null) {
            return;
        }
        C3(eVar);
        if (eVar.s()) {
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String k02 = k0(eVar.N().P0());
        TextView textView = this.u0;
        if (textView != null) {
            textView.setText(k02);
        }
        TextView textView2 = this.v0;
        if (textView2 != null) {
            textView2.setText(k02);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.N()));
    }

    public void b3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048677, this, z2) == null) || this.m0 == null || (textView = this.p0) == null) {
            return;
        }
        textView.setText(R.string.draft_to_send);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.m0.startAnimation(alphaAnimation);
        }
        this.l0.setVisibility(0);
        this.m0.setVisibility(0);
        this.w0 = true;
        if (this.R0 == null || this.j1.l()) {
            return;
        }
        this.R0.setVisibility(0);
        i2(true);
    }

    public void c0() {
        d.a.p0.h2.p.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048678, this) == null) || (hVar = this.t0) == null) {
            return;
        }
        hVar.h(false);
    }

    public void c1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            if (this.v == null) {
                i1();
            }
            this.k.setVisibility(8);
            Handler handler = this.J1;
            if (handler == null || (runnable = this.K1) == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public void c2(int i2, d.a.p0.h2.h.e eVar, boolean z2, int i3) {
        PostData t0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048680, this, new Object[]{Integer.valueOf(i2), eVar, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) || i2 <= 0 || (t0 = t0(eVar, z2)) == null || t0.t() == null) {
            return;
        }
        MetaData t2 = t0.t();
        t2.setGiftNum(t2.getGiftNum() + i2);
    }

    public void c3(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048681, this, view) == null) || d.a.o0.r.d0.b.j().g("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.m0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f57426c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f57426c.getContext());
        this.g1 = textView;
        textView.setText(R.string.connection_tips);
        this.g1.setGravity(17);
        this.g1.setPadding(d.a.c.e.p.l.g(this.f57426c.getContext(), R.dimen.ds24), 0, d.a.c.e.p.l.g(this.f57426c.getContext(), R.dimen.ds24), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = d.a.c.e.p.l.g(this.f57426c.getContext(), R.dimen.ds60);
        if (this.g1.getParent() == null) {
            frameLayout.addView(this.g1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f57426c.getContext());
        this.f1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.f1.setHeight(-2);
        this.f1.setWidth(-2);
        this.f1.setFocusable(true);
        this.f1.setOutsideTouchable(false);
        this.f1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new f0(this, i4, i2, i3, view), 100L);
        d.a.o0.r.d0.b.j().t("show_long_press_collection_tips", true);
    }

    public final boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.q.b(this.z0) : invokeV.booleanValue;
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            this.I.setVisibility(8);
        }
    }

    public void d2(d.a.p0.h2.h.e eVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048684, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            j3(eVar, z2, i2, i3);
            this.s.p(i3);
        }
    }

    public void d3() {
        d.a.p0.h2.k.e.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048685, this) == null) || (cVar = this.f57431h) == null || this.c1) {
            return;
        }
        cVar.u();
        this.c1 = true;
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            d.a.o0.r.s.a aVar = this.O;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.P;
            if (dialog != null) {
                d.a.c.e.m.g.b(dialog, this.f57426c.getPageContext());
            }
            Dialog dialog2 = this.Q;
            if (dialog2 != null) {
                d.a.c.e.m.g.b(dialog2, this.f57426c.getPageContext());
            }
            d.a.o0.r.s.j jVar = this.M;
            if (jVar != null) {
                jVar.dismiss();
            }
        }
    }

    public void e1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048687, this) == null) || (rightFloatLayerView = this.C1) == null) {
            return;
        }
        rightFloatLayerView.f();
    }

    public final void e2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048688, this) == null) && (pbInterviewStatusView = this.G0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.G0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.G0.setLayoutParams(layoutParams);
        }
    }

    public void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public void f0() {
        d.a.p0.h2.k.e.a1.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048690, this) == null) || (fVar = this.p) == null) {
            return;
        }
        fVar.b();
    }

    public void f1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048691, this) == null) || (editorTools = this.g0) == null) {
            return;
        }
        editorTools.q();
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048692, this) == null) || this.f57429f == 2) {
            return;
        }
        this.l.setNextPage(this.F);
        this.f57429f = 2;
    }

    public void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            if (this.y0 == null) {
                this.y0 = new d.a.o0.r.f0.a(this.f57426c.getPageContext());
            }
            this.y0.h(true);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            PbListView pbListView = this.F;
            if (pbListView != null) {
                pbListView.v();
                this.F.f();
            }
            b1();
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048695, this) == null) && this.r == null) {
            this.r = new d.a.p0.h2.k.e.a1.c(this.f57426c, this.e0);
        }
    }

    public void g2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048696, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.r.d(pbLandscapeListView);
        this.s.s(this.l);
        this.t.d(this.l);
        this.q.f(this.l);
    }

    public final void g3(d.a.o0.r.s.a aVar, int i2, d.a.p0.h.i iVar, UserData userData) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048697, this, aVar, i2, iVar, userData) == null) || (pbFragment = this.f57426c) == null || aVar == null) {
            return;
        }
        if (this.p1 == null && this.q != null) {
            this.p1 = new d.a.p0.h.j(pbFragment.getPageContext(), this.q.c(), iVar, userData);
        }
        AntiData s4 = this.f57426c.s4();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (s4 != null && s4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = s4.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        d.a.o0.r.q.w0 w0Var = new d.a.o0.r.q.w0();
        w0Var.j(sparseArray);
        this.p1.B(new String[]{this.f57426c.getString(R.string.delete_thread_reason_1), this.f57426c.getString(R.string.delete_thread_reason_2), this.f57426c.getString(R.string.delete_thread_reason_3), this.f57426c.getString(R.string.delete_thread_reason_4), this.f57426c.getString(R.string.delete_thread_reason_5)});
        this.p1.A(w0Var);
        this.p1.D((i2 == 1 || i2 == 2) ? "4" : "3");
        this.p1.C(new q(this, aVar));
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            this.l.A(0L);
            d0();
        }
    }

    public final void h1(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048699, this, eVar) == null) && eVar != null && eVar.N() != null && eVar.N().T1() && this.G0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.F0.inflate();
            this.G0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.J);
            this.G0.setCallback(this.f57426c.C4());
            this.G0.setData(this.f57426c, eVar);
        }
    }

    public final void h2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048700, this) == null) || (pbFragment = this.f57426c) == null || pbFragment.M4() == null || this.g0 == null) {
            return;
        }
        d.a.o0.w.w.a.a().c(0);
        d.a.o0.w.w.e M4 = this.f57426c.M4();
        M4.T();
        M4.R();
        if (M4.y() != null) {
            M4.y().setMaxImagesAllowed(M4.z ? 1 : 9);
        }
        M4.l0(SendView.k);
        M4.j(SendView.k);
        d.a.o0.w.h m2 = this.g0.m(23);
        d.a.o0.w.h m3 = this.g0.m(2);
        d.a.o0.w.h m4 = this.g0.m(5);
        if (m3 != null) {
            m3.b();
        }
        if (m4 != null) {
            m4.b();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.g0.invalidate();
    }

    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048701, this) == null) {
            this.z.a0(this.A0, false);
            this.z.V();
        }
    }

    public void i0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048702, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f57426c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f57426c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.success));
            } else if (z3) {
                if (d.a.c.e.p.k.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                }
                this.f57426c.showToast(str);
            }
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048703, this) == null) && this.f57426c.E4()) {
            ViewStub viewStub = (ViewStub) this.f57427d.findViewById(R.id.manga_mention_controller_view_stub);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.v == null) {
                this.v = (LinearLayout) this.f57427d.findViewById(R.id.manga_controller_layout);
                d.a.o0.s0.a.a(this.f57426c.getPageContext(), this.v);
            }
            if (this.w == null) {
                this.w = (TextView) this.v.findViewById(R.id.manga_prev_btn);
            }
            if (this.x == null) {
                this.x = (TextView) this.v.findViewById(R.id.manga_next_btn);
            }
            this.w.setOnClickListener(this.J);
            this.x.setOnClickListener(this.J);
        }
    }

    public final void i2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048704, this, z2) == null) {
        }
    }

    public void i3(d.a.p0.h2.h.e eVar, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Parcelable e3;
        Parcelable e4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048705, this, new Object[]{eVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) || eVar == null || this.l == null) {
            return;
        }
        this.A0 = eVar;
        this.C0 = i2;
        if (eVar.N() != null) {
            this.S0 = eVar.N().M();
            if (eVar.N().D() != 0) {
                this.P1 = true;
            }
            this.b0 = w1(eVar.N());
        }
        if (eVar.T() != null) {
            this.Q1 = eVar.T().getUserId();
        }
        h1(eVar);
        this.E0 = false;
        this.z0 = z2;
        L2();
        d.a.p0.h2.h.k kVar = eVar.f56900h;
        if (kVar != null && kVar.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f57426c.getContext());
                this.o = pbThreadPostView;
                this.l.x(pbThreadPostView, 1);
                this.o.setData(eVar);
                this.o.setChildOnClickLinstener(this.J);
            }
        } else {
            PbThreadPostView pbThreadPostView2 = this.o;
            if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                pbLandscapeListView.removeHeaderView(pbThreadPostView2);
            }
        }
        j3(eVar, z2, i2, TbadkCoreApplication.getInst().getSkinType());
        Z2(eVar);
        if (this.m1 == null) {
            this.m1 = new d.a.p0.h2.k.e.h0(this.f57426c.getPageContext(), this.n1);
        }
        this.m1.a(eVar.w());
        if (this.f57426c.E4()) {
            if (this.E == null) {
                d.a.p0.h2.p.i iVar = new d.a.p0.h2.p.i(this.f57426c.getPageContext());
                this.E = iVar;
                iVar.n();
                this.E.a(this.R1);
            }
            this.l.setPullRefresh(this.E);
            k2();
            d.a.p0.h2.p.i iVar2 = this.E;
            if (iVar2 != null) {
                iVar2.I(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (eVar.x().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.E == null) {
                d.a.p0.h2.p.i iVar3 = new d.a.p0.h2.p.i(this.f57426c.getPageContext());
                this.E = iVar3;
                iVar3.n();
                this.E.a(this.R1);
            }
            this.l.setPullRefresh(this.E);
            k2();
            d.a.p0.h2.p.i iVar4 = this.E;
            if (iVar4 != null) {
                iVar4.I(TbadkCoreApplication.getInst().getSkinType());
            }
            b1();
        }
        d0();
        this.z.h0(this.z0);
        this.z.e0(false);
        this.z.f0(i2 == 5);
        this.z.g0(i2 == 6);
        this.z.c0(z3 && this.N1 && i2 != 2);
        this.z.a0(eVar, false);
        this.z.V();
        this.s.A(t0(eVar, z2), eVar.e0());
        if (eVar.N() != null && eVar.N().G0() != null && this.f57425b != -1) {
            eVar.N().G0().setIsLike(this.f57425b);
        }
        this.l.removeFooterView(this.N0);
        this.l.addFooterView(this.N0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.F);
            this.f57429f = 2;
            b1();
        } else {
            this.E0 = true;
            if (eVar.x().b() == 1) {
                if (this.G == null) {
                    PbFragment pbFragment = this.f57426c;
                    this.G = new d.a.p0.h2.p.e(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.G);
            } else {
                this.l.setNextPage(this.F);
            }
            this.f57429f = 3;
        }
        ArrayList<PostData> E = eVar.E();
        if (eVar.x().b() != 0 && E != null && E.size() >= eVar.x().e()) {
            if (z3) {
                if (this.N1) {
                    g0();
                    if (eVar.x().b() != 0) {
                        this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                    }
                } else {
                    this.F.x();
                    this.F.L();
                }
            } else {
                this.F.x();
                this.F.L();
            }
            this.F.j();
        } else {
            if (ListUtils.getCount(E) != 0 && (ListUtils.getCount(E) != 1 || E.get(0) == null || E.get(0).A() != 1)) {
                if (eVar.x().b() == 0) {
                    this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.F.j();
            } else {
                m0 m0Var = this.Q0;
                if (m0Var == null || (pbReplyTitleViewHolder = m0Var.f57473c) == null || pbReplyTitleViewHolder.a() == null) {
                    i5 = 0;
                } else {
                    i5 = this.Q0.f57473c.a().getTop() < 0 ? this.Q0.f57473c.a().getHeight() : this.Q0.f57473c.a().getBottom();
                }
                if (this.f57426c.i5()) {
                    this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i5);
                } else {
                    this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i5);
                }
                if (this.f57426c.N4() != null && !this.f57426c.N4().p()) {
                    this.f57426c.N4().x();
                }
            }
            if (eVar.x().b() == 0 || E == null) {
                f2();
            }
        }
        if (i2 == 2) {
            this.l.setSelection(i3 > 1 ? (i3 + ((this.l.getData() == null && eVar.E() == null) ? 0 : (this.l.getData().size() - eVar.E().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i2 != 3) {
            if (i2 == 4) {
                this.N1 = false;
            } else if (i2 == 5) {
                this.l.setSelection(0);
            } else if (i2 != 6) {
                if (i2 == 8) {
                    if (i3 == 0) {
                        d.a.p0.h2.k.e.a1.f fVar = this.p;
                        if (fVar != null && fVar.c() != null) {
                            if (this.f57426c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.z.B() + this.l.getHeaderViewsCount()) - 1, this.p.d() - d.a.c.e.p.l.r(this.f57426c.getPageContext().getPageActivity()));
                            } else {
                                this.l.setSelectionFromTop((this.z.B() + this.l.getHeaderViewsCount()) - 1, this.p.d());
                            }
                        } else {
                            this.l.setSelection(this.z.B() + this.l.getHeaderViewsCount());
                        }
                    } else if (ListUtils.isEmpty(eVar.Q())) {
                        this.l.setSelection(i3 > 0 ? i3 + ((this.l.getData() == null && eVar.E() == null) ? 0 : (this.l.getData().size() - eVar.E().size()) + this.l.getHeaderViewsCount()) : 0);
                    } else {
                        this.l.setSelection(eVar.E().size() + this.l.getHeaderViewsCount());
                    }
                    this.F.f();
                    this.F.A(this.f57426c.getString(R.string.pb_load_more_without_point));
                    this.F.v();
                }
            } else if (i4 == 1 && (e4 = d.a.p0.h2.k.e.m0.b().e()) != null && !(e4 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e4);
            } else {
                this.l.setSelection(0);
            }
        } else if (i4 == 1 && (e3 = d.a.p0.h2.k.e.m0.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
            this.l.post(new y(this, e3, E, eVar));
        }
        if (this.S0 == X1 && v1()) {
            X();
        }
        if (this.Y0) {
            a2();
            this.Y0 = false;
            if (i4 == 0) {
                A2(true);
            }
        }
        if (eVar.f56896d == 1 || eVar.f56897e == 1) {
            if (this.e1 == null) {
                this.e1 = new PbTopTipView(this.f57426c.getContext());
            }
            if (eVar.f56897e == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.f57426c.S4())) {
                this.e1.setText(this.f57426c.getString(R.string.pb_read_strategy_add_experience));
                this.e1.l(this.f57427d, this.D0);
            } else if (eVar.f56896d == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.f57426c.S4())) {
                this.e1.setText(this.f57426c.getString(R.string.pb_read_news_add_experience));
                this.e1.l(this.f57427d, this.D0);
            }
        }
        this.l.removeFooterView(this.x1.a());
        if (!ListUtils.isEmpty(eVar.H()) && eVar.x().b() == 0) {
            this.l.removeFooterView(this.N0);
            this.x1.d(Math.max(this.m0.getMeasuredHeight(), this.x0 / 2));
            this.l.addFooterView(this.x1.a());
            this.x1.f(eVar);
        }
        b2(eVar);
        if (eVar.c0() && this.f57426c.P4() != null) {
            this.f57426c.P4().d();
        }
        if (eVar.g() != 3) {
            l1(eVar);
        }
        this.p0.setText(TbSingleton.getInstance().getAdVertiComment(eVar.g0(), eVar.h0(), N0()));
    }

    public void j0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048706, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public void j1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048707, this) == null) || this.f57426c == null || (editorTools = this.g0) == null) {
            return;
        }
        editorTools.j();
        if (this.f57426c.M4() != null) {
            this.f57426c.M4().P();
        }
        X0();
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            h2();
            Z0();
            this.W0.c();
            Y2(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void j3(d.a.p0.h2.h.e eVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048709, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || eVar == null || eVar.N() == null) {
            return;
        }
        if (this.f57426c.isSimpleForum()) {
            if (eVar.h() != null) {
                this.c0 = eVar.h().g();
                this.d0 = eVar.h().h();
            }
            if (this.c0 == null && this.f57426c.y() != null && this.f57426c.y().f0() != null) {
                this.c0 = this.f57426c.y().f0();
            }
        }
        PostData t0 = t0(eVar, z2);
        J2(t0, eVar);
        this.s.x(8);
        if (eVar.l0()) {
            this.a1 = true;
            this.f57431h.s(true);
            this.f57431h.f57313a.hideBottomLine();
            if (this.p == null) {
                this.p = new d.a.p0.h2.k.e.a1.f(this.f57426c);
            }
            this.p.w(eVar, t0, this.l, this.s, this.H0, this.f57431h, this.c0, this.s1);
            this.p.t(this.O1);
            k2();
        } else {
            this.a1 = false;
            this.f57431h.s(false);
            d.a.p0.h2.k.e.a1.f fVar = this.p;
            if (fVar != null) {
                fVar.p(this.l);
            }
        }
        if (this.f57426c.N4() != null) {
            this.f57426c.N4().w(this.a1);
        }
        if (t0 == null) {
            return;
        }
        this.B0 = t0;
        this.s.x(0);
        SparseArray<Object> n2 = this.s.n();
        n2.put(R.id.tag_clip_board, t0);
        n2.put(R.id.tag_is_subpb, Boolean.FALSE);
        this.t.e(eVar, this.l);
        this.r.f(eVar);
        this.q.h(eVar, this.z0);
        this.q.g(eVar);
        this.s.y(this.D0, this.A0, t0, this.O1);
        if (this.M0 != null) {
            if (eVar.e0()) {
                this.M0.a().setVisibility(8);
            } else {
                this.M0.a().setVisibility(0);
                d.a.p0.h2.h.o oVar = new d.a.p0.h2.h.o(d.a.p0.h2.h.o.l);
                if (eVar.N() != null) {
                    eVar.N().P0();
                }
                oVar.f56932g = eVar.f56899g;
                eVar.c();
                oVar.f56933h = this.f57426c.i5();
                oVar.k = eVar.f56898f;
                this.M0.h(oVar);
            }
        }
        s3(eVar);
        d.a.c.e.m.e.a().post(new w(this));
        this.u.e(this.l);
        if (t0.S) {
            this.u.f(t0.E());
            this.u.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        d.a.p0.h2.k.e.i iVar = this.z;
        if (iVar != null && iVar.z() != null) {
            this.z.z().s0(t0.S);
        }
        d.a.p0.h2.k.e.i iVar2 = this.z;
        if (iVar2 != null) {
            iVar2.j0(t0.S);
        }
        this.y1.setVisibility(t0.S ? 0 : 8);
    }

    public final String k0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048710, this, i2)) == null) {
            if (i2 == 0) {
                return this.f57426c.getString(R.string.pb_comment_red_dot_no_reply);
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (i2 > 9990000) {
                return "· · ·";
            }
            if (i2 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(i2 / 10000.0f) + "W";
            } else if (i2 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(i2 / 10000.0f) + "W";
            } else {
                return "" + i2;
            }
        }
        return (String) invokeI.objValue;
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048711, this) == null) || this.C1 == null) {
            return;
        }
        e1();
        if (this.C1.n()) {
            String a3 = this.B1.a(this.A0.g0());
            if (StringUtils.isNull(a3)) {
                return;
            }
            this.C1.setData(a3);
            TiebaStatic.log(new StatisticItem("c14128").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2));
            this.C1.setLogoListener(new g0(this, this.B1.b(this.A0.g0())));
            this.C1.setFeedBackListener(new h0(this));
        }
    }

    public final void k2() {
        d.a.p0.h2.k.e.a1.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048712, this) == null) || (fVar = this.p) == null) {
            return;
        }
        fVar.q(this.l, this.I0, this.C0);
    }

    public void k3(b.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048713, this, cVar, z2) == null) {
            d.a.o0.r.s.j jVar = this.Y;
            if (jVar != null) {
                jVar.dismiss();
                this.Y = null;
            }
            d.a.o0.r.s.l lVar = new d.a.o0.r.s.l(this.f57426c.getContext());
            ArrayList arrayList = new ArrayList();
            d.a.p0.h2.h.e eVar = this.A0;
            if (eVar != null && eVar.N() != null && !this.A0.N().I1()) {
                arrayList.add(new d.a.o0.r.s.h(0, this.f57426c.getPageContext().getString(R.string.save_to_emotion), lVar));
            }
            if (!z2) {
                arrayList.add(new d.a.o0.r.s.h(1, this.f57426c.getPageContext().getString(R.string.save_to_local), lVar));
            }
            lVar.k(arrayList);
            lVar.n(new u(this, cVar));
            d.a.o0.r.s.j jVar2 = new d.a.o0.r.s.j(this.f57426c.getPageContext(), lVar);
            this.Y = jVar2;
            jVar2.l();
        }
    }

    public d.a.p0.h2.k.e.i l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? this.z : (d.a.p0.h2.k.e.i) invokeV.objValue;
    }

    public void l1(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, eVar) == null) {
            this.B1.e(eVar.k() == null ? null : eVar.k().pbpage);
            this.B1.d(TbSingleton.getInstance().getAdFloatViewData());
            if (this.B1.c(eVar.g0())) {
                k1();
            }
        }
    }

    public void l2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048716, this) == null) || (handler = this.J1) == null) {
            return;
        }
        Runnable runnable = this.K1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        g gVar = new g(this);
        this.K1 = gVar;
        this.J1.postDelayed(gVar, 2000L);
    }

    public void l3(b.c cVar, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048717, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            d.a.o0.r.s.j jVar = this.X;
            if (jVar != null) {
                jVar.dismiss();
                this.X = null;
            }
            d.a.o0.r.s.l lVar = new d.a.o0.r.s.l(this.f57426c.getContext());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new d.a.o0.r.s.h(0, this.f57426c.getPageContext().getString(R.string.copy), lVar));
            if (z3) {
                arrayList.add(new d.a.o0.r.s.h(1, this.f57426c.getPageContext().getString(R.string.report_text), lVar));
            } else if (!z2) {
                arrayList.add(new d.a.o0.r.s.h(1, this.f57426c.getPageContext().getString(R.string.mark), lVar));
            } else {
                arrayList.add(new d.a.o0.r.s.h(1, this.f57426c.getPageContext().getString(R.string.remove_mark), lVar));
            }
            lVar.k(arrayList);
            lVar.n(new t(this, cVar));
            d.a.o0.r.s.j jVar2 = new d.a.o0.r.s.j(this.f57426c.getPageContext(), lVar);
            this.Y = jVar2;
            jVar2.l();
        }
    }

    public LinearLayout m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) ? this.n0 : (LinearLayout) invokeV.objValue;
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048719, this) == null) && this.t == null) {
            this.t = new d.a.p0.h2.k.e.a1.b(this.f57426c, this.J);
        }
    }

    public void m2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, editorTools) == null) {
            this.g0 = editorTools;
            editorTools.setOnCancelClickListener(new k(this));
            this.g0.setId(R.id.pb_editor);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.g0.getParent() == null) {
                this.f57427d.addView(this.g0, layoutParams);
            }
            this.g0.w(TbadkCoreApplication.getInst().getSkinType());
            this.g0.setActionListener(24, new l(this));
            Z0();
            this.f57426c.M4().i(new m(this));
        }
    }

    public void m3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, onItemClickListener) == null) {
            d.a.o0.r.s.e eVar = this.Z;
            if (eVar != null) {
                eVar.d();
                this.Z = null;
            }
            if (this.A0 == null) {
                return;
            }
            ArrayList<d.a.o0.r.s.n> arrayList = new ArrayList<>();
            arrayList.add(new d.a.o0.r.s.n(this.f57426c.getContext().getString(R.string.all_person), "", this.A0.K() == 1, Integer.toString(1)));
            arrayList.add(new d.a.o0.r.s.n(this.f57426c.getContext().getString(R.string.my_fans), "", this.A0.K() == 2, Integer.toString(5)));
            arrayList.add(new d.a.o0.r.s.n(this.f57426c.getContext().getString(R.string.my_attentions), "", this.A0.K() == 3, Integer.toString(6)));
            arrayList.add(new d.a.o0.r.s.n(this.f57426c.getContext().getString(R.string.myself_only), "", this.A0.K() == 4, Integer.toString(7)));
            d.a.o0.r.s.e eVar2 = new d.a.o0.r.s.e(this.f57426c.getPageContext());
            eVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.Z = eVar2;
            eVar2.k(arrayList, onItemClickListener);
            eVar2.c();
            this.Z.n();
        }
    }

    public View n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            View view = this.R;
            if (view != null) {
                return view.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void n1(d.a.p0.h2.h.e eVar) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, eVar) == null) {
            int i2 = 0;
            this.z.a0(eVar, false);
            this.z.V();
            d0();
            d.a.p0.h2.k.d.a aVar = this.j1;
            if (aVar != null) {
                aVar.n();
            }
            ArrayList<PostData> E = eVar.E();
            if (eVar.x().b() == 0 || E == null || E.size() < eVar.x().e()) {
                if (ListUtils.getCount(E) != 0 && (ListUtils.getCount(E) != 1 || E.get(0) == null || E.get(0).A() != 1)) {
                    if (eVar.x().b() == 0) {
                        this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.F.j();
                } else {
                    m0 m0Var = this.Q0;
                    if (m0Var != null && (pbReplyTitleViewHolder = m0Var.f57473c) != null && pbReplyTitleViewHolder.a() != null) {
                        i2 = this.Q0.f57473c.a().getTop() < 0 ? this.Q0.f57473c.a().getHeight() : this.Q0.f57473c.a().getBottom();
                    }
                    if (this.f57426c.i5()) {
                        this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i2);
                    } else {
                        this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i2);
                    }
                }
            }
            b2(eVar);
        }
    }

    public void n2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048724, this, str) == null) || (pbListView = this.F) == null) {
            return;
        }
        pbListView.A(str);
    }

    public void n3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048725, this) == null) || !TbadkCoreApplication.isLogin() || this.A0 == null || !this.b1 || this.a1 || this.b0 || (postData = this.B0) == null || postData.t() == null || this.B0.t().getIsLike() || this.B0.t().hadConcerned() || this.X0 != null) {
            return;
        }
        this.X0 = new o0(this.f57426c);
    }

    public String o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? this.P1 : invokeV.booleanValue;
    }

    public void o2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048728, this, str) == null) || this.F == null) {
            return;
        }
        int i2 = 0;
        m0 m0Var = this.Q0;
        if (m0Var != null && (pbReplyTitleViewHolder = m0Var.f57473c) != null && pbReplyTitleViewHolder.a() != null) {
            i2 = this.Q0.f57473c.a().getTop() < 0 ? this.Q0.f57473c.a().getHeight() : this.Q0.f57473c.a().getBottom();
        }
        this.F.D(str, i2);
    }

    public final void o3(d.a.o0.r.s.a aVar, int i2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048729, this, aVar, i2) == null) || (pbFragment = this.f57426c) == null || aVar == null) {
            return;
        }
        if (this.o1 == null && this.q != null) {
            this.o1 = new d.a.p0.h.g(pbFragment.getPageContext(), this.q.c());
        }
        AntiData s4 = this.f57426c.s4();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (s4 != null && s4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = s4.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        d.a.o0.r.q.w0 w0Var = new d.a.o0.r.q.w0();
        w0Var.j(sparseArray);
        this.o1.x(new String[]{this.f57426c.getString(R.string.delete_thread_reason_1), this.f57426c.getString(R.string.delete_thread_reason_2), this.f57426c.getString(R.string.delete_thread_reason_3), this.f57426c.getString(R.string.delete_thread_reason_4), this.f57426c.getString(R.string.delete_thread_reason_5)});
        this.o1.w(w0Var);
        this.o1.z((i2 == 1 || i2 == 2) ? "4" : "3");
        this.o1.y(new p(this, aVar));
    }

    public int p0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return 0;
            }
            int firstVisiblePosition = pbLandscapeListView.getFirstVisiblePosition();
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (lastVisiblePosition > firstVisiblePosition) {
                int i2 = (lastVisiblePosition - firstVisiblePosition) + 1;
                int[] iArr = new int[i2];
                Rect rect = new Rect();
                int childCount = this.l.getChildCount();
                int i3 = 0;
                for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                    int i5 = i4 - firstVisiblePosition;
                    if (i5 < childCount && (childAt = this.l.getChildAt(i5)) != null) {
                        childAt.getGlobalVisibleRect(rect);
                        iArr[i5] = rect.height();
                    }
                    i3 += iArr[i5];
                }
                int i6 = i3 / 2;
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    if (i7 >= i2) {
                        break;
                    }
                    i8 += iArr[i7];
                    if (i8 > i6) {
                        firstVisiblePosition += i7;
                        break;
                    }
                    i7++;
                }
            }
            if (firstVisiblePosition < 0) {
                return 0;
            }
            return firstVisiblePosition;
        }
        return invokeV.intValue;
    }

    public boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? this.w0 : invokeV.booleanValue;
    }

    public void p2(PbFragment.s2 s2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, s2Var) == null) {
            this.M1 = s2Var;
        }
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            this.I.setVisibility(0);
        }
    }

    public PostData q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int p0 = p0() - this.l.getHeaderViewsCount();
            int i2 = 0;
            if (p0 < 0) {
                p0 = 0;
            }
            if (this.z.y(p0) != null && this.z.y(p0) != PostData.t0) {
                i2 = p0 + 1;
            }
            if (this.z.x(i2) instanceof PostData) {
                return (PostData) this.z.x(i2);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public final boolean q1(d.a.p0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048735, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null) {
                return false;
            }
            SpannableStringBuilder b1 = eVar.N().b1();
            if (b1 != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(b1.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void q2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z2) == null) {
            this.h0 = z2;
        }
    }

    public void q3(a1 a1Var, a.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048737, this, a1Var, eVar) == null) || a1Var == null) {
            return;
        }
        int a3 = a1Var.a();
        int h2 = a1Var.h();
        d.a.o0.r.s.a aVar = this.A;
        if (aVar != null) {
            aVar.show();
        } else {
            this.A = new d.a.o0.r.s.a(this.f57426c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f57426c.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
            this.C = inflate;
            this.A.setContentView(inflate);
            this.A.setPositiveButton(R.string.dialog_ok, eVar);
            this.A.setNegativeButton(R.string.dialog_cancel, new a0(this));
            this.A.setOnCalcelListener(new b0(this));
            this.A.create(this.f57426c.getPageContext()).show();
        }
        EditText editText = (EditText) this.C.findViewById(R.id.input_page_number);
        this.D = editText;
        editText.setText("");
        TextView textView = (TextView) this.C.findViewById(R.id.current_page_number);
        if (a3 <= 0) {
            a3 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a3), Integer.valueOf(h2)));
        this.f57426c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.D, 150);
    }

    public FallingView r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) ? this.z1 : (FallingView) invokeV.objValue;
    }

    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public void r2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048740, this, z2) == null) {
            this.z.b0(z2);
        }
    }

    public void r3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048741, this, z2) == null) || this.l == null || (textView = this.I0) == null || this.f57428e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f57428e.setVisibility(0);
            } else {
                this.f57428e.setVisibility(8);
                this.l.removeHeaderView(this.I0);
                this.l.setTextViewAdded(false);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.I0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = W1;
                this.I0.setLayoutParams(layoutParams);
            }
            k2();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + E0(true);
            this.I0.setLayoutParams(layoutParams2);
        }
        k2();
        e2();
    }

    public int s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? u0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            EditorTools editorTools = this.g0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void s2(boolean z2) {
        d.a.p0.h2.k.e.a1.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048744, this, z2) == null) || (fVar = this.p) == null) {
            return;
        }
        fVar.r(z2);
    }

    public final void s3(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048745, this, eVar) == null) || eVar == null || eVar.N() == null || eVar.N().q2()) {
            return;
        }
        boolean z2 = eVar.N().l0() == 1;
        boolean z3 = eVar.N().m0() == 1;
        d.a.p0.h2.k.e.a1.e eVar2 = this.s;
        if (eVar2 != null) {
            eVar2.i(eVar, z2, z3);
        }
        d.a.p0.h2.k.e.i iVar = this.z;
        if (iVar == null || iVar.t() == null) {
            return;
        }
        this.z.t().d(eVar, z2, z3);
    }

    public PostData t0(d.a.p0.h2.h.e eVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048746, this, eVar, z2)) == null) {
            PostData postData = null;
            if (eVar == null) {
                return null;
            }
            if (eVar.V() != null) {
                return eVar.V();
            }
            if (!ListUtils.isEmpty(eVar.E())) {
                Iterator<PostData> it = eVar.E().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        postData = next;
                        break;
                    }
                }
            }
            if (postData == null) {
                postData = eVar.j();
            }
            if (!t1(postData)) {
                postData = M0(eVar);
            }
            if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
                postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public final boolean t1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048747, this, postData)) == null) {
            if (postData == null || postData.t() == null) {
                return false;
            }
            MetaData t2 = postData.t();
            return (TextUtils.isEmpty(t2.getUserId()) && TextUtils.isEmpty(t2.getAvater())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void t2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048748, this, z2) == null) {
            this.t1 = z2;
        }
    }

    @SuppressLint({"CutPasteId"})
    public void t3(d.a.p0.h2.h.e eVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048749, this, eVar, z2) == null) || eVar == null) {
            return;
        }
        D3(eVar, z2);
        d0();
    }

    public final int u0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048750, this, i2)) == null) {
            d.a.c.k.e.e adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0) {
                adapter2.getItem(i2);
            }
            int o2 = (adapter2.o() + adapter2.m()) - 1;
            if (i2 > o2) {
                i2 = o2;
            }
            int n2 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof d.a.c.k.e.e)) ? 0 : this.l.getAdapter2().n();
            if (i2 > n2) {
                return i2 - n2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void u2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048752, this, z2) == null) {
            this.l1 = z2;
        }
    }

    public void u3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, str) == null) {
            this.f57426c.showToast(str);
        }
    }

    public Button v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) ? this.k0 : (Button) invokeV.objValue;
    }

    public final boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) ? TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.Q1) : invokeV.booleanValue;
    }

    public void v2(boolean z2) {
        d.a.p0.h2.k.e.a1.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048756, this, z2) == null) || (fVar = this.p) == null) {
            return;
        }
        fVar.s(z2);
    }

    public void v3(final d.a.o0.t.a aVar, Bitmap bitmap, final int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048757, this, aVar, bitmap, i2) == null) {
            final Random random = new Random();
            c.b bVar = new c.b(bitmap);
            bVar.p(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.o(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.m(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.n(new c.InterfaceC1445c() { // from class: d.a.p0.h2.k.e.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // d.a.p0.h2.p.c.InterfaceC1445c
                public final float a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? t0.D1(random) : invokeV.floatValue;
                }
            });
            bVar.q(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40), true, true);
            d.a.p0.h2.p.c l2 = bVar.l();
            this.z1.f();
            this.z1.a(l2, 19);
            d.a.c.e.m.e.a().postDelayed(this.H1, 2000L);
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TbImageView tbImageView = this.A1;
            if (tbImageView != null) {
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: d.a.p0.h2.k.e.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            t0.this.E1(aVar, i2, view);
                        }
                    }
                });
            }
        }
    }

    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) ? this.l.getHeaderViewsCount() : invokeV.intValue;
    }

    public final boolean w1(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048759, this, b2Var)) == null) {
            if (b2Var == null || b2Var.H() == null) {
                return false;
            }
            PostData t0 = t0(this.A0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (t0 == null || t0.t() == null) ? "" : t0.t().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void w2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048760, this, z2) == null) {
            this.z.d0(z2);
        }
    }

    public void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048761, this) == null) {
            this.f57426c.showProgressBar();
        }
    }

    public TextView x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) ? this.s.k() : (TextView) invokeV.objValue;
    }

    public boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) {
            View view = this.N0;
            if (view == null || view.getParent() == null || this.F.l()) {
                return false;
            }
            int bottom = this.N0.getBottom();
            Rect rect = new Rect();
            this.N0.getWindowVisibleDisplayFrame(rect);
            return bottom > 0 && bottom <= rect.bottom;
        }
        return invokeV.booleanValue;
    }

    public void x2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048764, this, z2) == null) {
            this.z.i0(z2);
        }
    }

    public void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048765, this) == null) {
            FallingView fallingView = this.z1;
            if (fallingView != null) {
                fallingView.g();
            }
            if (this.A1 != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.H1);
                this.A1.setVisibility(8);
            }
        }
    }

    public PbInterviewStatusView y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048766, this)) == null) ? this.G0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            d.a.p0.h2.h.e eVar = this.A0;
            return eVar == null || eVar.m() == null || "0".equals(this.A0.m().getId()) || "me0407".equals(this.A0.m().getName());
        }
        return invokeV.booleanValue;
    }

    public void y2(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048768, this, gVar) == null) {
            this.R1 = gVar;
            d.a.p0.h2.p.i iVar = this.E;
            if (iVar != null) {
                iVar.a(gVar);
            }
        }
    }

    public void y3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048769, this) == null) || this.S1 == null) {
            return;
        }
        while (this.S1.size() > 0) {
            TbImageView remove = this.S1.remove(0);
            if (remove != null) {
                remove.Q();
            }
        }
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) ? this.l1 : invokeV.booleanValue;
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            d.a.p0.h2.k.e.a1.f fVar = this.p;
            return fVar != null && fVar.f();
        }
        return invokeV.booleanValue;
    }

    public void z2(String str) {
        d.a.p0.h2.k.e.g1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048772, this, str) == null) || (bVar = this.f57432i) == null) {
            return;
        }
        bVar.b(str);
    }

    public void z3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048773, this, z2) == null) {
            this.a0 = z2;
        }
    }
}
