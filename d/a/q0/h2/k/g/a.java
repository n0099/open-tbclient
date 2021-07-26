package d.a.q0.h2.k.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.EllipsizeRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.b1.j0;
import d.a.p0.s.f0.f;
import d.a.p0.s.q.w0;
import d.a.p0.s.s.a;
import d.a.p0.s.s.b;
import d.a.q0.a0.m;
import d.a.q0.h.g;
import d.a.q0.h.j;
import d.a.q0.h2.h.r;
import d.a.q0.h2.i.c;
import d.a.q0.h2.k.e.d0;
import d.a.q0.h2.k.g.b;
import d.a.q0.h3.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class a implements KeyboardEventLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int s0;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSkinView A;
    public d.a.p0.s.f0.a B;
    public d.a.q0.h2.k.g.d C;
    public View D;
    public MorePopupWindow E;
    public View F;
    public d.a.p0.s.s.b G;
    public View H;
    public BlankView I;
    public View J;
    public Dialog K;
    public d.a.p0.s.s.a L;
    public View.OnClickListener M;
    public d.a.p0.s.s.b N;
    public boolean O;
    public ProgressBar P;
    public NewSubPbActivity.q0 Q;
    public NewSubPbActivity.q0 R;
    public d.a.p0.x.w.h S;
    public int T;
    public ArrayList<PostData> U;
    public r V;
    public TextView W;
    public RelativeLayout X;
    public ImageView Y;
    public ImageView Z;

    /* renamed from: a  reason: collision with root package name */
    public SubPbView f58145a;
    public LinearLayout a0;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f58146b;
    public HeadImageView b0;

    /* renamed from: c  reason: collision with root package name */
    public View f58147c;
    public View c0;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f58148d;
    public d0 d0;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.h2.p.i f58149e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public NewSubPbActivity f58150f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f58151g;
    public SubPbModel g0;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f58152h;
    public int h0;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f58153i;
    public boolean i0;
    public RelativeLayout j;
    public d.a.q0.h.g j0;
    public NavigationBar k;
    public d.a.q0.h.j k0;
    public ImageView l;
    public d.a.q0.h2.k.g.c l0;
    public View m;
    public boolean m0;
    public TextView n;
    public f.g n0;
    public LinearLayout o;
    public MaskView o0;
    public HeadImageView p;
    public d.a.q0.h2.i.c p0;
    public TextView q;
    public AdapterView.OnItemLongClickListener q0;
    public View r;
    public AdapterView.OnItemClickListener r0;
    public ImageView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public EllipsizeRichTextView w;
    public TbImageView x;
    public PlayVoiceBntNew y;
    public TextView z;

    /* renamed from: d.a.q0.h2.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1436a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f58154e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f58155f;

        public RunnableC1436a(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58155f = aVar;
            this.f58154e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58155f.f58148d.setEnabled(this.f58154e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements y.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58156e;

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
            this.f58156e = aVar;
        }

        @Override // d.a.q0.h3.y.e
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                this.f58156e.T();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58157e;

        public c(a aVar) {
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
            this.f58157e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
            InterceptResult invokeCommon;
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                PostData postData = (PostData) ListUtils.getItem(this.f58157e.U, i2);
                if (view != null && view.getTag() != null) {
                    if (this.f58157e.d0 == null) {
                        this.f58157e.d0 = new d0(this.f58157e.f58150f.getPageContext(), this.f58157e.M);
                    }
                    this.f58157e.d0.l();
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e2) {
                        e2.printStackTrace();
                        sparseArray = null;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                    PostData postData2 = sparseArray.get(R.id.tag_clip_board) instanceof PostData ? (PostData) sparseArray.get(R.id.tag_clip_board) : null;
                    boolean z = this.f58157e.Z(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                    this.f58157e.d0.p(sparseArray, this.f58157e.g0.y0(), z, this.f58157e.m0 && postData2 != null && postData2.m0, this.f58157e.g0.g0());
                    if (z) {
                        this.f58157e.d0.C().setVisibility(0);
                        this.f58157e.d0.C().setTag(postData.E());
                    } else {
                        this.f58157e.d0.C().setVisibility(8);
                    }
                    this.f58157e.d0.z().setVisibility(8);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58158e;

        public d(a aVar) {
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
            this.f58158e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) && this.f58158e.f58150f != null && ViewHelper.checkUpIsLogin(this.f58158e.f58150f.getPageContext().getPageActivity())) {
                if ((this.f58158e.f58150f.mReplyPrivacyController != null && this.f58158e.g0 != null && this.f58158e.g0.e0() != null && !this.f58158e.f58150f.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.f58158e.g0.e0().replyPrivateFlag)) || this.f58158e.g0 == null || this.f58158e.S == null) {
                    return;
                }
                this.f58158e.K0();
                if (view != null && (view.getTag() instanceof b.a)) {
                    this.f58158e.s();
                    this.f58158e.g0.Y0();
                    return;
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(R.id.tag_photo_username);
                    String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                    if (str != null) {
                        this.f58158e.S.V(str2);
                        this.f58158e.S.U(str);
                    }
                }
                this.f58158e.u();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58159e;

        public e(a aVar) {
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
            this.f58159e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f58159e.I == null) {
                return;
            }
            this.f58159e.f58145a.g();
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f58160e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f58161f;

        public f(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58161f = aVar;
            this.f58160e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int headerViewsCount = this.f58160e + this.f58161f.f58148d.getHeaderViewsCount();
                if (headerViewsCount >= 1) {
                    headerViewsCount--;
                }
                this.f58161f.f58148d.setSelection(headerViewsCount);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58162e;

        public g(a aVar) {
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
            this.f58162e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f58162e.g0 == null || !this.f58162e.g0.E0()) {
                    if (this.f58162e.I != null) {
                        this.f58162e.f58145a.g();
                        return;
                    } else {
                        this.f58162e.f58150f.finish();
                        return;
                    }
                }
                this.f58162e.f58150f.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f58163a;

        public h(a aVar) {
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
            this.f58163a = aVar;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                this.f58163a.x(false);
                this.f58163a.x(true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58164e;

        public i(a aVar) {
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
            this.f58164e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f58164e.K != null && (this.f58164e.K instanceof Dialog)) {
                    d.a.d.e.m.g.b(this.f58164e.K, this.f58164e.f58150f.getPageContext());
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                this.f58164e.g0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue(), false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58165e;

        public j(a aVar) {
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
            this.f58165e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f58165e.K != null && (this.f58165e.K instanceof Dialog)) {
                    d.a.d.e.m.g.b(this.f58165e.K, this.f58165e.f58150f.getPageContext());
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null || this.f58165e.Q == null) {
                    return;
                }
                this.f58165e.Q.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f58166e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f58167f;

        public k(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58167f = aVar;
            this.f58166e = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f58167f.K != null && (this.f58167f.K instanceof Dialog)) {
                    d.a.d.e.m.g.b(this.f58167f.K, this.f58167f.f58150f.getPageContext());
                }
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                this.f58167f.f58150f.handleMuteClick(this.f58166e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f58168e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f58169f;

        public l(a aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58169f = aVar;
            this.f58168e = sparseArray;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f58169f.R != null) {
                    this.f58169f.R.a(new Object[]{this.f58168e.get(R.id.tag_del_post_id), this.f58168e.get(R.id.tag_manage_user_identity), this.f58168e.get(R.id.tag_del_post_is_self), this.f58168e.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(a aVar) {
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
    public class n implements g.InterfaceC1404g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f58170a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f58171b;

        public n(a aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58171b = aVar;
            this.f58170a = sparseArray;
        }

        @Override // d.a.q0.h.g.InterfaceC1404g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.f58171b.R != null) {
                    this.f58171b.R.a(new Object[]{this.f58170a.get(R.id.tag_del_post_id), this.f58170a.get(R.id.tag_manage_user_identity), this.f58170a.get(R.id.tag_del_post_is_self), this.f58170a.get(R.id.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f58172a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f58173b;

        public o(a aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58173b = aVar;
            this.f58172a = sparseArray;
        }

        @Override // d.a.q0.h.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.f58173b.R != null) {
                    this.f58173b.R.a(new Object[]{this.f58172a.get(R.id.tag_del_post_id), this.f58172a.get(R.id.tag_manage_user_identity), this.f58172a.get(R.id.tag_del_post_is_self), this.f58172a.get(R.id.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(217651904, "Ld/a/q0/h2/k/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(217651904, "Ld/a/q0/h2/k/g/a;");
                return;
            }
        }
        s0 = TbadkCoreApplication.getInst().getListItemRule().c();
    }

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58145a = null;
        this.f58147c = null;
        this.f58148d = null;
        this.f58149e = null;
        this.f58150f = null;
        this.f58151g = null;
        this.f58152h = null;
        this.f58153i = null;
        this.j = null;
        this.k = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.C = null;
        this.E = null;
        this.G = null;
        this.H = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.O = true;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = 0;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.e0 = 2;
        this.f0 = 0;
        this.h0 = 0;
        this.i0 = true;
        this.m0 = d.a.p0.b.d.p0();
        this.p0 = new d.a.q0.h2.i.c(new h(this));
        this.q0 = new c(this);
        this.r0 = new d(this);
        this.f58150f = newSubPbActivity;
        this.M = onClickListener;
        this.f58145a = (SubPbView) LayoutInflater.from(newSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.f58147c = LayoutInflater.from(this.f58150f.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.f58146b = (LinearLayout) this.f58145a.findViewById(R.id.navigation_bar_group);
        this.X = (RelativeLayout) this.f58145a.findViewById(R.id.subpb_editor_tool_comment);
        TextView textView = (TextView) this.f58145a.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.W = textView;
        textView.setOnClickListener(this.M);
        this.Y = (ImageView) this.f58145a.findViewById(R.id.subpb_editor_tool_more_img);
        ImageView imageView = (ImageView) this.f58145a.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.Z = imageView;
        imageView.setOnClickListener(this.M);
        this.Y.setOnClickListener(this.M);
        this.f58151g = (NoNetworkView) this.f58145a.findViewById(R.id.view_no_network);
        V();
        U();
        this.j = (RelativeLayout) this.f58145a.findViewById(R.id.sub_pb_body_layout);
        this.f58148d = (BdTypeListView) this.f58145a.findViewById(R.id.new_sub_pb_list);
        ThreadSkinView threadSkinView = (ThreadSkinView) LayoutInflater.from(this.f58150f.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.A = threadSkinView;
        this.f58148d.addHeaderView(threadSkinView);
        this.f58148d.addHeaderView(this.f58147c);
        this.J = new TextView(newSubPbActivity.getActivity());
        this.J.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.f58148d.x(this.J, 0);
        this.f58145a.setTopView(this.J);
        this.f58145a.setNavigationView(this.f58146b);
        this.f58145a.setListView(this.f58148d);
        this.f58145a.setContentView(this.j);
        d.a.q0.h2.k.g.d dVar = new d.a.q0.h2.k.g.d(this.f58150f.getPageContext());
        this.C = dVar;
        dVar.v();
        this.H = this.C.b();
        this.f58148d.setNextPage(this.C);
        this.C.z(this.M);
        this.f58148d.setOnItemClickListener(this.r0);
        this.f58148d.setOnItemLongClickListener(this.q0);
        this.f58148d.setOnTouchListener(this.p0);
        d.a.q0.h2.p.i iVar = new d.a.q0.h2.p.i(newSubPbActivity.getPageContext());
        this.f58149e = iVar;
        iVar.n();
        this.f58149e.a(this.n0);
        this.f58149e.I(TbadkCoreApplication.getInst().getSkinType());
        this.P = (ProgressBar) this.f58145a.findViewById(R.id.progress);
        this.o0 = (MaskView) this.f58145a.findViewById(R.id.mask_view);
        this.c0 = this.f58145a.findViewById(R.id.view_comment_top_line);
        this.a0 = (LinearLayout) this.f58145a.findViewById(R.id.pb_editer_tool_comment_layout);
        HeadImageView headImageView = (HeadImageView) this.f58145a.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.b0 = headImageView;
        headImageView.setVisibility(0);
        this.b0.setIsRound(true);
        this.b0.setBorderWidth(d.a.d.e.p.l.g(this.f58150f, R.dimen.L_X01));
        this.b0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.b0.setDefaultBgResource(0);
        this.b0.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.b0.M(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        e0(TbadkCoreApplication.getInst().getSkinType());
        View view = this.f58147c;
        if (view != null) {
            view.setVisibility(4);
        }
        View a2 = d.a.p0.e.c.b().a(this.f58150f.getActivity(), 4);
        this.r = a2;
        if (a2 != null) {
            a2.setVisibility(8);
            this.o.addView(this.r, 3);
        }
        d.a.q0.h2.k.g.c cVar = new d.a.q0.h2.k.g.c(this.f58150f, this.f58148d);
        this.l0 = cVar;
        cVar.f(this.O);
        this.l0.d(this.M);
        this.l0.b();
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BlankView blankView = this.I;
            if (blankView == null) {
                return 0;
            }
            return blankView.getHeight();
        }
        return invokeV.intValue;
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.B == null) {
                this.B = new d.a.p0.s.f0.a(this.f58150f.getPageContext());
            }
            this.B.h(true);
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.p0.x.w.h hVar = this.S;
            if (hVar == null || hVar.a() == null) {
                return 0;
            }
            return this.S.a().getHeight();
        }
        return invokeV.intValue;
    }

    public final void B0(SparseArray<Object> sparseArray, d.a.q0.h.i iVar, UserData userData) {
        NewSubPbActivity newSubPbActivity;
        AntiData e0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, sparseArray, iVar, userData) == null) || (newSubPbActivity = this.f58150f) == null || sparseArray == null || this.f58147c == null) {
            return;
        }
        if (this.k0 == null) {
            this.k0 = new d.a.q0.h.j(newSubPbActivity.getPageContext(), this.f58147c, iVar, userData);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.g0;
        if (subPbModel != null && (e0 = subPbModel.e0()) != null && e0.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = e0.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        w0 w0Var = new w0();
        w0Var.j(sparseArray2);
        this.k0.B(new String[]{this.f58150f.getString(R.string.delete_thread_reason_1), this.f58150f.getString(R.string.delete_thread_reason_2), this.f58150f.getString(R.string.delete_thread_reason_3), this.f58150f.getString(R.string.delete_thread_reason_4), this.f58150f.getString(R.string.delete_thread_reason_5)});
        this.k0.A(w0Var);
        this.k0.D("4");
        this.k0.C(new o(this, sparseArray));
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.x : (View) invokeV.objValue;
    }

    public void C0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            W(NoDataViewFactory.e.d(null, this.f58150f.getResources().getString(R.string.refresh_view_title_text)));
            this.X.setVisibility(8);
        }
    }

    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public void D0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            if (z) {
                W(NoDataViewFactory.e.d("", str));
            } else {
                W(NoDataViewFactory.e.d(str, this.f58150f.getPageContext().getString(R.string.refresh_view_title_text)));
            }
            this.X.setVisibility(8);
        }
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f58147c : (View) invokeV.objValue;
    }

    public void E0(b.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, cVar, z) == null) {
            d.a.p0.s.s.b bVar = this.N;
            if (bVar != null) {
                bVar.e();
                this.N = null;
            }
            d.a.p0.s.s.b bVar2 = new d.a.p0.s.s.b(this.f58150f.getPageContext().getPageActivity());
            this.N = bVar2;
            if (z) {
                bVar2.j(new String[]{this.f58150f.getPageContext().getString(R.string.save_to_emotion)}, cVar);
            } else {
                bVar2.j(new String[]{this.f58150f.getPageContext().getString(R.string.save_to_emotion), this.f58150f.getPageContext().getString(R.string.save_to_local)}, cVar);
            }
            this.N.c(this.f58150f.getPageContext());
            this.N.m();
        }
    }

    public View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    public final void F0(SparseArray<Object> sparseArray) {
        NewSubPbActivity newSubPbActivity;
        AntiData e0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sparseArray) == null) || (newSubPbActivity = this.f58150f) == null || sparseArray == null || this.f58147c == null) {
            return;
        }
        if (this.j0 == null) {
            this.j0 = new d.a.q0.h.g(newSubPbActivity.getPageContext(), this.f58147c);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.g0;
        if (subPbModel != null && (e0 = subPbModel.e0()) != null && e0.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = e0.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        w0 w0Var = new w0();
        w0Var.j(sparseArray2);
        this.j0.x(new String[]{this.f58150f.getString(R.string.delete_thread_reason_1), this.f58150f.getString(R.string.delete_thread_reason_2), this.f58150f.getString(R.string.delete_thread_reason_3), this.f58150f.getString(R.string.delete_thread_reason_4), this.f58150f.getString(R.string.delete_thread_reason_5)});
        this.j0.w(w0Var);
        this.j0.z("4");
        this.j0.y(new n(this, sparseArray));
    }

    public ListView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f58148d : (ListView) invokeV.objValue;
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f58148d.setNextPage(this.C);
            this.C.O();
        }
    }

    public View H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.H : (View) invokeV.objValue;
    }

    public void H0(r rVar, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{rVar, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || rVar == null) {
            return;
        }
        if (this.i0 && (view = this.f58147c) != null) {
            view.setVisibility(8);
            this.f58148d.removeHeaderView(this.f58147c);
            this.e0 = 1;
        }
        this.V = rVar;
        if (rVar.i() != null) {
            this.V.i().m0 = true;
        }
        View view2 = this.f58147c;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (rVar.l() != null && rVar.l().r2()) {
            this.n.setText(R.string.view_original);
        } else {
            this.n.setText(R.string.view_subject);
        }
        if (rVar.i() != null) {
            int A = rVar.i().A();
            this.T = A;
            if (A > 0) {
                this.k.setCenterTextTitle(String.format(this.f58150f.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.T)));
                NewSubPbActivity newSubPbActivity = this.f58150f;
                if (newSubPbActivity != null) {
                    this.W.setText(newSubPbActivity.getReplyHint());
                }
            } else {
                this.k.setCenterTextTitle(this.f58150f.getResources().getString(R.string.local_floor_reply));
            }
            String str = this.f58150f.isFromPb() ? "PB" : null;
            if (rVar.i().L() != null) {
                this.A.setData(this.f58150f.getPageContext(), rVar.i().L(), d.a.q0.h3.j0.a.a("PB", "c0132", rVar.d().getId(), rVar.d().getName(), rVar.l().d0(), str));
            } else {
                this.A.setData(null, null, null);
            }
        }
        if (rVar.o()) {
            this.C.O();
            this.l0.g(true);
        } else {
            this.C.f();
            this.l0.g(false);
        }
        ArrayList<PostData> k2 = rVar.k();
        this.U = k2;
        if (k2 == null || k2.size() <= s0) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            int size = this.U.size() - s0;
            j0(size);
            int firstVisiblePosition = this.f58148d.getFirstVisiblePosition() - size;
            View childAt = this.f58148d.getChildAt(0);
            i3 = size;
            i4 = firstVisiblePosition;
            i5 = childAt == null ? 0 : childAt.getTop();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.U);
        if (ListUtils.isEmpty(this.U)) {
            this.f58148d.setNextPage(null);
            if (this.i0) {
                arrayList.add(0, new d.a.q0.h2.k.g.f.a());
            }
        } else {
            this.f58148d.setNextPage(this.C);
        }
        d.a.q0.h2.k.g.f.b bVar = new d.a.q0.h2.k.g.f.b();
        bVar.c(rVar.m());
        arrayList.add(0, bVar);
        if (this.i0) {
            arrayList.add(0, rVar.i());
        }
        NewSubPbActivity newSubPbActivity2 = this.f58150f;
        if (newSubPbActivity2 != null && newSubPbActivity2.getSubPbModel() != null) {
            this.o0.setVisibility(this.f58150f.getSubPbModel().F0() ? 0 : 8);
        }
        this.l0.e(this.V.l(), arrayList);
        y(rVar, rVar.i(), rVar.e(), rVar.f(), i2, z);
        if (i3 > 0) {
            this.f58148d.setSelectionFromTop(i4, i5);
        } else if (z2 && !d.a.d.e.p.k.isEmpty(this.f58150f.getSubPbModel().m0())) {
            String m0 = this.f58150f.getSubPbModel().m0();
            int i6 = 0;
            while (true) {
                if (i6 < arrayList.size()) {
                    if ((arrayList.get(i6) instanceof PostData) && m0.equals(((PostData) arrayList.get(i6)).E())) {
                        this.f58148d.post(new f(this, i6));
                        break;
                    }
                    i6++;
                } else {
                    break;
                }
            }
        }
        if (this.V.j() > 1) {
            this.f58148d.setPullRefresh(this.f58149e);
            this.f58145a.setEnableDragExit(false);
            return;
        }
        this.f58148d.setPullRefresh(null);
        this.f58145a.setEnableDragExit(true);
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            NavigationBar navigationBar = this.k;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l0.a() : invokeV.booleanValue;
    }

    public d0 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.d0 : (d0) invokeV.objValue;
    }

    public final void J0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, metaData) == null) || metaData == null) {
            return;
        }
        String name_show = metaData.getName_show();
        if (j0.b(name_show) + (!StringUtils.isNull(metaData.getSealPrefix()) ? d.a.d.e.p.k.byteLength(metaData.getSealPrefix()) + 2 : 0) > 14) {
            String k2 = j0.k(name_show, 0, 14);
            if (k2.length() == name_show.length()) {
                name_show = k2;
            } else {
                name_show = k2 + StringHelper.STRING_MORE;
            }
        }
        if (!StringUtils.isNull(metaData.getSealPrefix())) {
            this.q.setText(Q(metaData.getSealPrefix(), name_show));
        } else {
            this.q.setText(name_show);
        }
        if (metaData.getAlaUserData() != null && this.r != null) {
            if (metaData.getAlaUserData().anchor_live == 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                d.a.p0.e.b bVar = new d.a.p0.e.b();
                bVar.f52498a = metaData.getAlaUserData();
                bVar.f52499b = 4;
                this.r.setTag(bVar);
            }
        }
        if (metaData.isBigV()) {
            SkinManager.setViewTextColor(this.q, R.color.cp_cont_r);
        } else if (d.a.p0.b.d.J()) {
            d.a.p0.s.u.c.d(this.q).t(R.color.CAM_X0108);
        } else {
            d.a.p0.s.u.c.d(this.q).t(R.color.CAM_X0106);
        }
        this.p.setVisibility(0);
        this.p.setUserId(metaData.getUserId());
        this.p.setUserName(metaData.getUserName());
        this.p.setDefaultResource(R.drawable.transparent_bg);
        UtilHelper.showHeadImageViewBigV(this.p, metaData);
        this.p.M(metaData.getAvater(), 28, false);
        this.o.setTag(R.id.tag_user_id, metaData.getUserId());
        this.o.setTag(R.id.tag_user_name, metaData.getUserName());
        this.o.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
    }

    public ImageView K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.Z : (ImageView) invokeV.objValue;
    }

    public void K0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (bdTypeListView = this.f58148d) == null) {
            return;
        }
        this.f0 = bdTypeListView.getLastVisiblePosition();
    }

    public ImageView L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.Y : (ImageView) invokeV.objValue;
    }

    public void L0(boolean z) {
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (d0Var = this.d0) == null || d0Var.z() == null) {
            return;
        }
        if (z) {
            this.d0.z().setText(R.string.remove_mark);
        } else {
            this.d0.z().setText(R.string.mark);
        }
    }

    public MorePopupWindow M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.E : (MorePopupWindow) invokeV.objValue;
    }

    public TextView N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.W : (TextView) invokeV.objValue;
    }

    public TextView O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.w : (TextView) invokeV.objValue;
    }

    public View P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f58145a : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder Q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return d.a.q0.a0.m.h(this.f58150f.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void R() {
        d.a.p0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (aVar = this.B) == null) {
            return;
        }
        aVar.h(false);
    }

    public void S() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (noDataView = this.f58152h) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.f58148d.setVisibility(0);
        this.X.setVisibility(0);
        this.f58145a.setOnTouchListener(null);
    }

    public void T() {
        d.a.p0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || this.W == null || (hVar = this.S) == null) {
            return;
        }
        if (hVar.w()) {
            this.W.setText(R.string.draft_to_send);
        } else {
            this.W.setText(this.f58150f.getReplyHint());
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f58147c.findViewById(R.id.subpb_head_user_info_root);
            this.o = linearLayout;
            linearLayout.setOnClickListener(this.M);
            HeadImageView headImageView = (HeadImageView) this.f58147c.findViewById(R.id.photo);
            this.p = headImageView;
            headImageView.setRadius(d.a.d.e.p.l.g(this.f58150f.getActivity(), R.dimen.tbds45));
            this.p.setClickable(false);
            this.q = (TextView) this.f58147c.findViewById(R.id.user_name);
            ImageView imageView = (ImageView) this.f58147c.findViewById(R.id.user_rank);
            this.s = imageView;
            imageView.setVisibility(8);
            this.t = (TextView) this.f58147c.findViewById(R.id.floor_owner);
            TextView textView = (TextView) this.f58147c.findViewById(R.id.see_subject);
            this.n = textView;
            textView.setOnClickListener(this.M);
            this.u = (TextView) this.f58147c.findViewById(R.id.floor);
            this.v = (TextView) this.f58147c.findViewById(R.id.time);
            EllipsizeRichTextView ellipsizeRichTextView = (EllipsizeRichTextView) this.f58147c.findViewById(R.id.content_text);
            this.w = ellipsizeRichTextView;
            ellipsizeRichTextView.setOnClickListener(this.M);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0105);
            this.w.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            this.w.setLineSpacing(0.0f, 1.25f);
            TbImageView tbImageView = (TbImageView) this.f58147c.findViewById(R.id.sub_pb_image);
            this.x = tbImageView;
            tbImageView.setOnClickListener(this.M);
            this.z = (TextView) this.f58147c.findViewById(R.id.advert);
            this.y = (PlayVoiceBntNew) this.f58147c.findViewById(R.id.voice_btn);
            this.f58147c.setOnTouchListener(this.p0);
            this.f58147c.setOnClickListener(this.M);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            int g2 = d.a.d.e.p.l.g(this.f58150f.getPageContext().getPageActivity(), R.dimen.ds88);
            int g3 = d.a.d.e.p.l.g(this.f58150f.getPageContext().getPageActivity(), R.dimen.ds2);
            NavigationBar navigationBar = (NavigationBar) this.f58145a.findViewById(R.id.view_navigation_bar);
            this.k = navigationBar;
            this.m = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
            ImageView backImageView = this.k.getBackImageView();
            this.l = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.height = g2;
                layoutParams.width = g2;
                layoutParams.leftMargin = g3;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.m;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.width = g2;
                layoutParams2.height = g2;
                this.m.setLayoutParams(layoutParams2);
            }
            this.k.hideBottomLine();
        }
    }

    public final void W(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f58150f.getPageContext().getString(R.string.refresh_view_button_text), this.f58153i));
            if (this.f58152h == null) {
                Activity pageActivity = this.f58150f.getPageContext().getPageActivity();
                this.f58152h = NoDataViewFactory.a(pageActivity, this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, d.a.d.e.p.l.g(pageActivity, R.dimen.ds250)), eVar, a2);
            }
            this.f58148d.setVisibility(8);
            this.P.setVisibility(8);
            this.S.y();
            SkinManager.setBackgroundColor(this.f58152h, R.color.CAM_X0201);
            this.f58152h.setClickable(true);
            this.f58152h.setTextOption(eVar);
            this.f58152h.f(this.f58150f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f58152h.setVisibility(0);
        }
    }

    public void X(d.a.p0.x.w.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, hVar) == null) || hVar == null || hVar.a() == null) {
            return;
        }
        this.S = hVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.j.addView(hVar.a(), layoutParams);
        this.S.R(new b(this));
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f58145a.e() : invokeV.booleanValue;
    }

    public final boolean Z(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048613, this, z)) == null) {
            SubPbModel subPbModel = this.g0;
            if (subPbModel == null || subPbModel.g0() == null) {
                return false;
            }
            if (this.g0.y0() != 0) {
                return false;
            }
            r rVar = this.V;
            return (rVar == null || rVar.l() == null || this.V.l().H() == null || !TextUtils.equals(this.V.l().H().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
        }
    }

    public void a0() {
        d.a.q0.h2.k.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (cVar = this.l0) == null) {
            return;
        }
        cVar.c();
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            SubPbView subPbView = this.f58145a;
            if (subPbView != null) {
                subPbView.f();
            }
            d.a.p0.x.w.h hVar = this.S;
            if (hVar != null) {
                hVar.D();
            }
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
        }
    }

    public void e0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.f58150f.getLayoutMode().k(i2 == 1);
            this.f58150f.getLayoutMode().j(this.f58145a);
            this.f58150f.getLayoutMode().j(this.f58147c);
            SkinManager.setBackgroundColor(this.f58145a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            this.k.onChangeSkinType(this.f58150f.getPageContext(), i2);
            SubPbModel subPbModel = this.g0;
            if (subPbModel != null && subPbModel.E0()) {
                WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            TextView textView = this.n;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.goto_see_subject_color);
            }
            this.f58151g.c(this.f58150f.getPageContext(), i2);
            this.f58150f.getLayoutMode().j(this.H);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0105);
            this.w.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            d.a.p0.x.w.h hVar = this.S;
            if (hVar != null && hVar.a() != null) {
                this.S.a().w(i2);
            }
            this.C.d(i2);
            this.y.b();
            SkinManager.setViewTextColor(this.W, R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0302);
            if (d.a.p0.b.d.J()) {
                d.a.p0.s.u.c.d(this.q).y(R.string.F_X02);
                d.a.p0.s.u.c.d(this.q).t(R.color.CAM_X0108);
            } else {
                d.a.p0.s.u.c.d(this.q).y(R.string.F_X01);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0106);
            }
            this.W.setAlpha(0.95f);
            if (this.D != null) {
                d.a.p0.u0.a.a(this.f58150f.getPageContext(), this.D);
            }
            d.a.q0.h2.k.g.c cVar = this.l0;
            if (cVar != null) {
                cVar.c();
            }
            this.f58150f.getLayoutMode().j(this.F);
            SkinManager.setBackgroundColor(this.c0, R.color.CAM_X0203);
            this.b0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.a0.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.d.e.p.l.g(this.f58150f, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048620, this) != null) || this.f58150f.isPaused()) {
        }
    }

    public void g0(int i2, String str, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            int i4 = R.string.del_all_post_confirm;
            if (i3 == 1002 && !z) {
                i4 = R.string.report_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z) {
                    i4 = R.string.report_thread_confirm;
                } else {
                    i4 = R.string.del_thread_confirm;
                }
            }
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f58150f.getPageContext().getPageActivity());
            this.L = aVar;
            aVar.setMessageId(i4);
            this.L.setYesButtonTag(sparseArray);
            this.L.setPositiveButton(R.string.dialog_ok, new l(this, sparseArray));
            this.L.setNegativeButton(R.string.dialog_cancel, new m(this));
            this.L.setCancelable(true);
            this.L.create(this.f58150f.getPageContext());
            if (z2) {
                this.L.show();
            } else if (z) {
                this.L.show();
            } else if (1 == this.g0.i0()) {
                d.a.q0.h.i iVar = new d.a.q0.h.i(this.g0.i0(), this.g0.h0(), this.g0.l0());
                iVar.i(this.V.d().getId(), this.V.d().getName());
                iVar.h(this.g0.j0());
                iVar.j(this.g0.z0());
                UserData userData = new UserData();
                userData.setIsManager(this.g0.n0());
                B0(sparseArray, iVar, userData);
            } else {
                F0(sparseArray);
            }
        }
    }

    public void h0(SparseArray<Object> sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048622, this, sparseArray, z) == null) {
            boolean z2 = true;
            if (this.K == null) {
                Dialog dialog = new Dialog(this.f58150f.getPageContext().getPageActivity(), R.style.common_alert_dialog);
                this.K = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.K.setCancelable(true);
                this.F = LayoutInflater.from(this.f58150f.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
                this.f58150f.getLayoutMode().j(this.F);
                this.K.setContentView(this.F);
                WindowManager.LayoutParams attributes = this.K.getWindow().getAttributes();
                attributes.width = (int) (d.a.d.e.p.l.k(this.f58150f.getPageContext().getPageActivity()) * 0.9d);
                this.K.getWindow().setAttributes(attributes);
            }
            TextView textView = (TextView) this.K.findViewById(R.id.del_post_btn);
            TextView textView2 = (TextView) this.K.findViewById(R.id.forbid_user_btn);
            TextView textView3 = (TextView) this.K.findViewById(R.id.disable_reply_btn);
            int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
                SparseArray sparseArray2 = (SparseArray) textView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    textView.setTag(sparseArray2);
                }
                textView.setVisibility(0);
                int i2 = R.id.tag_del_post_id;
                sparseArray2.put(i2, sparseArray.get(i2));
                int i3 = R.id.tag_del_post_type;
                sparseArray2.put(i3, sparseArray.get(i3));
                int i4 = R.id.tag_del_post_is_self;
                sparseArray2.put(i4, sparseArray.get(i4));
                int i5 = R.id.tag_manage_user_identity;
                sparseArray2.put(i5, sparseArray.get(i5));
                textView.setOnClickListener(new i(this));
            } else {
                textView.setVisibility(8);
            }
            if ("".equals(sparseArray.get(R.id.tag_forbid_user_name)) && "".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                textView2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) textView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    textView2.setTag(sparseArray3);
                }
                textView2.setVisibility(0);
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
                textView2.setOnClickListener(new j(this));
            }
            if (!(((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) ? false : false)) {
                textView3.setVisibility(8);
            } else {
                SparseArray sparseArray4 = (SparseArray) textView3.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    textView3.setTag(sparseArray4);
                }
                textView3.setVisibility(0);
                if (z) {
                    textView3.setText(R.string.un_mute);
                } else {
                    textView3.setText(R.string.mute);
                }
                int i11 = R.id.tag_is_mem;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = R.id.tag_user_mute_mute_userid;
                sparseArray4.put(i12, sparseArray.get(i12));
                int i13 = R.id.tag_user_mute_mute_username;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = R.id.tag_user_mute_post_id;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = R.id.tag_user_mute_thread_id;
                sparseArray4.put(i15, sparseArray.get(i15));
                int i16 = R.id.tag_user_mute_mute_nameshow;
                sparseArray4.put(i16, sparseArray.get(i16));
                textView3.setOnClickListener(new k(this, z));
            }
            d.a.d.e.m.g.j(this.K, this.f58150f.getPageContext());
        }
    }

    public void i0(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        h0(sparseArray, false);
    }

    public final void j0(int i2) {
        ArrayList<PostData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048624, this, i2) == null) || (arrayList = this.U) == null) {
            return;
        }
        if (arrayList.size() <= i2) {
            this.U.clear();
        }
        int i3 = 0;
        Iterator<PostData> it = this.U.iterator();
        while (it.hasNext()) {
            it.next();
            i3++;
            it.remove();
            if (i3 >= i2) {
                return;
            }
        }
    }

    public void k0(NewSubPbActivity.q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, q0Var) == null) {
            this.R = q0Var;
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.f58148d.setVisibility(0);
            this.P.setVisibility(8);
            this.C.f();
        }
    }

    public void m0(NewSubPbActivity.q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, q0Var) == null) {
            this.Q = q0Var;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.i0 = z;
        }
    }

    public void o0(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, gVar) == null) {
            this.n0 = gVar;
            d.a.q0.h2.p.i iVar = this.f58149e;
            if (iVar != null) {
                iVar.a(gVar);
            }
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.f58148d.setVisibility(0);
            this.P.setVisibility(8);
            this.C.P();
        }
    }

    public void q0(SubPbModel subPbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, subPbModel) == null) {
            this.g0 = subPbModel;
        }
    }

    public void r(boolean z) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048632, this, z) == null) || (subPbModel = this.g0) == null || !subPbModel.D0() || z) {
            return;
        }
        this.k.setIsClose(true);
        this.k.setIsCorner(true);
        this.k.isShowBottomLine(true);
        this.k.setBottomLineHeight(3);
        this.k.setStatusBarVisibility(8);
        this.I = new BlankView(this.f58150f.getPageContext().getPageActivity());
        if (this.g0.E0()) {
            this.h0 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds562) + UtilHelper.getStatusBarHeight();
        } else {
            this.h0 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
        }
        this.f58146b.addView(this.I, 0, new LinearLayout.LayoutParams(-1, this.h0));
        this.I.setVisibility(0);
        this.I.setOnClickListener(new e(this));
        this.f58145a.setBlankView(this.I);
    }

    public void r0(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, zVar) == null) {
            this.l0.i(zVar);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            v0(this.f58150f);
            this.f58148d.setNextPage(this.C);
        }
    }

    public void s0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onLongClickListener) == null) {
            this.l0.h(onLongClickListener);
        }
    }

    public void t(boolean z) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048636, this, z) == null) || (headImageView = this.b0) == null) {
            return;
        }
        headImageView.M(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
    }

    public void t0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, onClickListener) == null) {
            this.f58153i = onClickListener;
        }
    }

    public void u() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || this.g0 == null) {
            return;
        }
        if ((!I0() && (view = this.H) != null && view.isShown()) || ListUtils.isEmpty(this.U)) {
            this.g0.U0(false);
        } else {
            this.g0.U0(true);
        }
    }

    public void u0(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onScrollListener) == null) {
            this.f58148d.setOnScrollListener(onScrollListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x024c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(PostData postData, int i2, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048640, this, postData, i2, sparseArray) == null) || postData == null) {
            return;
        }
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        boolean z6 = true;
        if (i2 != 0) {
            if (i2 != 3) {
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            String userId2 = postData.t().getUserId();
            if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = false;
            }
            if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                z = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        r rVar = this.V;
        if (rVar != null && rVar.l() != null && this.V.l().H() != null && postData.t() != null) {
            String userId3 = this.V.l().H().getUserId();
            String userId4 = postData.t().getUserId();
            if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                    userId = postData.t().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = true;
                    }
                    int i3 = postData.A() == 1 ? 0 : 1;
                    if (z) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                        z5 = true;
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                        z5 = false;
                    }
                    if (z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.TRUE);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(R.id.tag_del_post_id, postData.E());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.FALSE);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                        z6 = z5;
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                    if (z) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                        }
                        if (this.V.l() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.V.l().d0());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.E());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(R.id.tag_del_post_id, postData.E());
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.W()));
                        return;
                    }
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    return;
                }
                z2 = true;
                z3 = false;
                z4 = true;
                userId = postData.t().getUserId();
                if (userId != null) {
                    z2 = true;
                    z4 = true;
                }
                if (postData.A() == 1) {
                }
                if (z) {
                }
                if (z2) {
                }
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
                sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                if (z) {
                }
                if (z3) {
                }
                if (z2) {
                }
            }
        }
        z3 = false;
        z4 = false;
        userId = postData.t().getUserId();
        if (userId != null) {
        }
        if (postData.A() == 1) {
        }
        if (z) {
        }
        if (z2) {
        }
        sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
        if (z) {
        }
        if (z3) {
        }
        if (z2) {
        }
    }

    public void v0(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, pVar) == null) {
            this.f58148d.setOnSrollToBottomListener(pVar);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            MorePopupWindow morePopupWindow = this.E;
            if (morePopupWindow != null) {
                d.a.d.e.m.g.d(morePopupWindow, this.f58150f.getPageContext().getPageActivity());
            }
            d.a.p0.s.s.b bVar = this.G;
            if (bVar != null) {
                bVar.e();
            }
            d.a.p0.s.s.a aVar = this.L;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.K;
            if (dialog != null) {
                d.a.d.e.m.g.b(dialog, this.f58150f.getPageContext());
            }
            ProgressBar progressBar = this.P;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            d0 d0Var = this.d0;
            if (d0Var != null) {
                d0Var.dismiss();
            }
        }
    }

    public void w0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, view) == null) {
            this.D = view;
        }
    }

    public final void x(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048644, this, z) == null) || (bdTypeListView = this.f58148d) == null) {
            return;
        }
        if (!z) {
            bdTypeListView.setEnabled(z);
        } else {
            bdTypeListView.postDelayed(new RunnableC1436a(this, z), 10L);
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            this.P.setVisibility(0);
        }
    }

    public void y(r rVar, PostData postData, boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{rVar, postData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) || postData == null || this.i0) {
            return;
        }
        if (!StringUtils.isNull(postData.z())) {
            this.x.setVisibility(0);
            this.x.M(postData.z(), 10, true);
        } else {
            this.x.setVisibility(8);
        }
        d.a.q0.h3.h0.i v = postData.v();
        if (v != null && v.f58555a) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
        SparseArray<Object> sparseArray = (SparseArray) this.f58147c.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f58147c.setTag(sparseArray);
        }
        sparseArray.clear();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
        v(postData, i2, sparseArray);
        this.u.setText((CharSequence) null);
        this.q.setText((CharSequence) null);
        this.t.setVisibility(8);
        if (!this.i0) {
            J0(postData.t());
            if (z) {
                this.t.setVisibility(0);
                SkinManager.setViewTextColor(this.t, R.color.CAM_X0302);
            }
        }
        this.v.setText(StringHelper.getFormatTime(postData.R()));
        String format = String.format(this.f58150f.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.A()));
        if (rVar.l() != null && rVar.l().r2()) {
            this.u.setText((CharSequence) null);
        } else {
            this.u.setText(format);
        }
        postData.t().getUserTbVipInfoData();
        boolean y0 = y0(this.w, postData.K());
        if (StringUtils.isNull(postData.z()) && !y0 && postData.V() != null) {
            this.y.setVisibility(0);
            this.y.setTag(postData.V());
            return;
        }
        this.y.setVisibility(8);
    }

    public final boolean y0(TextView textView, TbRichText tbRichText) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048647, this, textView, tbRichText)) == null) {
            if (textView != null && tbRichText != null && tbRichText.y() != null) {
                TbRichTextData tbRichTextData = new TbRichTextData(1);
                Iterator<TbRichTextData> it = tbRichText.y().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        int type = next.getType();
                        if (type != 1) {
                            if (type != 2) {
                                if (type == 17) {
                                    String str = next.y().mGifInfo.mSharpText;
                                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                                        String substring = str.substring(2, str.length() - 1);
                                        tbRichTextData.w(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                                    }
                                } else if (type != 18) {
                                }
                            }
                            tbRichTextData.N(true);
                            textView.setMovementMethod(d.a.q0.z3.c.a());
                        } else {
                            tbRichTextData.w(next.E());
                        }
                    }
                }
                if (!tbRichTextData.J()) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                try {
                    if (tbRichTextData.E() == null || tbRichTextData.E().length() <= 0) {
                        return false;
                    }
                    textView.setText(tbRichTextData.E());
                    return true;
                } catch (Exception unused) {
                    textView.setText("");
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void z(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            ProgressBar progressBar = this.P;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (z && z2) {
                NewSubPbActivity newSubPbActivity = this.f58150f;
                newSubPbActivity.showToast(newSubPbActivity.getResources().getString(R.string.delete_success));
            } else if (str == null || !z2) {
            } else {
                this.f58150f.showToast(str);
            }
        }
    }

    public void z0(PostData postData) {
        int i2;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048649, this, postData) == null) || postData == null) {
            return;
        }
        postData.n0(true);
        PostData postData2 = new PostData();
        postData2.r0(52);
        if (!I0() && (view = this.H) != null && view.isShown()) {
            i2 = (this.f0 - this.e0) - 1;
        } else {
            i2 = this.f0 - this.e0;
        }
        int count = ListUtils.getCount(this.U);
        if (i2 > count) {
            i2 = count;
        }
        ArrayList arrayList = new ArrayList(ListUtils.subList(this.U, 0, i2));
        ListUtils.add(arrayList, postData2);
        ListUtils.add(arrayList, postData);
        this.f58148d.smoothScrollToPosition(this.f0 + 2);
        this.f58148d.setNextPage(null);
    }
}
