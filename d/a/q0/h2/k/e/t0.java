package d.a.q0.h2.k.e;

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
import com.baidu.tieba.pb.pb.main.PbModel;
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
import d.a.p0.s.f0.f;
import d.a.p0.s.q.a1;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.x1;
import d.a.p0.s.s.a;
import d.a.p0.s.s.b;
import d.a.p0.s.s.l;
import d.a.q0.h.g;
import d.a.q0.h.j;
import d.a.q0.h2.i.a;
import d.a.q0.h2.p.c;
import d.a.q0.h3.g0.a;
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
    public d.a.p0.s.s.a A;
    public d.a.q0.h2.h.e A0;
    public final TbImageView A1;
    public d.a.p0.s.s.b B;
    public PostData B0;
    public final d.a.q0.h2.o.j.a B1;
    public View C;
    public int C0;
    public RightFloatLayerView C1;
    public EditText D;
    public int D0;
    public final CustomMessageListener D1;
    public d.a.q0.h2.p.i E;
    public boolean E0;
    public boolean E1;
    public PbListView F;
    public ViewStub F0;
    public String F1;
    public d.a.q0.h2.p.e G;
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
    public TbRichTextView.z K;
    public View K0;
    public Runnable K1;
    public NoNetworkView.b L;
    public View L0;
    public CustomMessageListener L1;
    public d.a.p0.s.s.j M;
    public PbReplyTitleViewHolder M0;
    public PbFragment.t2 M1;
    public View.OnClickListener N;
    public View N0;
    public boolean N1;
    public d.a.p0.s.s.a O;
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
    public d.a.q0.h2.k.e.u W0;
    public d.a.p0.s.s.j X;
    public o0 X0;
    public d.a.p0.s.s.j Y;
    public boolean Y0;
    public d.a.p0.s.s.e Z;
    public int Z0;

    /* renamed from: a  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f58009a;
    public boolean a0;
    public boolean a1;

    /* renamed from: b  reason: collision with root package name */
    public int f58010b;
    public boolean b0;
    public boolean b1;

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f58011c;
    public String c0;
    public boolean c1;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f58012d;
    public String d0;
    public int d1;

    /* renamed from: e  reason: collision with root package name */
    public View f58013e;
    public d.a.q0.h2.i.c e0;
    public PbTopTipView e1;

    /* renamed from: f  reason: collision with root package name */
    public int f58014f;
    public ScrollView f0;
    public PopupWindow f1;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f58015g;
    public EditorTools g0;
    public TextView g1;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.q0.h2.k.e.h1.c f58016h;
    public boolean h0;
    public List<String> h1;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.h2.k.e.h1.b f58017i;
    public View i0;
    public d.a.q0.h2.k.e.c1.c i1;
    public ViewStub j;
    public View j0;
    public d.a.q0.h2.k.d.a j1;
    public ViewStub k;
    public Button k0;
    public PbLandscapeListView.c k1;
    public PbLandscapeListView l;
    public View l0;
    public boolean l1;
    public NoNetworkView m;
    public View m0;
    public d.a.q0.h2.k.e.h0 m1;
    public List<CustomBlueCheckRadioButton> n;
    public LinearLayout n0;
    public NavigationBarCoverTip n1;
    public PbThreadPostView o;
    public HeadImageView o0;
    public d.a.q0.h.g o1;
    public d.a.q0.h2.k.e.b1.g p;
    public TextView p0;
    public d.a.q0.h.j p1;
    public d.a.q0.h2.k.e.b1.b q;
    public ImageView q0;
    public String q1;
    public d.a.q0.h2.k.e.b1.d r;
    public ImageView r0;
    public PermissionJudgePolicy r1;
    public d.a.q0.h2.k.e.b1.f s;
    public ImageView s0;
    public long s1;
    public d.a.q0.h2.k.e.b1.c t;
    public d.a.q0.h2.p.h t0;
    public boolean t1;
    public d.a.q0.h2.k.e.b1.e u;
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
    public d.a.q0.h2.p.g x1;
    public ObservedChangeRelativeLayout y;
    public d.a.p0.s.f0.a y0;
    public MaskView y1;
    public d.a.q0.h2.k.e.i z;
    public boolean z0;
    public final FallingView z1;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f58018e;

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
            this.f58018e = t0Var;
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
                    this.f58018e.f58011c.g4(sparseArray);
                    return;
                }
                this.f58018e.W1(view);
            } else if (booleanValue2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.f58018e.f58011c.g4(sparseArray);
            } else if (booleanValue3) {
                this.f58018e.S1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f58019e;

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
            this.f58019e = t0Var;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f58019e.a0();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f58020e;

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
            this.f58020e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58020e.j2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f58021e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b0 f58022e;

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
                this.f58022e = b0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f58022e.f58021e.f58011c.HidenSoftKeyPad((InputMethodManager) this.f58022e.f58021e.f58011c.getBaseFragmentActivity().getSystemService("input_method"), this.f58022e.f58021e.f58012d);
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
            this.f58021e = t0Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f58021e.U0 == null) {
                    this.f58021e.U0 = new a(this);
                }
                d.a.d.e.m.e.a().postDelayed(this.f58021e.U0, 150L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f58023a;

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
            this.f58023a = t0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f58023a.V0.M(postData);
                this.f58023a.z.V();
                this.f58023a.W0.c();
                this.f58023a.g0.q();
                this.f58023a.Z2(false);
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

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
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
        public final /* synthetic */ d.a.p0.u.a f58024a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f58025b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ t0 f58026c;

        public d(t0 t0Var, d.a.p0.u.a aVar, int i2) {
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
            this.f58026c = t0Var;
            this.f58024a = aVar;
            this.f58025b = i2;
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
                this.f58026c.w3(this.f58024a, bitmap, this.f58025b);
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

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
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
        public final /* synthetic */ t0 f58027e;

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
            this.f58027e = t0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58027e.A1 == null) {
                return;
            }
            d.a.q0.h2.p.d.b(this.f58027e.A1);
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

        @Override // d.a.q0.h3.g0.a.f
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
        public final /* synthetic */ t0 f58028a;

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
            this.f58028a = t0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.f58028a.z == null) {
                return;
            }
            this.f58028a.z.V();
        }
    }

    /* loaded from: classes8.dex */
    public class f0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f58029e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58030f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f58031g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View f58032h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ t0 f58033i;

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
            this.f58033i = t0Var;
            this.f58029e = i2;
            this.f58030f = i3;
            this.f58031g = i4;
            this.f58032h = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f58029e;
                if (i2 == this.f58030f || i2 - this.f58031g >= 0) {
                    this.f58033i.f1.showAsDropDown(this.f58033i.m0, this.f58032h.getLeft(), -this.f58033i.m0.getHeight());
                } else {
                    this.f58033i.f1.showAsDropDown(this.f58032h);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f58034e;

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
            this.f58034e = t0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f58034e.v == null) {
                    this.f58034e.i1();
                }
                this.f58034e.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f58035e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f58036f;

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
            this.f58036f = t0Var;
            this.f58035e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58036f.C1.k();
                if (!StringUtils.isNull(this.f58035e)) {
                    this.f58036f.C1(this.f58035e);
                }
                this.f58036f.e1();
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
        public final /* synthetic */ t0 f58037a;

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
            this.f58037a = t0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f58037a.w0 = false;
        }
    }

    /* loaded from: classes8.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f58038e;

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
            this.f58038e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58038e.C1.k();
                this.f58038e.e1();
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
        public final /* synthetic */ t0 f58039a;

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
            this.f58039a = t0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921552) {
                this.f58039a.e1();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f58040a;

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
            this.f58040a = t0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.f58040a.F1 = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f58041a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f58042b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f58043c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f58044d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f58045e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58046f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ t0 f58047g;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f58048e;

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
                this.f58048e = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58048e.f58047g.N0 == null || this.f58048e.f58047g.N0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.f58048e.f58047g.N0.getLayoutParams();
                layoutParams.height = this.f58048e.f58047g.T0;
                this.f58048e.f58047g.N0.setLayoutParams(layoutParams);
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
            this.f58047g = t0Var;
            this.f58041a = i2;
            this.f58042b = pbReplyTitleViewHolder;
            this.f58043c = z;
            this.f58044d = i3;
            this.f58045e = i4;
            this.f58046f = i5;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = this.f58041a;
                if (i3 >= 0 && i3 <= this.f58047g.f58012d.getMeasuredHeight()) {
                    int O0 = this.f58047g.O0(this.f58042b);
                    int i4 = this.f58041a;
                    int i5 = O0 - i4;
                    if (this.f58043c && i5 != 0 && i4 <= (i2 = this.f58044d)) {
                        i5 = O0 - i2;
                    }
                    if (this.f58047g.N0 == null || (layoutParams = this.f58047g.N0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i5 == 0 || i5 > this.f58047g.f58012d.getMeasuredHeight() || O0 >= this.f58047g.f58012d.getMeasuredHeight()) {
                        layoutParams.height = this.f58047g.T0;
                    } else {
                        if (layoutParams != null) {
                            int i6 = layoutParams.height;
                            if (i6 + i5 > 0 && i6 + i5 <= this.f58047g.f58012d.getMeasuredHeight()) {
                                layoutParams.height += i5;
                                this.f58047g.l.setSelectionFromTop(this.f58045e, this.f58046f);
                            }
                        }
                        layoutParams.height = this.f58047g.T0;
                    }
                    this.f58047g.N0.setLayoutParams(layoutParams);
                    d.a.d.e.m.e.a().post(new a(this));
                }
                this.f58047g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f58049e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f58050f;

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
            this.f58050f = t0Var;
            this.f58049e = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58050f.w1 || this.f58049e == null || this.f58050f.f58011c.y() == null || !this.f58050f.f58011c.y().l1()) {
                return;
            }
            this.f58050f.w1 = true;
            this.f58049e.d4(false);
        }
    }

    /* loaded from: classes8.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f58051e;

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
            this.f58051e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58051e.j2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k0 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f58052a;

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
            this.f58052a = t0Var;
        }

        @Override // d.a.q0.h2.i.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58052a.f58011c.g5();
            }
        }

        @Override // d.a.q0.h2.i.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f58052a.l == null) {
                return;
            }
            if (this.f58052a.p != null) {
                this.f58052a.p.u();
            }
            this.f58052a.l.setSelection(0);
        }
    }

    /* loaded from: classes8.dex */
    public class l implements d.a.p0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f58053e;

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
            this.f58053e = t0Var;
        }

        @Override // d.a.p0.x.b
        public void onAction(d.a.p0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f54160c;
                if (obj instanceof d.a.p0.t.c.v) {
                    if (((d.a.p0.t.c.v) obj).f() == EmotionGroupType.BIG_EMOTION || ((d.a.p0.t.c.v) aVar.f54160c).f() == EmotionGroupType.USER_COLLECT) {
                        if (this.f58053e.r1 == null) {
                            this.f58053e.r1 = new PermissionJudgePolicy();
                        }
                        this.f58053e.r1.clearRequestPermissionList();
                        this.f58053e.r1.appendRequestPermission(this.f58053e.f58011c.getBaseFragmentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                        if (this.f58053e.r1.startRequestPermission(this.f58053e.f58011c.getBaseFragmentActivity())) {
                            return;
                        }
                        this.f58053e.f58011c.R4().h((d.a.p0.t.c.v) aVar.f54160c);
                        this.f58053e.f58011c.R4().A(false, null);
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
        public final /* synthetic */ t0 f58054e;

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
            this.f58054e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new d.a.p0.s.q.s0(this.f58054e.f58011c.getActivity(), "pb_huitie"))) {
                this.f58054e.f58011c.I5();
                if (this.f58054e.f58011c == null || this.f58054e.f58011c.y() == null || this.f58054e.f58011c.y().L0() == null || this.f58054e.f58011c.y().L0().N() == null || this.f58054e.f58011c.y().L0().N().H() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f58054e.f58011c.y().c1()).param("fid", this.f58054e.f58011c.y().L0().n()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f58054e.f58011c.y().f19512f).param("fid", this.f58054e.f58011c.y().L0().n()).param("obj_locate", 1).param("uid", this.f58054e.f58011c.y().L0().N().H().getUserId()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f58055e;

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
            this.f58055e = t0Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f58055e.f58011c.E0 == null || this.f58055e.f58011c.E0.e() == null) {
                return;
            }
            if (!this.f58055e.f58011c.E0.e().e()) {
                this.f58055e.f58011c.E0.a(false);
            }
            this.f58055e.f58011c.E0.e().l(false);
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f58055e.g0 == null || this.f58055e.g0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2)) {
                return;
            }
            String substring = charSequence.toString().substring(i2, i5);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.f58055e.i1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.f58055e.g0.getId());
                t0 t0Var = this.f58055e;
                t0Var.i1 = new d.a.q0.h2.k.e.c1.c(t0Var.f58011c.getPageContext(), this.f58055e.f58012d, layoutParams);
                if (!ListUtils.isEmpty(this.f58055e.h1)) {
                    this.f58055e.i1.q(this.f58055e.h1);
                }
                this.f58055e.i1.r(this.f58055e.g0);
            }
            this.f58055e.i1.p(substring);
        }
    }

    /* loaded from: classes8.dex */
    public static class m0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f58056a;

        /* renamed from: b  reason: collision with root package name */
        public int f58057b;

        /* renamed from: c  reason: collision with root package name */
        public PbReplyTitleViewHolder f58058c;

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
        public final /* synthetic */ boolean f58059e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f58060f;

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
            this.f58060f = t0Var;
            this.f58059e = z;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(d.a.p0.s.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f58060f.M.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f58060f.S1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f58060f.M1 != null) {
                            this.f58060f.M1.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f58060f.f58011c.d5(this.f58059e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
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

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements g.InterfaceC1404g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f58061a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t0 f58062b;

        public p(t0 t0Var, d.a.p0.s.s.a aVar) {
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
            this.f58062b = t0Var;
            this.f58061a = aVar;
        }

        @Override // d.a.q0.h.g.InterfaceC1404g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f58062b.f58011c.p4(this.f58061a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f58063a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t0 f58064b;

        public q(t0 t0Var, d.a.p0.s.s.a aVar) {
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
            this.f58064b = t0Var;
            this.f58063a = aVar;
        }

        @Override // d.a.q0.h.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f58064b.f58011c.p4(this.f58063a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f58065e;

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
            this.f58065e = t0Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f58065e.W = (String) compoundButton.getTag();
                if (this.f58065e.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f58065e.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f58065e.W != null && !str.equals(this.f58065e.W)) {
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
        public final /* synthetic */ t0 f58066e;

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
            this.f58066e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f58066e.Q instanceof Dialog)) {
                d.a.d.e.m.g.b(this.f58066e.Q, this.f58066e.f58011c.getPageContext());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f58067e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f58068f;

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
            this.f58068f = t0Var;
            this.f58067e = cVar;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(d.a.p0.s.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f58068f.Y.dismiss();
                this.f58067e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f58069e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f58070f;

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
            this.f58070f = t0Var;
            this.f58069e = cVar;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(d.a.p0.s.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f58070f.Y.dismiss();
                this.f58069e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f58071e;

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
            this.f58071e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!(view instanceof HeadImageView) || this.f58071e.A0 == null || this.f58071e.A0.N() == null || this.f58071e.A0.N().H() == null || this.f58071e.A0.N().H().getAlaInfo() == null || this.f58071e.A0.N().H().getAlaInfo().live_status != 1) {
                    if (this.f58071e.a1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.f58071e.a1 && this.f58071e.A0 != null && this.f58071e.A0.N() != null && this.f58071e.A0.N().H() != null && this.f58071e.A0.N().H().isBigV()) {
                        TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                    }
                    if (this.f58071e.f58011c.z() != null) {
                        this.f58071e.f58011c.z().mEvent.f57757b.onClick(view);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c11851");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c13715");
                statisticItem2.param("fid", this.f58071e.A0.n());
                statisticItem2.param("fname", this.f58071e.A0.o());
                statisticItem2.param("obj_param1", this.f58071e.A0.N().H().getAlaInfo().user_info != null ? this.f58071e.A0.N().H().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.f58071e.A0.P());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.f58071e.A0.N().H().getAlaInfo()));
                if (this.f58071e.A0.N().H().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.f58071e.A0.N().H().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.f58071e.A0.N().H().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.f58071e.f58011c.getPageContext(), this.f58071e.A0.N().H().getAlaInfo());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f58072e;

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
            this.f58072e = t0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            t0 t0Var;
            d.a.q0.h2.k.e.h1.c cVar;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58072e.z == null || (cVar = (t0Var = this.f58072e).f58016h) == null || cVar.f57909i == null || t0Var.A0 == null || this.f58072e.A0.N() == null || this.f58072e.A0.N().s2() || this.f58072e.y1() || this.f58072e.A0.m() == null || d.a.d.e.p.k.isEmpty(this.f58072e.A0.m().getName())) {
                return;
            }
            if ((this.f58072e.z.H() == null || !this.f58072e.z.H().isShown()) && (linearLayout = this.f58072e.f58016h.f57909i) != null) {
                linearLayout.setVisibility(0);
                if (this.f58072e.f58011c == null || this.f58072e.f58011c.y() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", this.f58072e.f58011c.y().b1());
                statisticItem.param("fid", this.f58072e.f58011c.y().getForumId());
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
        public final /* synthetic */ String f58073e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f58074f;

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
            this.f58074f = t0Var;
            this.f58073e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (d.a.d.e.p.l.D()) {
                    UrlManager.getInstance().dealOneLink(this.f58074f.f58011c.getPageContext(), new String[]{this.f58073e});
                    this.f58074f.f58011c.finish();
                    return;
                }
                this.f58074f.f58011c.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Parcelable f58075e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f58076f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h2.h.e f58077g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ t0 f58078h;

        public y(t0 t0Var, Parcelable parcelable, ArrayList arrayList, d.a.q0.h2.h.e eVar) {
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
            this.f58078h = t0Var;
            this.f58075e = parcelable;
            this.f58076f = arrayList;
            this.f58077g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58078h.l.onRestoreInstanceState(this.f58075e);
                if (ListUtils.getCount(this.f58076f) <= 1 || this.f58077g.x().b() <= 0) {
                    return;
                }
                this.f58078h.F.f();
                this.f58078h.F.A(this.f58078h.f58011c.getString(R.string.pb_load_more_without_point));
                this.f58078h.F.v();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class z implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f58079a;

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
            this.f58079a = t0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i2, int i3, float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) && this.f58079a.f58011c != null && this.f58079a.f58011c.isAdded()) {
                if (i2 < 0 && f2 > this.f58079a.d1) {
                    this.f58079a.a0();
                    this.f58079a.L1();
                }
                this.f58079a.h0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1844554633, "Ld/a/q0/h2/k/e/t0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1844554633, "Ld/a/q0/h2/k/e/t0;");
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
        d2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        e2 = new e0();
    }

    public t0(PbFragment pbFragment, View.OnClickListener onClickListener, d.a.q0.h2.i.c cVar) {
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
        this.f58011c = null;
        this.f58012d = null;
        this.f58013e = null;
        this.f58014f = 0;
        this.f58015g = new Handler();
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
        this.f58011c = pbFragment;
        this.J = onClickListener;
        this.e0 = cVar;
        this.d1 = d.a.d.e.p.l.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f58011c.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.f58012d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.i0 = this.f58012d.findViewById(R.id.bottom_shadow);
        this.n1 = (NavigationBarCoverTip) this.f58012d.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.f58013e = this.f58012d.findViewById(R.id.statebar_view);
        this.C1 = (RightFloatLayerView) this.f58012d.findViewById(R.id.right_layer_view);
        this.f58011c.registerListener(this.D1);
        this.y = (ObservedChangeRelativeLayout) this.f58012d.findViewById(R.id.title_wrapper);
        this.m = (NoNetworkView) this.f58012d.findViewById(R.id.view_no_network);
        this.l = (PbLandscapeListView) this.f58012d.findViewById(R.id.new_pb_list);
        this.H0 = (FrameLayout) this.f58012d.findViewById(R.id.root_float_header);
        this.I0 = new TextView(this.f58011c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.a.d.e.p.l.g(this.f58011c.getActivity(), R.dimen.ds88));
        this.l.x(this.I0, 0);
        this.l.setTextViewAdded(true);
        this.T0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.N0 = new View(this.f58011c.getPageContext().getPageActivity());
        if (d.a.p0.e1.b.e.d()) {
            this.N0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.N0.setLayoutParams(new AbsListView.LayoutParams(-1, this.T0));
        }
        this.N0.setVisibility(4);
        this.l.addFooterView(this.N0);
        this.l.setOnTouchListener(this.f58011c.w2);
        this.f58009a = new j0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.f58009a);
        this.f58016h = new d.a.q0.h2.k.e.h1.c(pbFragment, this.f58012d);
        if (this.f58011c.J4()) {
            ViewStub viewStub = (ViewStub) this.f58012d.findViewById(R.id.manga_view_stub);
            this.j = viewStub;
            viewStub.setVisibility(0);
            d.a.q0.h2.k.e.h1.b bVar = new d.a.q0.h2.k.e.h1.b(pbFragment);
            this.f58017i = bVar;
            bVar.c();
            this.f58016h.f57901a.setVisibility(8);
            layoutParams.height = d.a.d.e.p.l.g(this.f58011c.getActivity(), R.dimen.ds120);
        }
        this.I0.setLayoutParams(layoutParams);
        this.f58016h.p().setOnTouchListener(new d.a.q0.h2.i.a(new k0(this)));
        this.l0 = this.f58012d.findViewById(R.id.view_comment_top_line);
        this.m0 = this.f58012d.findViewById(R.id.pb_editor_tool_comment);
        d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.x0 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
        HeadImageView headImageView = (HeadImageView) this.f58012d.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.o0 = headImageView;
        headImageView.setVisibility(0);
        this.o0.setIsRound(true);
        this.o0.setBorderWidth(d.a.d.e.p.l.g(this.f58011c.getContext(), R.dimen.L_X01));
        this.o0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.o0.setPlaceHolder(0);
        F1();
        this.p0 = (TextView) this.f58012d.findViewById(R.id.pb_editor_tool_comment_reply_text);
        LinearLayout linearLayout = (LinearLayout) this.f58012d.findViewById(R.id.pb_editer_tool_comment_layout);
        this.n0 = linearLayout;
        linearLayout.setOnClickListener(new l0(this));
        this.q0 = (ImageView) this.f58012d.findViewById(R.id.pb_editor_tool_comment_icon);
        this.y1 = (MaskView) this.f58012d.findViewById(R.id.mask_view);
        this.q0.setOnClickListener(this.J);
        boolean booleanExtra = this.f58011c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.f58012d.findViewById(R.id.pb_editor_tool_collection);
        this.r0 = imageView;
        imageView.setOnClickListener(this.J);
        if (booleanExtra) {
            this.r0.setVisibility(8);
        } else {
            this.r0.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) this.f58012d.findViewById(R.id.pb_editor_tool_share);
        this.s0 = imageView2;
        imageView2.setOnClickListener(this.J);
        d.a.q0.h2.p.h hVar = new d.a.q0.h2.p.h(this.s0);
        this.t0 = hVar;
        hVar.d();
        TextView textView = (TextView) this.f58012d.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.u0 = textView;
        textView.setVisibility(0);
        this.F0 = (ViewStub) this.f58012d.findViewById(R.id.interview_status_stub);
        this.q = new d.a.q0.h2.k.e.b1.b(this.f58011c, cVar);
        this.s = new d.a.q0.h2.k.e.b1.f(this.f58011c, cVar, this.J);
        d.a.q0.h2.k.e.i iVar = new d.a.q0.h2.k.e.i(this.f58011c, this.l);
        this.z = iVar;
        iVar.o0(this.J);
        this.z.q0(this.e0);
        this.z.l0(this.K);
        this.z.n0(this.f58011c.V1);
        a aVar = new a(this);
        this.N = aVar;
        this.z.k0(aVar);
        m1();
        g1();
        d.a.q0.h2.k.e.b1.e eVar = new d.a.q0.h2.k.e.b1.e(this.f58011c);
        this.u = eVar;
        eVar.f57662f = 2;
        this.r.a(this.l);
        this.s.h(this.l);
        this.q.a(this.l);
        PbListView pbListView = new PbListView(this.f58011c.getPageContext().getPageActivity());
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
        this.I = this.f58012d.findViewById(R.id.viewstub_progress);
        this.f58011c.registerListener(this.L1);
        this.V0 = new PbFakeFloorModel(this.f58011c.getPageContext());
        PbModel y2 = this.f58011c.y();
        this.V0.O(y2.E(), y2.A(), y2.B(), y2.z(), y2.F());
        d.a.q0.h2.k.e.u uVar = new d.a.q0.h2.k.e.u(this.f58011c.getPageContext(), this.V0, this.f58012d);
        this.W0 = uVar;
        uVar.k(new b(this));
        this.W0.m(this.f58011c.Z1);
        this.V0.Q(new c(this));
        if (this.f58011c.y() != null && !StringUtils.isNull(this.f58011c.y().O0())) {
            PbFragment pbFragment2 = this.f58011c;
            pbFragment2.showToast(pbFragment2.y().O0());
        }
        this.J0 = this.f58012d.findViewById(R.id.pb_expand_blank_view);
        this.K0 = this.f58012d.findViewById(R.id.bottom_rec_float_title);
        View findViewById2 = this.f58012d.findViewById(R.id.sticky_view);
        this.L0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f58011c.y() != null && this.f58011c.y().y0()) {
            this.J0.setVisibility(0);
            m2(true);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.L0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = W1;
            this.L0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f58011c.getPageContext(), this.f58012d.findViewById(R.id.pb_reply_expand_view));
        this.M0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.q(pbFragment.l0);
        this.M0.f19552g.setVisibility(8);
        this.M0.p(this.J);
        this.M0.o(this.f58011c.V1);
        this.f58011c.registerListener(this.I1);
        this.f58011c.registerListener(this.G1);
        PbFragment pbFragment3 = this.f58011c;
        this.x1 = new d.a.q0.h2.p.g(pbFragment3, pbFragment3.getUniqueId());
        this.z1 = (FallingView) this.f58012d.findViewById(R.id.falling_view);
        TbImageView tbImageView = (TbImageView) this.f58012d.findViewById(R.id.falling_ad_view);
        this.A1 = tbImageView;
        tbImageView.setPlaceHolder(2);
        V();
        i2(false);
        this.j0 = this.f58012d.findViewById(R.id.pb_comment_container);
        U(d.a.p0.e1.b.e.d());
        this.B1 = new d.a.q0.h2.o.j.a();
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

    public void A2(String str) {
        d.a.q0.h2.k.e.h1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (bVar = this.f58017i) == null) {
            return;
        }
        bVar.b(str);
    }

    public void A3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) {
            this.a0 = z2;
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

    public void B2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z2) == null) {
            this.Y0 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.Z0 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void B3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) {
            this.f58016h.I(z2);
            if (z2 && this.E0) {
                this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                this.l.setNextPage(this.F);
                this.f58014f = 2;
            }
            F1();
        }
    }

    public SparseArray<Object> C0(d.a.q0.h2.h.e eVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData t0;
        d.a.p0.s.q.e0 e0Var;
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
                        if (x1Var != null && !StringUtils.isNull(x1Var.g()) && (e0Var = x1Var.f53484g) != null && e0Var.f53305a && !e0Var.f53307c && ((i3 = e0Var.f53306b) == 1 || i3 == 2)) {
                            sb.append(d.a.d.e.p.k.cutString(x1Var.g(), 12));
                            sb.append(this.f58011c.getString(R.string.forum));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f58011c.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public final void C1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f58011c.getPageContext().getPageActivity(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public void C2(PbFragment.u2 u2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, u2Var) == null) {
        }
    }

    public void C3(d.a.q0.h2.h.c cVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || cVar == null) {
            return;
        }
        this.f58016h.J();
        if (!StringUtils.isNull(cVar.f57432b)) {
            this.f58016h.G(cVar.f57432b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
        int d3 = d.a.d.e.m.b.d(cVar.f57431a, 0);
        if (d3 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.self);
        } else if (d3 != 300) {
            string = d3 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.system);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.bawu);
        }
        this.f58011c.showNetRefreshView(this.f58012d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new x(this, cVar.f57433c));
    }

    public d.a.q0.h2.k.d.a D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j1 : (d.a.q0.h2.k.d.a) invokeV.objValue;
    }

    public void D2(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, zVar) == null) {
            this.K = zVar;
            this.z.l0(zVar);
            this.j1.q(this.K);
        }
    }

    public void D3(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            if (eVar != null && AntiHelper.o(eVar.N())) {
                d.a.q0.h2.p.h hVar = this.t0;
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
            d.a.q0.h2.p.h hVar2 = this.t0;
            if (hVar2 == null || !hVar2.e()) {
                ViewGroup.LayoutParams layoutParams2 = this.s0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.s0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final int E0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.G0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public /* synthetic */ void E1(d.a.p0.u.a aVar, int i2, View view) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<BaseFragmentActivity> pageContext = this.f58011c.getPageContext();
        urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + d.a.d.e.p.k.getUrlEncode(aVar.d())});
        TiebaStatic.log(new StatisticItem("c14126").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void E2(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.L = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public boolean E3(d.a.q0.h2.h.e eVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, eVar, z2)) == null) {
            if (eVar == null) {
                return false;
            }
            if (this.r != null) {
                if (eVar.N() != null && eVar.N().k0() == 0 && !eVar.N().s2() && !this.E1) {
                    if (eVar.N() != null) {
                        b2 N = eVar.N();
                        N.L2(true, b3(eVar));
                        N.V3(3);
                        N.Q3("2");
                    }
                    if (eVar.N().F1()) {
                        this.s.t(this.l);
                        this.r.d(this.l);
                        this.r.a(this.l);
                        this.s.h(this.l);
                        this.s.x(this.A0);
                        if (q1(eVar)) {
                            this.r.d(this.l);
                        } else {
                            this.r.e(eVar);
                        }
                    } else {
                        this.s.x(this.A0);
                        if (q1(eVar)) {
                            this.r.d(this.l);
                        } else {
                            this.r.g(eVar);
                        }
                    }
                } else if (eVar.N().k0() == 1) {
                    if (eVar.N() != null) {
                        this.r.d(this.l);
                        this.s.x(this.A0);
                    }
                } else {
                    this.r.d(this.l);
                    this.s.x(this.A0);
                }
            }
            t3(eVar);
            this.z0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
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

    public void F2(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public final void F3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.f58011c.J4()) {
            if (this.f58011c.O4() == -1) {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0110, 1);
            }
            if (this.f58011c.N4() == -1) {
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0110, 1);
            }
        }
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
        u3(this.A0, this.z0);
        d2(this.A0, this.z0, this.C0, i2);
        this.f58011c.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f58011c.getBaseFragmentActivity().getLayoutMode().j(this.f58012d);
        SkinManager.setBackgroundColor(this.f58012d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.i0, R.color.CAM_X0203);
        d.a.q0.h2.k.e.b1.g gVar = this.p;
        if (gVar != null) {
            gVar.h(i2);
        }
        d.a.q0.h2.k.e.b1.c cVar = this.t;
        if (cVar != null) {
            cVar.c(i2);
        }
        d.a.q0.h2.k.e.b1.b bVar = this.q;
        if (bVar != null) {
            bVar.e(i2);
        }
        d.a.q0.h2.k.e.b1.d dVar = this.r;
        if (dVar != null) {
            dVar.c(i2);
        }
        d.a.q0.h2.k.e.b1.f fVar = this.s;
        if (fVar != null) {
            fVar.q(i2);
        }
        d.a.q0.h2.k.e.b1.e eVar = this.u;
        if (eVar != null) {
            eVar.d();
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
            this.f58011c.getBaseFragmentActivity().getLayoutMode().j(this.H);
            SkinManager.setBackgroundResource(this.H, R.drawable.pb_foot_more_trans_selector);
        }
        d.a.p0.s.s.a aVar = this.A;
        if (aVar != null) {
            aVar.autoChangeSkinType(this.f58011c.getPageContext());
        }
        A3(this.a0);
        this.z.V();
        d.a.q0.h2.p.i iVar = this.E;
        if (iVar != null) {
            iVar.I(i2);
        }
        EditorTools editorTools = this.g0;
        if (editorTools != null) {
            editorTools.w(i2);
        }
        d.a.q0.h2.p.e eVar2 = this.G;
        if (eVar2 != null) {
            eVar2.f(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        F3();
        UtilHelper.setStatusBarBackground(this.f58013e, i2);
        UtilHelper.setStatusBarBackground(this.L0, i2);
        if (this.v != null) {
            d.a.p0.u0.a.a(this.f58011c.getPageContext(), this.v);
        }
        d.a.q0.h2.k.e.u uVar = this.W0;
        if (uVar != null) {
            uVar.h(i2);
        }
        d.a.q0.h2.k.e.h1.c cVar2 = this.f58016h;
        if (cVar2 != null) {
            d.a.q0.h2.k.e.b1.g gVar2 = this.p;
            if (gVar2 != null) {
                gVar2.i(i2);
            } else {
                cVar2.v(i2);
            }
        }
        HeadImageView headImageView = this.o0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.n0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.d.e.p.l.g(this.f58011c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        d.a.q0.h2.h.e eVar3 = this.A0;
        if (eVar3 != null && eVar3.s()) {
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.q0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        D3(this.A0);
        SkinManager.setBackgroundColor(this.m0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.l0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.g1, R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.p0, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.v0, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.u0, R.color.CAM_X0107);
        TextView textView = this.u0;
        int g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        int i3 = R.color.CAM_X0207;
        SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3);
        d.a.q0.h2.k.d.a aVar2 = this.j1;
        if (aVar2 != null) {
            aVar2.m(i2);
        }
        PbEmotionBar pbEmotionBar = this.R0;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        d.a.q0.h2.p.h hVar = this.t0;
        if (hVar != null) {
            hVar.f();
        }
        d.a.q0.h2.p.g gVar3 = this.x1;
        if (gVar3 != null) {
            gVar3.c();
        }
        RightFloatLayerView rightFloatLayerView = this.C1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.K0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.K0.findViewById(R.id.tv_title), R.color.CAM_X0105);
    }

    public void G2(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public void G3(d.a.q0.h2.h.e eVar) {
        d.a.q0.h2.k.e.b1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, eVar) == null) || (bVar = this.q) == null) {
            return;
        }
        bVar.h(eVar, this.z0);
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(1048604, this, configuration) == null) || configuration == null) {
            return;
        }
        a0();
        if (configuration.orientation == 2) {
            X0();
            Z0();
        } else {
            j2();
        }
        d.a.q0.h2.k.e.u uVar = this.W0;
        if (uVar != null) {
            uVar.c();
        }
        this.f58011c.g5();
        this.y.setVisibility(8);
        this.f58016h.C(false);
        this.f58011c.W5(false);
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

    public void H2(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
            this.z.p0(onClickListener);
        }
    }

    public View I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.J0 : (View) invokeV.objValue;
    }

    public void I1() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            RelativeLayout relativeLayout = this.f58012d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.f58012d.getHandler().removeCallbacksAndMessages(null);
            }
            d.a.q0.h2.p.h hVar = this.t0;
            if (hVar != null) {
                hVar.g();
            }
            o0 o0Var = this.X0;
            if (o0Var != null) {
                o0Var.a();
            }
            d.a.q0.h2.k.e.h0 h0Var = this.m1;
            if (h0Var != null) {
                h0Var.c();
            }
            PbTopTipView pbTopTipView = this.e1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.f58011c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.L) != null) {
                noNetworkView.d(bVar);
            }
            a0();
            g0();
            if (this.U0 != null) {
                d.a.d.e.m.e.a().removeCallbacks(this.U0);
            }
            PbInterviewStatusView pbInterviewStatusView = this.G0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            this.J1 = null;
            this.f58015g.removeCallbacksAndMessages(null);
            this.z.W(3);
            View view = this.f58013e;
            if (view != null) {
                view.setBackgroundDrawable(null);
            }
            d.a.q0.h2.k.e.b1.g gVar = this.p;
            if (gVar != null) {
                gVar.a();
            }
            d.a.q0.h2.k.e.i iVar = this.z;
            if (iVar != null) {
                iVar.X();
            }
            this.l.setOnLayoutListener(null);
            d.a.q0.h2.k.e.c1.c cVar = this.i1;
            if (cVar != null) {
                cVar.l();
            }
            PbEmotionBar pbEmotionBar = this.R0;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            d.a.q0.h2.k.e.b1.f fVar = this.s;
            if (fVar != null) {
                fVar.r();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.f58009a);
            }
        }
    }

    public void I2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.u1 = i2;
        }
    }

    public PbFakeFloorModel J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.V0 : (PbFakeFloorModel) invokeV.objValue;
    }

    public void J1(TbRichText tbRichText) {
        d.a.q0.h2.h.e eVar;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, tbRichText) == null) || (eVar = this.A0) == null || eVar.E() == null || this.A0.E().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i2 = 0; i2 < this.A0.E().size() && (postData = this.A0.E().get(i2)) != null && postData.t() != null && !StringUtils.isNull(postData.t().getUserId()); i2++) {
            if (this.A0.E().get(i2).t().getUserId().equals(tbRichText.getAuthorId())) {
                d.a.q0.h2.k.d.a aVar = this.j1;
                if (aVar != null && aVar.l()) {
                    Z2(false);
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

    public void J2(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onLongClickListener) == null) {
            this.s.u(onLongClickListener);
            this.z.m0(onLongClickListener);
            d.a.q0.h2.k.d.a aVar = this.j1;
            if (aVar != null) {
                aVar.r(onLongClickListener);
            }
        }
    }

    public d.a.q0.h2.k.e.u K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.W0 : (d.a.q0.h2.k.e.u) invokeV.objValue;
    }

    public boolean K1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            d.a.q0.h2.k.e.b1.g gVar = this.p;
            if (gVar != null) {
                return gVar.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void K2(PostData postData, d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, postData, eVar) == null) {
            this.s.v(postData, eVar);
        }
    }

    public d.a.q0.h2.k.e.b1.g L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.p : (d.a.q0.h2.k.e.b1.g) invokeV.objValue;
    }

    public void L1() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || this.f58011c == null) {
            return;
        }
        if ((this.t1 || this.u1 == 17) && d.a.p0.b.d.l0()) {
            d.a.q0.h2.h.e eVar = this.A0;
            if (eVar == null || eVar.m() == null || d.a.d.e.p.k.isEmpty(this.A0.m().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f58011c.getContext()).createNormalCfg(this.A0.m().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.A0.P()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.A0.m().getId()));
        } else if (!this.b1 || this.a1 || (postData = this.B0) == null || postData.t() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.f58011c.isSimpleForum() ? 2 : 1).param("obj_type", this.a1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f58011c.getPageContext().getPageActivity(), this.B0.t().getUserId(), this.B0.t().getUserName(), this.f58011c.y().n0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void L2(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048617, this, z2, postWriteCallBackData) == null) {
            this.f58011c.hideProgressBar();
            if (z2) {
                a0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                b0();
            } else {
                a0();
            }
        }
    }

    public final PostData M0(d.a.q0.h2.h.e eVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null || eVar.N().H() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData H = eVar.N().H();
            String userId = H.getUserId();
            HashMap<String, MetaData> v1 = eVar.N().v1();
            if (v1 != null && (metaData = v1.get(userId)) != null && metaData.getUserId() != null) {
                H = metaData;
            }
            postData.i0(1);
            postData.l0(eVar.N().U());
            postData.x0(eVar.N().getTitle());
            postData.w0(eVar.N().N());
            postData.g0(H);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void M1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) {
            if (z2) {
                e3();
            } else {
                a1();
            }
            this.Q0.f58058c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Q0));
            Y1(this.Q0.f58058c, false);
        }
    }

    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.f58011c.hideProgressBar();
            g0();
            this.l.A(0L);
            d0();
        }
    }

    public String N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (!d.a.d.e.p.k.isEmpty(this.q1)) {
                return this.q1;
            }
            if (this.f58011c != null) {
                this.q1 = TbadkCoreApplication.getInst().getResources().getString(r0.b());
            }
            return this.q1;
        }
        return (String) invokeV.objValue;
    }

    public void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            z3();
            this.z.W(1);
            d.a.q0.h2.k.e.b1.g gVar = this.p;
            if (gVar != null) {
                gVar.l();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void N2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (pbFragment = this.f58011c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        d.a.d.e.p.l.x(this.f58011c.getPageContext().getPageActivity(), this.f58011c.getBaseFragmentActivity().getCurrentFocus());
    }

    public final int O0(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, pbReplyTitleViewHolder)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.z.W(2);
            d.a.q0.h2.k.e.b1.g gVar = this.p;
            if (gVar != null) {
                gVar.m();
                if (TbSingleton.getInstance().isNotchScreen(this.f58011c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f58011c.getFragmentActivity())) {
                    return;
                }
                V0().setSystemUiVisibility(4);
            }
        }
    }

    public void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.F.x();
            this.F.O();
        }
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? R.id.richText : invokeV.intValue;
    }

    public void P1(AbsListView absListView, int i2, int i3, int i4) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        d.a.q0.h2.k.e.b1.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048628, this, absListView, i2, i3, i4) == null) {
            d.a.q0.h2.k.e.b1.g gVar = this.p;
            if (gVar != null) {
                gVar.n(absListView, i2, i3, i4);
            }
            d.a.q0.h2.k.e.h1.c cVar = this.f58016h;
            if (cVar != null && (fVar = this.s) != null) {
                cVar.x(fVar.m());
            }
            m0 m0Var = this.Q0;
            m0Var.f58056a = i2;
            m0Var.f58057b = this.l.getHeaderViewsCount();
            this.Q0.f58058c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Q0));
            Y2(Q(absListView, i2));
            int i5 = 0;
            Y1(this.Q0.f58058c, false);
            Z();
            if (!this.F.m() || this.F.C) {
                return;
            }
            m0 m0Var2 = this.Q0;
            if (m0Var2 != null && (pbReplyTitleViewHolder = m0Var2.f58058c) != null && pbReplyTitleViewHolder.a() != null) {
                i5 = this.Q0.f58058c.a().getTop() < 0 ? this.Q0.f58058c.a().getHeight() : this.Q0.f58058c.a().getBottom();
            }
            this.F.e(i5);
            this.F.C = true;
        }
    }

    public void P2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            this.s.w(z2);
        }
    }

    public final boolean Q(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048630, this, absListView, i2)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
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
        if (interceptable == null || interceptable.invokeLI(1048632, this, absListView, i2) == null) {
            d.a.q0.h2.k.e.b1.g gVar = this.p;
            if (gVar != null) {
                gVar.o(absListView, i2);
            }
            if (!this.V1 && i2 == 0) {
                this.T1 = Q0();
                this.Q0.f58058c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Q0));
                Y1(this.Q0.f58058c, true);
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

    public void Q2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.p0.performClick();
            if (StringUtils.isNull(str) || this.f58011c.R4() == null || this.f58011c.R4().w() == null || this.f58011c.R4().w().i() == null) {
                return;
            }
            EditText i2 = this.f58011c.R4().w().i();
            i2.setText(str);
            i2.setSelection(str.length());
        }
    }

    public boolean R(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048634, this, z2)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.D0 : invokeV.intValue;
    }

    public void R1(ArrayList<d.a.p0.s.q.m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, arrayList) == null) {
            if (this.R == null) {
                this.R = LayoutInflater.from(this.f58011c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f58011c.getBaseFragmentActivity().getLayoutMode().j(this.R);
            if (this.Q == null) {
                Dialog dialog = new Dialog(this.f58011c.getPageContext().getPageActivity(), R.style.common_alert_dialog);
                this.Q = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.Q.setCancelable(true);
                this.f0 = (ScrollView) this.R.findViewById(R.id.good_scroll);
                this.Q.setContentView(this.R);
                WindowManager.LayoutParams attributes = this.Q.getWindow().getAttributes();
                attributes.width = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
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
            CustomBlueCheckRadioButton W = W("0", this.f58011c.getPageContext().getString(R.string.thread_good_class));
            this.n.add(W);
            W.setChecked(true);
            this.S.addView(W);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    d.a.p0.s.q.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton W2 = W(String.valueOf(m0Var.a()), m0Var.b());
                        this.n.add(W2);
                        View view = new View(this.f58011c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.S.addView(view);
                        this.S.addView(W2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.f0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = d.a.d.e.p.l.e(this.f58011c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = d.a.d.e.p.l.e(this.f58011c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = d.a.d.e.p.l.e(this.f58011c.getPageContext().getPageActivity(), 186.0f);
                }
                this.f0.setLayoutParams(layoutParams2);
                this.f0.removeAllViews();
                LinearLayout linearLayout = this.S;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.f0.addView(this.S);
                }
            }
            d.a.d.e.m.g.j(this.Q, this.f58011c.getPageContext());
        }
    }

    public void R2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.l.setSelection(i2);
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.f58013e : (View) invokeV.objValue;
    }

    public void S1(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            T1(i2, str, i3, z2, null);
        }
    }

    public void S2(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048641, this, i2, i3) == null) {
            this.l.setSelectionFromTop(i2, i3);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            if (!this.f58011c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.d0));
            } else if (this.f58011c.h4()) {
                d.a.p0.x.w.e R4 = this.f58011c.R4();
                if (R4 != null && (R4.C() || R4.E())) {
                    this.f58011c.R4().A(false, null);
                    return;
                }
                if (this.g0 != null) {
                    j1();
                }
                EditorTools editorTools = this.g0;
                if (editorTools != null) {
                    this.w0 = false;
                    if (editorTools.n(2) != null) {
                        d.a.q0.h3.g0.a.c(this.f58011c.getPageContext(), (View) this.g0.n(2).k, false, e2);
                    }
                }
                X0();
            }
        }
    }

    public PbThreadPostView T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public void T1(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            U1(i2, str, i3, z2, str2, false);
        }
    }

    public void T2(int i2) {
        NavigationBar navigationBar;
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048645, this, i2) == null) || this.l == null) {
            return;
        }
        d.a.q0.h2.k.e.h1.c cVar = this.f58016h;
        int i3 = 0;
        if (cVar != null && (navigationBar = cVar.f57901a) != null) {
            int fixedNavHeight = navigationBar.getFixedNavHeight();
            if (!(this.f58011c.C4() != -1)) {
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

    public void U(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z2) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.y : (RelativeLayout) invokeV.objValue;
    }

    public void U1(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
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
            this.O = new d.a.p0.s.s.a(this.f58011c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.O.setMessageId(i4);
            } else {
                this.O.setOnlyMessageShowCenter(false);
                this.O.setMessage(str2);
            }
            this.O.setYesButtonTag(sparseArray);
            this.O.setPositiveButton(R.string.dialog_ok, this.f58011c);
            this.O.setNegativeButton(R.string.dialog_cancel, new o(this));
            this.O.setCancelable(true);
            this.O.create(this.f58011c.getPageContext());
            if (z3) {
                this.O.show();
            } else if (z2) {
                this.O.show();
            } else if (V2()) {
                d.a.q0.h.i iVar = new d.a.q0.h.i(this.f58011c.y().L0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f58011c.y().L0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f58011c.y().L0().p().has_forum_rule.intValue());
                iVar.i(this.f58011c.y().L0().m().getId(), this.f58011c.y().L0().m().getName());
                iVar.h(this.f58011c.y().L0().m().getImage_url());
                iVar.j(this.f58011c.y().L0().m().getUser_level());
                h3(this.O, i2, iVar, this.f58011c.y().L0().T());
            } else {
                p3(this.O, i2);
            }
        }
    }

    public void U2(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, list) == null) {
            this.h1 = list;
            d.a.q0.h2.k.e.c1.c cVar = this.i1;
            if (cVar != null) {
                cVar.q(list);
            }
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            d.a.q0.h2.k.d.a aVar = new d.a.q0.h2.k.d.a(this.f58011c, this, (ViewStub) this.f58012d.findViewById(R.id.more_god_reply_popup));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.f58012d : (View) invokeV.objValue;
    }

    public void V1(SparseArray<Object> sparseArray, boolean z2) {
        d.a.p0.s.s.h hVar;
        d.a.p0.s.s.h hVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048652, this, sparseArray, z2) == null) {
            d.a.p0.s.s.l lVar = new d.a.p0.s.s.l(this.f58011c.getContext());
            lVar.q(this.f58011c.getString(R.string.bar_manager));
            lVar.n(new n(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                    hVar2 = new d.a.p0.s.s.h(10, this.f58011c.getString(R.string.delete_post), lVar);
                } else {
                    hVar2 = new d.a.p0.s.s.h(10, this.f58011c.getString(R.string.delete), lVar);
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
                hVar2.f53561d.setTag(sparseArray2);
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
                d.a.p0.s.s.h hVar3 = new d.a.p0.s.s.h(11, this.f58011c.getString(R.string.forbidden_person), lVar);
                hVar3.f53561d.setTag(sparseArray3);
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
                    hVar = new d.a.p0.s.s.h(12, this.f58011c.getString(R.string.un_mute), lVar);
                } else {
                    hVar = new d.a.p0.s.s.h(12, this.f58011c.getString(R.string.mute), lVar);
                }
                hVar.f53561d.setTag(sparseArray4);
                arrayList.add(hVar);
            }
            d.a.q0.h2.k.e.g1.a.e(arrayList);
            if (d.a.p0.b.d.L()) {
                lVar.l(arrayList, false);
            } else {
                lVar.l(arrayList, true);
            }
            d.a.p0.s.s.j jVar = new d.a.p0.s.s.j(this.f58011c.getPageContext(), lVar);
            this.M = jVar;
            jVar.l();
        }
    }

    public final boolean V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            PbFragment pbFragment = this.f58011c;
            return (pbFragment == null || pbFragment.y().L0().m().getDeletedReasonInfo() == null || 1 != this.f58011c.y().L0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final CustomBlueCheckRadioButton W(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048654, this, str, str2)) == null) {
            Activity pageActivity = this.f58011c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, d.a.d.e.p.l.g(pageActivity, R.dimen.ds100));
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
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.H0.setVisibility(8);
            }
            d.a.q0.h2.k.e.h1.c cVar = this.f58016h;
            if (cVar == null || (view = cVar.f57904d) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public void W1(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048656, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        V1(sparseArray, false);
    }

    public void W2() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.H0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            d.a.q0.h2.k.e.h1.c cVar = this.f58016h;
            if (cVar == null || (view = cVar.f57904d) == null) {
                return;
            }
            view.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048658, this) == null) || this.U1) {
            return;
        }
        TiebaStatic.log("c10490");
        this.U1 = true;
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f58011c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(Y1, Integer.valueOf(a2));
        aVar.setTitle(R.string.grade_thread_tips);
        View inflate = LayoutInflater.from(this.f58011c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
        ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
        aVar.setContentView(inflate);
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(R.string.grade_button_tips, this.f58011c);
        aVar.setNegativeButton(R.string.look_again, new c0(this));
        aVar.create(this.f58011c.getPageContext()).show();
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048659, this) == null) || this.m0 == null) {
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

    public void X1(d.a.p0.u.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048660, this, aVar, i2) == null) && r0.a(aVar, i2)) {
            this.A1.M(aVar.f(), 10, false);
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.e())).setProgressiveRenderingEnabled(true).build(), this.f58011c.getContext()).subscribe(new d(this, aVar, i2), CallerThreadExecutor.getInstance());
        }
    }

    public void X2() {
        d.a.q0.h2.k.e.b1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048661, this) == null) || (gVar = this.p) == null) {
            return;
        }
        gVar.v(this.l);
    }

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f58011c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f58011c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
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
            aVar.setPositiveButton(R.string.view, this.f58011c);
            aVar.setNegativeButton(R.string.cancel, new d0(this));
            aVar.create(this.f58011c.getPageContext()).show();
        }
    }

    public void Y0(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048663, this, z2) == null) || this.m0 == null || this.p0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        d.a.q0.h2.h.e eVar = this.A0;
        boolean z3 = eVar != null && eVar.g0();
        d.a.q0.h2.h.e eVar2 = this.A0;
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
        if (!(interceptable == null || interceptable.invokeLZ(1048664, this, pbReplyTitleViewHolder, z2) == null) || this.a1 || this.J0 == null || this.f58016h.p() == null) {
            return;
        }
        View r2 = l0().r();
        if (r2 != null) {
            int[] iArr = new int[2];
            r2.getLocationInWindow(iArr);
            int i3 = iArr[1];
            if (i3 != 0) {
                if (this.J0.getVisibility() == 0 && i3 - this.f58016h.p().getBottom() <= this.J0.getHeight()) {
                    this.K0.setVisibility(0);
                    if (i3 > this.f58016h.p().getBottom()) {
                        i2 = -(((this.J0.getHeight() + this.K0.getHeight()) + this.f58016h.p().getBottom()) - r2.getBottom());
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
                m2(false);
                return;
            }
            this.J0.setVisibility(0);
            m2(true);
            Y2(false);
            this.f58016h.f57901a.hideBottomLine();
            if (this.J0.getParent() == null || ((ViewGroup) this.J0.getParent()).getHeight() > this.J0.getTop()) {
                return;
            }
            this.J0.getParent().requestLayout();
        } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.a() != null && pbReplyTitleViewHolder.f19552g != null) {
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
                    measuredHeight = W1 - pbReplyTitleViewHolder.f19552g.getMeasuredHeight();
                } else {
                    measuredHeight = this.f58016h.p().getMeasuredHeight() - pbReplyTitleViewHolder.f19552g.getMeasuredHeight();
                    this.f58016h.f57901a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.a().getParent() == null && top <= this.O0) {
                    this.J0.setVisibility(0);
                    m2(true);
                    Y2(false);
                } else if (top < measuredHeight) {
                    this.J0.setVisibility(0);
                    m2(true);
                    Y2(false);
                } else {
                    this.J0.setVisibility(4);
                    m2(false);
                    this.f58016h.f57901a.hideBottomLine();
                }
                if (z2) {
                    this.P0 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.J0.setVisibility(4);
            m2(false);
            this.f58016h.f57901a.hideBottomLine();
        }
    }

    public void Y2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048665, this, z2) == null) {
            this.i0.setVisibility(z2 ? 0 : 8);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.v1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Z() {
        d.a.q0.h2.p.g gVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048666, this) == null) || (gVar = this.x1) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || (editorTools = this.g0) == null) {
            return;
        }
        editorTools.o();
        d.a.q0.h2.k.e.c1.c cVar = this.i1;
        if (cVar != null) {
            cVar.m();
        }
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            this.s.s(this.A0, this.B0, this.b1, this.a1);
        }
    }

    public void Z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048669, this, z2) == null) || this.m0 == null) {
            return;
        }
        r2(this.f58011c.R4().D());
        if (this.h0) {
            c3(z2);
        } else {
            Y0(z2);
        }
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            this.f58016h.k();
            d.a.q0.h2.k.e.b1.f fVar = this.s;
            if (fVar != null) {
                fVar.k();
            }
            PbFragment pbFragment = this.f58011c;
            if (pbFragment != null) {
                d.a.d.e.p.l.x(pbFragment.getContext(), this.D);
            }
            Z0();
            d.a.p0.s.s.j jVar = this.X;
            if (jVar != null) {
                jVar.dismiss();
            }
            e0();
            d.a.p0.s.s.a aVar = this.A;
            if (aVar != null) {
                aVar.dismiss();
            }
            d.a.p0.s.s.b bVar = this.B;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void a1() {
        d.a.q0.h2.k.e.h1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048672, this) == null) || (cVar = this.f58016h) == null) {
            return;
        }
        cVar.q();
    }

    public void a2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048673, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.Z0;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.Q0.f58058c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Q0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.Q0.f58058c;
        int O0 = O0(pbReplyTitleViewHolder);
        int measuredHeight = this.y.getMeasuredHeight() + ((int) this.y.getY());
        boolean z2 = this.J0.getVisibility() == 0;
        boolean z3 = this.y.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.z.G() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.f19552g.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.z.G() + this.l.getHeaderViewsCount(), W1 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.z.G() + this.l.getHeaderViewsCount(), this.f58016h.p().getMeasuredHeight() - measuredHeight2);
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

    public void a3(d.a.q0.h2.h.e eVar) {
        PostData postData;
        d.a.q0.h2.k.e.h1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048674, this, eVar) == null) || eVar == null || (postData = this.B0) == null || postData.t() == null || (cVar = this.f58016h) == null) {
            return;
        }
        boolean z2 = !this.a1;
        this.b1 = z2;
        cVar.H(z2);
        if (this.f58011c.S4() != null) {
            this.f58011c.S4().s(this.b1);
        }
        Z1();
        PbFragment pbFragment = this.f58011c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(eVar.q())) {
            x1 x1Var = eVar.q().get(0);
            if (x1Var != null) {
                this.f58016h.L(eVar, x1Var.g(), x1Var.h(), x1Var.a(), x1Var.getIsLike());
            }
        } else if (eVar.m() != null) {
            this.f58016h.L(eVar, eVar.m().getName(), eVar.m().getId(), eVar.m().getImage_url(), eVar.m().isLike() == 1);
        }
        if (this.b1) {
            this.s.C(eVar, this.B0, this.b0);
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
        this.s.C(eVar, this.B0, this.b0);
        this.k1 = null;
        this.l.setListViewDragListener(null);
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            this.f58016h.k();
            d.a.q0.h2.k.e.b1.f fVar = this.s;
            if (fVar != null) {
                fVar.k();
            }
            d.a.p0.s.s.j jVar = this.X;
            if (jVar != null) {
                jVar.dismiss();
            }
            e0();
            d.a.p0.s.s.a aVar = this.A;
            if (aVar != null) {
                aVar.dismiss();
            }
            d.a.p0.s.s.b bVar = this.B;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void b1() {
        d.a.p0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048676, this) == null) || (aVar = this.y0) == null) {
            return;
        }
        aVar.h(false);
    }

    public final void b2(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048677, this, eVar) == null) || eVar == null || eVar.N() == null) {
            return;
        }
        D3(eVar);
        if (eVar.s()) {
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String k02 = k0(eVar.N().Q0());
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

    public final boolean b3(d.a.q0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048678, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null) {
                return false;
            }
            return eVar.N().h0() == 1 || eVar.N().k1() == 33 || !(eVar.N().r1() == null || eVar.N().r1().a() == 0) || eVar.N().n0() == 1 || eVar.N().m0() == 1 || eVar.N().C1() || eVar.N().U1() || eVar.N().v2() || eVar.N().z1() != null || !d.a.d.e.p.k.isEmpty(eVar.N().L()) || eVar.N().R1() || eVar.N().f2();
        }
        return invokeL.booleanValue;
    }

    public void c0() {
        d.a.q0.h2.p.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048679, this) == null) || (hVar = this.t0) == null) {
            return;
        }
        hVar.h(false);
    }

    public void c1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
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

    public void c2(int i2, d.a.q0.h2.h.e eVar, boolean z2, int i3) {
        PostData t0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048681, this, new Object[]{Integer.valueOf(i2), eVar, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) || i2 <= 0 || (t0 = t0(eVar, z2)) == null || t0.t() == null) {
            return;
        }
        MetaData t2 = t0.t();
        t2.setGiftNum(t2.getGiftNum() + i2);
    }

    public void c3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048682, this, z2) == null) || this.m0 == null || (textView = this.p0) == null) {
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

    public final boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.q.b(this.z0) : invokeV.booleanValue;
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            this.I.setVisibility(8);
        }
    }

    public void d2(d.a.q0.h2.h.e eVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048685, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            k3(eVar, z2, i2, i3);
            this.s.q(i3);
        }
    }

    public void d3(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048686, this, view) == null) || d.a.p0.s.d0.b.j().g("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.m0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f58011c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f58011c.getContext());
        this.g1 = textView;
        textView.setText(R.string.connection_tips);
        this.g1.setGravity(17);
        this.g1.setPadding(d.a.d.e.p.l.g(this.f58011c.getContext(), R.dimen.ds24), 0, d.a.d.e.p.l.g(this.f58011c.getContext(), R.dimen.ds24), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = d.a.d.e.p.l.g(this.f58011c.getContext(), R.dimen.ds60);
        if (this.g1.getParent() == null) {
            frameLayout.addView(this.g1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f58011c.getContext());
        this.f1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.f1.setHeight(-2);
        this.f1.setWidth(-2);
        this.f1.setFocusable(true);
        this.f1.setOutsideTouchable(false);
        this.f1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new f0(this, i4, i2, i3, view), 100L);
        d.a.p0.s.d0.b.j().t("show_long_press_collection_tips", true);
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            d.a.p0.s.s.a aVar = this.O;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.P;
            if (dialog != null) {
                d.a.d.e.m.g.b(dialog, this.f58011c.getPageContext());
            }
            Dialog dialog2 = this.Q;
            if (dialog2 != null) {
                d.a.d.e.m.g.b(dialog2, this.f58011c.getPageContext());
            }
            d.a.p0.s.s.j jVar = this.M;
            if (jVar != null) {
                jVar.dismiss();
            }
        }
    }

    public void e1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048688, this) == null) || (rightFloatLayerView = this.C1) == null) {
            return;
        }
        rightFloatLayerView.f();
    }

    public final void e2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048689, this) == null) && (pbInterviewStatusView = this.G0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.G0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.G0.setLayoutParams(layoutParams);
        }
    }

    public void e3() {
        d.a.q0.h2.k.e.h1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048690, this) == null) || (cVar = this.f58016h) == null || this.c1) {
            return;
        }
        cVar.D();
        this.c1 = true;
    }

    public void f0() {
        d.a.q0.h2.k.e.b1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048691, this) == null) || (gVar = this.p) == null) {
            return;
        }
        gVar.b();
    }

    public void f1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048692, this) == null) || (editorTools = this.g0) == null) {
            return;
        }
        editorTools.q();
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048693, this) == null) || this.f58014f == 2) {
            return;
        }
        this.l.setNextPage(this.F);
        this.f58014f = 2;
    }

    public void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && this.r == null) {
            this.r = new d.a.q0.h2.k.e.b1.d(this.f58011c, this.e0);
        }
    }

    public void g2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048697, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.r.d(pbLandscapeListView);
        this.s.t(this.l);
        this.t.d(this.l);
        this.q.f(this.l);
    }

    public void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            if (this.y0 == null) {
                this.y0 = new d.a.p0.s.f0.a(this.f58011c.getPageContext());
            }
            this.y0.h(true);
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            this.l.A(0L);
            d0();
        }
    }

    public final void h1(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048700, this, eVar) == null) && eVar != null && eVar.N() != null && eVar.N().U1() && this.G0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.F0.inflate();
            this.G0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.J);
            this.G0.setCallback(this.f58011c.H4());
            this.G0.setData(this.f58011c, eVar);
        }
    }

    public final void h2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048701, this) == null) || (pbFragment = this.f58011c) == null || pbFragment.R4() == null || this.g0 == null) {
            return;
        }
        d.a.p0.x.w.a.a().c(0);
        d.a.p0.x.w.e R4 = this.f58011c.R4();
        R4.U();
        R4.S();
        if (R4.z() != null) {
            R4.z().setMaxImagesAllowed(R4.z ? 1 : 9);
        }
        R4.m0(SendView.k);
        R4.j(SendView.k);
        d.a.p0.x.h m2 = this.g0.m(23);
        d.a.p0.x.h m3 = this.g0.m(2);
        d.a.p0.x.h m4 = this.g0.m(5);
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

    public final void h3(d.a.p0.s.s.a aVar, int i2, d.a.q0.h.i iVar, UserData userData) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048702, this, aVar, i2, iVar, userData) == null) || (pbFragment = this.f58011c) == null || aVar == null) {
            return;
        }
        if (this.p1 == null && this.q != null) {
            this.p1 = new d.a.q0.h.j(pbFragment.getPageContext(), this.q.c(), iVar, userData);
        }
        AntiData x4 = this.f58011c.x4();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (x4 != null && x4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = x4.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        d.a.p0.s.q.w0 w0Var = new d.a.p0.s.q.w0();
        w0Var.j(sparseArray);
        this.p1.B(new String[]{this.f58011c.getString(R.string.delete_thread_reason_1), this.f58011c.getString(R.string.delete_thread_reason_2), this.f58011c.getString(R.string.delete_thread_reason_3), this.f58011c.getString(R.string.delete_thread_reason_4), this.f58011c.getString(R.string.delete_thread_reason_5)});
        this.p1.A(w0Var);
        this.p1.D((i2 == 1 || i2 == 2) ? "4" : "3");
        this.p1.C(new q(this, aVar));
    }

    public void i0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048703, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f58011c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f58011c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.success));
            } else if (z3) {
                if (d.a.d.e.p.k.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                }
                this.f58011c.showToast(str);
            }
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048704, this) == null) && this.f58011c.J4()) {
            ViewStub viewStub = (ViewStub) this.f58012d.findViewById(R.id.manga_mention_controller_view_stub);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.v == null) {
                this.v = (LinearLayout) this.f58012d.findViewById(R.id.manga_controller_layout);
                d.a.p0.u0.a.a(this.f58011c.getPageContext(), this.v);
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
        if (interceptable == null || interceptable.invokeZ(1048705, this, z2) == null) {
        }
    }

    public void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            this.z.a0(this.A0, false);
            this.z.V();
        }
    }

    public void j0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048707, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public void j1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048708, this) == null) || this.f58011c == null || (editorTools = this.g0) == null) {
            return;
        }
        editorTools.j();
        if (this.f58011c.R4() != null) {
            this.f58011c.R4().Q();
        }
        X0();
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            h2();
            Z0();
            this.W0.c();
            Z2(false);
        }
    }

    public void j3(d.a.q0.h2.h.e eVar, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Parcelable e3;
        Parcelable e4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048710, this, new Object[]{eVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) || eVar == null || this.l == null) {
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
        M2();
        d.a.q0.h2.h.k kVar = eVar.f57444h;
        if (kVar != null && kVar.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f58011c.getContext());
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
        k3(eVar, z2, i2, TbadkCoreApplication.getInst().getSkinType());
        a3(eVar);
        if (this.m1 == null) {
            this.m1 = new d.a.q0.h2.k.e.h0(this.f58011c.getPageContext(), this.n1);
        }
        this.m1.a(eVar.w());
        if (this.f58011c.J4()) {
            if (this.E == null) {
                d.a.q0.h2.p.i iVar = new d.a.q0.h2.p.i(this.f58011c.getPageContext());
                this.E = iVar;
                iVar.n();
                this.E.a(this.R1);
            }
            this.l.setPullRefresh(this.E);
            k2();
            d.a.q0.h2.p.i iVar2 = this.E;
            if (iVar2 != null) {
                iVar2.I(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (eVar.x().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.E == null) {
                d.a.q0.h2.p.i iVar3 = new d.a.q0.h2.p.i(this.f58011c.getPageContext());
                this.E = iVar3;
                iVar3.n();
                this.E.a(this.R1);
            }
            this.l.setPullRefresh(this.E);
            k2();
            d.a.q0.h2.p.i iVar4 = this.E;
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
        this.s.B(t0(eVar, z2), eVar.e0());
        if (eVar.N() != null && eVar.N().H0() != null && this.f58010b != -1) {
            eVar.N().H0().setIsLike(this.f58010b);
        }
        this.l.removeFooterView(this.N0);
        this.l.addFooterView(this.N0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.F);
            this.f58014f = 2;
            b1();
        } else {
            this.E0 = true;
            if (eVar.x().b() == 1) {
                if (this.G == null) {
                    PbFragment pbFragment = this.f58011c;
                    this.G = new d.a.q0.h2.p.e(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.G);
            } else {
                this.l.setNextPage(this.F);
            }
            this.f58014f = 3;
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
                if (m0Var == null || (pbReplyTitleViewHolder = m0Var.f58058c) == null || pbReplyTitleViewHolder.a() == null) {
                    i5 = 0;
                } else {
                    i5 = this.Q0.f58058c.a().getTop() < 0 ? this.Q0.f58058c.a().getHeight() : this.Q0.f58058c.a().getBottom();
                }
                if (this.f58011c.o5()) {
                    this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i5);
                } else {
                    this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i5);
                }
                if (this.f58011c.S4() != null && !this.f58011c.S4().p()) {
                    this.f58011c.S4().x();
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
                        d.a.q0.h2.k.e.b1.g gVar = this.p;
                        if (gVar != null && gVar.c() != null) {
                            if (this.f58011c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.z.B() + this.l.getHeaderViewsCount()) - 1, this.p.d() - d.a.d.e.p.l.r(this.f58011c.getPageContext().getPageActivity()));
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
                    this.F.A(this.f58011c.getString(R.string.pb_load_more_without_point));
                    this.F.v();
                }
            } else if (i4 == 1 && (e4 = d.a.q0.h2.k.e.m0.b().e()) != null && !(e4 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e4);
            } else {
                this.l.setSelection(0);
            }
        } else if (i4 == 1 && (e3 = d.a.q0.h2.k.e.m0.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
            this.l.post(new y(this, e3, E, eVar));
        }
        if (this.S0 == X1 && v1()) {
            X();
        }
        if (this.Y0) {
            a2();
            this.Y0 = false;
            if (i4 == 0) {
                B2(true);
            }
        }
        if (eVar.f57440d == 1 || eVar.f57441e == 1) {
            if (this.e1 == null) {
                this.e1 = new PbTopTipView(this.f58011c.getContext());
            }
            if (eVar.f57441e == 1 && "game_guide".equals(this.f58011c.X4())) {
                this.e1.setText(this.f58011c.getString(R.string.pb_read_strategy_add_experience));
                this.e1.l(this.f58012d, this.D0);
            } else if (eVar.f57440d == 1 && "game_news".equals(this.f58011c.X4())) {
                this.e1.setText(this.f58011c.getString(R.string.pb_read_news_add_experience));
                this.e1.l(this.f58012d, this.D0);
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
        if (eVar.c0() && this.f58011c.U4() != null) {
            this.f58011c.U4().d();
        }
        if (eVar.g() != 3) {
            l1(eVar);
        }
        this.p0.setText(TbSingleton.getInstance().getAdVertiComment(eVar.g0(), eVar.h0(), N0()));
    }

    public final String k0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048711, this, i2)) == null) {
            if (i2 == 0) {
                return this.f58011c.getString(R.string.pb_comment_red_dot_no_reply);
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
        if (!(interceptable == null || interceptable.invokeV(1048712, this) == null) || this.C1 == null) {
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
        d.a.q0.h2.k.e.b1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048713, this) == null) || (gVar = this.p) == null) {
            return;
        }
        gVar.q(this.l, this.I0, this.C0);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void k3(d.a.q0.h2.h.e eVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048714, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || eVar == null || eVar.N() == null) {
            return;
        }
        if (this.f58011c.isSimpleForum()) {
            if (eVar.h() != null) {
                this.c0 = eVar.h().g();
                this.d0 = eVar.h().h();
            }
            if (this.c0 == null && this.f58011c.y() != null && this.f58011c.y().n0() != null) {
                this.c0 = this.f58011c.y().n0();
            }
        }
        PostData t0 = t0(eVar, z2);
        K2(t0, eVar);
        this.s.y(8);
        if (eVar.l0()) {
            this.a1 = true;
            this.f58016h.B(true);
            this.f58016h.f57901a.hideBottomLine();
            if (this.p == null) {
                this.p = new d.a.q0.h2.k.e.b1.g(this.f58011c);
            }
            this.p.w(eVar, t0, this.l, this.s, this.H0, this.f58016h, this.c0, this.s1);
            this.p.t(this.O1);
            k2();
        } else {
            this.a1 = false;
            this.f58016h.B(false);
            d.a.q0.h2.k.e.b1.g gVar = this.p;
            if (gVar != null) {
                gVar.p(this.l);
            }
        }
        if (this.f58011c.S4() != null) {
            this.f58011c.S4().w(this.a1);
        }
        if (t0 == null) {
            return;
        }
        this.B0 = t0;
        this.s.y(0);
        SparseArray<Object> o2 = this.s.o();
        o2.put(R.id.tag_clip_board, t0);
        o2.put(R.id.tag_is_subpb, Boolean.FALSE);
        this.t.e(eVar, this.l);
        this.r.f(eVar);
        this.q.h(eVar, this.z0);
        this.q.g(eVar);
        this.s.z(this.D0, this.A0, t0, this.O1);
        if (this.M0 != null) {
            if (eVar.e0()) {
                this.M0.a().setVisibility(8);
            } else {
                this.M0.a().setVisibility(0);
                d.a.q0.h2.h.o oVar = new d.a.q0.h2.h.o(d.a.q0.h2.h.o.l);
                if (eVar.N() != null) {
                    eVar.N().Q0();
                }
                oVar.f57476g = eVar.f57443g;
                eVar.c();
                oVar.f57477h = this.f58011c.o5();
                oVar.k = eVar.f57442f;
                this.M0.h(oVar);
            }
        }
        t3(eVar);
        d.a.d.e.m.e.a().post(new w(this));
        this.u.e(this.l);
        if (t0.S) {
            this.u.f(t0.E());
            this.u.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        d.a.q0.h2.k.e.i iVar = this.z;
        if (iVar != null && iVar.z() != null) {
            this.z.z().r0(t0.S);
        }
        d.a.q0.h2.k.e.i iVar2 = this.z;
        if (iVar2 != null) {
            iVar2.j0(t0.S);
        }
        this.y1.setVisibility(t0.S ? 0 : 8);
    }

    public d.a.q0.h2.k.e.i l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) ? this.z : (d.a.q0.h2.k.e.i) invokeV.objValue;
    }

    public void l1(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, eVar) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048717, this) == null) || (handler = this.J1) == null) {
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

    public void l3(b.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048718, this, cVar, z2) == null) {
            d.a.p0.s.s.j jVar = this.Y;
            if (jVar != null) {
                jVar.dismiss();
                this.Y = null;
            }
            d.a.p0.s.s.l lVar = new d.a.p0.s.s.l(this.f58011c.getContext());
            ArrayList arrayList = new ArrayList();
            d.a.q0.h2.h.e eVar = this.A0;
            if (eVar != null && eVar.N() != null && !this.A0.N().J1()) {
                arrayList.add(new d.a.p0.s.s.h(0, this.f58011c.getPageContext().getString(R.string.save_to_emotion), lVar));
            }
            if (!z2) {
                arrayList.add(new d.a.p0.s.s.h(1, this.f58011c.getPageContext().getString(R.string.save_to_local), lVar));
            }
            lVar.k(arrayList);
            lVar.n(new u(this, cVar));
            d.a.p0.s.s.j jVar2 = new d.a.p0.s.s.j(this.f58011c.getPageContext(), lVar);
            this.Y = jVar2;
            jVar2.l();
        }
    }

    public LinearLayout m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) ? this.n0 : (LinearLayout) invokeV.objValue;
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048720, this) == null) && this.t == null) {
            this.t = new d.a.q0.h2.k.e.b1.c(this.f58011c, this.J);
        }
    }

    public final void m2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048721, this, z2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921599, Boolean.valueOf(z2)));
        }
    }

    public void m3(b.c cVar, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048722, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            d.a.p0.s.s.j jVar = this.X;
            if (jVar != null) {
                jVar.dismiss();
                this.X = null;
            }
            d.a.p0.s.s.l lVar = new d.a.p0.s.s.l(this.f58011c.getContext());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new d.a.p0.s.s.h(0, this.f58011c.getPageContext().getString(R.string.copy), lVar));
            if (z3) {
                arrayList.add(new d.a.p0.s.s.h(1, this.f58011c.getPageContext().getString(R.string.report_text), lVar));
            } else if (!z2) {
                arrayList.add(new d.a.p0.s.s.h(1, this.f58011c.getPageContext().getString(R.string.mark), lVar));
            } else {
                arrayList.add(new d.a.p0.s.s.h(1, this.f58011c.getPageContext().getString(R.string.remove_mark), lVar));
            }
            lVar.k(arrayList);
            lVar.n(new t(this, cVar));
            d.a.p0.s.s.j jVar2 = new d.a.p0.s.s.j(this.f58011c.getPageContext(), lVar);
            this.Y = jVar2;
            jVar2.l();
        }
    }

    public View n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            View view = this.R;
            if (view != null) {
                return view.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void n1(d.a.q0.h2.h.e eVar) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, eVar) == null) {
            int i2 = 0;
            this.z.a0(eVar, false);
            this.z.V();
            d0();
            d.a.q0.h2.k.d.a aVar = this.j1;
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
                    if (m0Var != null && (pbReplyTitleViewHolder = m0Var.f58058c) != null && pbReplyTitleViewHolder.a() != null) {
                        i2 = this.Q0.f58058c.a().getTop() < 0 ? this.Q0.f58058c.a().getHeight() : this.Q0.f58058c.a().getBottom();
                    }
                    if (this.f58011c.o5()) {
                        this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i2);
                    } else {
                        this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i2);
                    }
                }
            }
            b2(eVar);
        }
    }

    public void n2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, editorTools) == null) {
            this.g0 = editorTools;
            editorTools.setOnCancelClickListener(new k(this));
            this.g0.setId(R.id.pb_editor);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.g0.getParent() == null) {
                this.f58012d.addView(this.g0, layoutParams);
            }
            this.g0.w(TbadkCoreApplication.getInst().getSkinType());
            this.g0.setActionListener(24, new l(this));
            Z0();
            this.f58011c.R4().i(new m(this));
        }
    }

    public void n3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, onItemClickListener) == null) {
            d.a.p0.s.s.e eVar = this.Z;
            if (eVar != null) {
                eVar.d();
                this.Z = null;
            }
            if (this.A0 == null) {
                return;
            }
            ArrayList<d.a.p0.s.s.n> arrayList = new ArrayList<>();
            arrayList.add(new d.a.p0.s.s.n(this.f58011c.getContext().getString(R.string.all_person), "", this.A0.K() == 1, Integer.toString(1)));
            arrayList.add(new d.a.p0.s.s.n(this.f58011c.getContext().getString(R.string.my_fans), "", this.A0.K() == 2, Integer.toString(5)));
            arrayList.add(new d.a.p0.s.s.n(this.f58011c.getContext().getString(R.string.my_attentions), "", this.A0.K() == 3, Integer.toString(6)));
            arrayList.add(new d.a.p0.s.s.n(this.f58011c.getContext().getString(R.string.myself_only), "", this.A0.K() == 4, Integer.toString(7)));
            d.a.p0.s.s.e eVar2 = new d.a.p0.s.s.e(this.f58011c.getPageContext());
            eVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.Z = eVar2;
            eVar2.k(arrayList, onItemClickListener);
            eVar2.c();
            this.Z.n();
        }
    }

    public String o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) ? this.P1 : invokeV.booleanValue;
    }

    public void o2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048729, this, str) == null) || (pbListView = this.F) == null) {
            return;
        }
        pbListView.A(str);
    }

    public void o3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048730, this) == null) || !TbadkCoreApplication.isLogin() || this.A0 == null || !this.b1 || this.a1 || this.b0 || (postData = this.B0) == null || postData.t() == null || this.B0.t().getIsLike() || this.B0.t().hadConcerned() || this.X0 != null) {
            return;
        }
        this.X0 = new o0(this.f58011c);
    }

    public int p0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.w0 : invokeV.booleanValue;
    }

    public void p2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048733, this, str) == null) || this.F == null) {
            return;
        }
        int i2 = 0;
        m0 m0Var = this.Q0;
        if (m0Var != null && (pbReplyTitleViewHolder = m0Var.f58058c) != null && pbReplyTitleViewHolder.a() != null) {
            i2 = this.Q0.f58058c.a().getTop() < 0 ? this.Q0.f58058c.a().getHeight() : this.Q0.f58058c.a().getBottom();
        }
        this.F.D(str, i2);
    }

    public final void p3(d.a.p0.s.s.a aVar, int i2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048734, this, aVar, i2) == null) || (pbFragment = this.f58011c) == null || aVar == null) {
            return;
        }
        if (this.o1 == null && this.q != null) {
            this.o1 = new d.a.q0.h.g(pbFragment.getPageContext(), this.q.c());
        }
        AntiData x4 = this.f58011c.x4();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (x4 != null && x4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = x4.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        d.a.p0.s.q.w0 w0Var = new d.a.p0.s.q.w0();
        w0Var.j(sparseArray);
        this.o1.x(new String[]{this.f58011c.getString(R.string.delete_thread_reason_1), this.f58011c.getString(R.string.delete_thread_reason_2), this.f58011c.getString(R.string.delete_thread_reason_3), this.f58011c.getString(R.string.delete_thread_reason_4), this.f58011c.getString(R.string.delete_thread_reason_5)});
        this.o1.w(w0Var);
        this.o1.z((i2 == 1 || i2 == 2) ? "4" : "3");
        this.o1.y(new p(this, aVar));
    }

    public PostData q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
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

    public final boolean q1(d.a.q0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048736, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null) {
                return false;
            }
            SpannableStringBuilder c1 = eVar.N().c1();
            if (c1 != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(c1.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void q2(PbFragment.t2 t2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, t2Var) == null) {
            this.M1 = t2Var;
        }
    }

    public void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            this.I.setVisibility(0);
        }
    }

    public FallingView r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) ? this.z1 : (FallingView) invokeV.objValue;
    }

    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048741, this, z2) == null) {
            this.h0 = z2;
        }
    }

    public void r3(a1 a1Var, a.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048742, this, a1Var, eVar) == null) || a1Var == null) {
            return;
        }
        int a3 = a1Var.a();
        int h2 = a1Var.h();
        d.a.p0.s.s.a aVar = this.A;
        if (aVar != null) {
            aVar.show();
        } else {
            this.A = new d.a.p0.s.s.a(this.f58011c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f58011c.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
            this.C = inflate;
            this.A.setContentView(inflate);
            this.A.setPositiveButton(R.string.dialog_ok, eVar);
            this.A.setNegativeButton(R.string.dialog_cancel, new a0(this));
            this.A.setOnCalcelListener(new b0(this));
            this.A.create(this.f58011c.getPageContext()).show();
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
        this.f58011c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.D, 150);
    }

    public int s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) ? u0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            EditorTools editorTools = this.g0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void s2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048745, this, z2) == null) {
            this.z.b0(z2);
        }
    }

    public void s3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048746, this, z2) == null) || this.l == null || (textView = this.I0) == null || this.f58013e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f58013e.setVisibility(0);
            } else {
                this.f58013e.setVisibility(8);
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

    public PostData t0(d.a.q0.h2.h.e eVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048747, this, eVar, z2)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048748, this, postData)) == null) {
            if (postData == null || postData.t() == null) {
                return false;
            }
            MetaData t2 = postData.t();
            return (TextUtils.isEmpty(t2.getUserId()) && TextUtils.isEmpty(t2.getAvater())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void t2(boolean z2) {
        d.a.q0.h2.k.e.b1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048749, this, z2) == null) || (gVar = this.p) == null) {
            return;
        }
        gVar.r(z2);
    }

    public final void t3(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048750, this, eVar) == null) || eVar == null || eVar.N() == null || eVar.N().s2()) {
            return;
        }
        boolean z2 = eVar.N().m0() == 1;
        boolean z3 = eVar.N().n0() == 1;
        d.a.q0.h2.k.e.b1.f fVar = this.s;
        if (fVar != null) {
            fVar.j(eVar, z2, z3);
        }
        d.a.q0.h2.k.e.i iVar = this.z;
        if (iVar == null || iVar.t() == null) {
            return;
        }
        this.z.t().d(eVar, z2, z3);
    }

    public final int u0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048751, this, i2)) == null) {
            d.a.d.k.e.e adapter2 = this.l.getAdapter2();
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
            int n2 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof d.a.d.k.e.e)) ? 0 : this.l.getAdapter2().n();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void u2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048753, this, z2) == null) {
            this.t1 = z2;
        }
    }

    @SuppressLint({"CutPasteId"})
    public void u3(d.a.q0.h2.h.e eVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048754, this, eVar, z2) == null) || eVar == null) {
            return;
        }
        E3(eVar, z2);
        d0();
    }

    public Button v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) ? this.k0 : (Button) invokeV.objValue;
    }

    public final boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) ? TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.Q1) : invokeV.booleanValue;
    }

    public void v2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048757, this, z2) == null) {
            this.l1 = z2;
        }
    }

    public void v3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, str) == null) {
            this.f58011c.showToast(str);
        }
    }

    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) ? this.l.getHeaderViewsCount() : invokeV.intValue;
    }

    public final boolean w1(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048760, this, b2Var)) == null) {
            if (b2Var == null || b2Var.H() == null) {
                return false;
            }
            PostData t0 = t0(this.A0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (t0 == null || t0.t() == null) ? "" : t0.t().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void w2(boolean z2) {
        d.a.q0.h2.k.e.b1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048761, this, z2) == null) || (gVar = this.p) == null) {
            return;
        }
        gVar.s(z2);
    }

    public void w3(final d.a.p0.u.a aVar, Bitmap bitmap, final int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048762, this, aVar, bitmap, i2) == null) {
            final Random random = new Random();
            c.b bVar = new c.b(bitmap);
            bVar.p(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.o(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.m(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100), d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.n(new c.InterfaceC1452c() { // from class: d.a.q0.h2.k.e.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // d.a.q0.h2.p.c.InterfaceC1452c
                public final float a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? t0.D1(random) : invokeV.floatValue;
                }
            });
            bVar.q(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40), true, true);
            d.a.q0.h2.p.c l2 = bVar.l();
            this.z1.f();
            this.z1.a(l2, 19);
            d.a.d.e.m.e.a().postDelayed(this.H1, 2000L);
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TbImageView tbImageView = this.A1;
            if (tbImageView != null) {
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: d.a.q0.h2.k.e.a
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

    public TextView x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) ? this.s.l() : (TextView) invokeV.objValue;
    }

    public boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048765, this, z2) == null) {
            this.z.d0(z2);
        }
    }

    public void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048766, this) == null) {
            this.f58011c.showProgressBar();
        }
    }

    public PbInterviewStatusView y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) ? this.G0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) {
            d.a.q0.h2.h.e eVar = this.A0;
            return eVar == null || eVar.m() == null || "0".equals(this.A0.m().getId()) || "me0407".equals(this.A0.m().getName());
        }
        return invokeV.booleanValue;
    }

    public void y2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048769, this, z2) == null) {
            this.z.i0(z2);
        }
    }

    public void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048770, this) == null) {
            FallingView fallingView = this.z1;
            if (fallingView != null) {
                fallingView.g();
            }
            if (this.A1 != null) {
                d.a.d.e.m.e.a().removeCallbacks(this.H1);
                this.A1.setVisibility(8);
            }
        }
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) ? this.l1 : invokeV.booleanValue;
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) {
            d.a.q0.h2.k.e.b1.g gVar = this.p;
            return gVar != null && gVar.f();
        }
        return invokeV.booleanValue;
    }

    public void z2(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, gVar) == null) {
            this.R1 = gVar;
            d.a.q0.h2.p.i iVar = this.E;
            if (iVar != null) {
                iVar.a(gVar);
            }
        }
    }

    public void z3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048774, this) == null) || this.S1 == null) {
            return;
        }
        while (this.S1.size() > 0) {
            TbImageView remove = this.S1.remove(0);
            if (remove != null) {
                remove.Q();
            }
        }
    }
}
