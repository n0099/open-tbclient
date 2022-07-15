package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.ShareForumMsgData;
import com.baidu.tieba.im.data.ShareThreadMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import com.baidu.tieba.im.widget.sharecard.ChatShareCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class g47 extends a9<MsglistActivity<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AbsMsglistView.j A;
    public int B;
    public hf b;
    public Cif c;
    public long d;
    public Calendar e;
    public int f;
    public long g;
    public Long h;
    public TextView i;
    public TbRichTextView j;
    public ChatVoiceView k;
    public GifView l;
    public Invite2GroupView m;
    public ShareFromPBView n;
    public ShareFromFrsView o;
    public ShareFromGameCenter p;
    public ChatImageWithTailView q;
    public ChatShareCard r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public ArrayList<ReportPrivateMsgData> w;
    public int x;
    public TbCheckBox y;
    public LinearLayout z;

    /* loaded from: classes6.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public a(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                g47 g47Var = this.a;
                g47Var.c.m(view2, 10, g47Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public b(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g47 g47Var = this.a;
                g47Var.b.h(view2, 15, g47Var.f, 0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public c(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                g47 g47Var = this.a;
                g47Var.c.m(view2, 15, g47Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public d(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g47 g47Var = this.a;
                g47Var.b.h(view2, 11, g47Var.f, 0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public e(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g47 g47Var = this.a;
                g47Var.b.h(view2, 12, g47Var.f, 0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public f(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                g47 g47Var = this.a;
                g47Var.c.m(view2, 11, g47Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public g(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                g47 g47Var = this.a;
                g47Var.c.m(view2, 17, g47Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMessage a;
        public final /* synthetic */ g47 b;

        public h(g47 g47Var, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g47Var;
            this.a = chatMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(Boolean.valueOf(!((Boolean) view2.getTag()).booleanValue()));
                if (!((Boolean) view2.getTag()).booleanValue()) {
                    int i = 0;
                    this.b.y.setChecked(false);
                    while (true) {
                        if (i < this.b.w.size()) {
                            if (this.b.w.get(i) != null && TextUtils.equals(String.valueOf(this.a.getMsgId()), this.b.w.get(i).getMsgId())) {
                                this.b.w.remove(i);
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                    if (this.b.A != null) {
                        this.b.A.a(this.b.w, true);
                    }
                } else if (this.b.w.size() < 20) {
                    this.b.y.setChecked(true);
                    this.b.w.add(new ReportPrivateMsgData(String.valueOf(this.a.getMsgId()), jp8.b(this.b.mContext, this.a), String.valueOf(this.a.getTime())));
                    if (this.b.A != null) {
                        this.b.A.a(this.b.w, true);
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_REPORT_PRIVATE_MSG_CHANGE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921670, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public i(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TbRichTextView tbRichTextView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (tbRichTextView = this.a.j) == null || tbRichTextView.getTextView() == null) {
                return;
            }
            CharSequence text = this.a.j.getTextView().getText();
            if (TextUtils.isEmpty(text)) {
                return;
            }
            if (text.toString().contains("删贴") || text.toString().contains("删除")) {
                if (text.toString().contains("http://") || text.toString().contains("https://")) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) h9.a(view2.getContext()), new String[]{"https://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1"});
                    xt4.k().u(xt4.o("key_person_post_recycle_bin_red_tip_show"), false);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SITE_SERVICE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public j(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                g47 g47Var = this.a;
                g47Var.c.m(view2, 5, g47Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public k(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g47 g47Var = this.a;
                g47Var.b.h(view2, 4, g47Var.f, 0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public l(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                g47 g47Var = this.a;
                g47Var.c.m(view2, 4, g47Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public m(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g47 g47Var = this.a;
                g47Var.b.h(view2, 13, g47Var.f, 0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public n(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                g47 g47Var = this.a;
                g47Var.c.m(view2, 3, g47Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public o(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g47 g47Var = this.a;
                g47Var.b.h(view2, 7, g47Var.f, 0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public p(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                g47 g47Var = this.a;
                g47Var.c.m(view2, 7, g47Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g47 a;

        public q(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g47Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g47 g47Var = this.a;
                g47Var.b.h(view2, 10, g47Var.f, 0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public r(g47 g47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a = z;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g47(TbPageContext<MsglistActivity<?>> tbPageContext, int i2) {
        super(tbPageContext, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d9) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.f = 0;
        this.g = 0L;
        this.h = null;
        this.s = true;
        this.t = false;
        this.u = false;
        this.v = false;
        this.B = 3;
        this.d = 0L;
        this.e = null;
        this.mContext = tbPageContext;
    }

    public void A(Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cif) == null) {
            this.c = cif;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f = i2;
        }
    }

    public void C(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, chatMessage) == null) {
        }
    }

    public void D(ArrayList<ReportPrivateMsgData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.w = arrayList;
            AbsMsglistView.j jVar = this.A;
            if (jVar != null) {
                jVar.a(arrayList, false);
            }
        }
    }

    public void E(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.x = i2;
        }
    }

    public void F(ChatMessage chatMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, chatMessage, z) == null) {
            i47.a(this.mContext.getContext(), this.l, chatMessage, z);
        }
    }

    public void G(View view2, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, view2, chatMessage, str) == null) {
            i47.b(this.mContext.getContext(), view2, this.n, this.o, this.p, chatMessage, str);
        }
    }

    public void H(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, chatMessage) == null) {
            MsgCacheData cacheData = chatMessage.getCacheData();
            if (cacheData == null) {
                MsgCacheData msgCacheData = new MsgCacheData();
                msgCacheData.setVoice_status(1);
                chatMessage.setCacheData(msgCacheData);
            } else if (cacheData.getVoice_status() == 0) {
                cacheData.setVoice_status(1);
            }
            ShareForumMsgData b2 = a97.b(chatMessage);
            this.r.setVisibility(0);
            this.r.setCurrentCardType((short) 33);
            this.r.a(b2);
        }
    }

    public void I(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatMessage) == null) {
            boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
            boolean p2 = p(chatMessage.getTime());
            if (!z && !p2) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                this.i.setText(n(chatMessage.getTime()));
            }
            if (z || !p2) {
                return;
            }
            MsgCacheData cacheData = chatMessage.getCacheData();
            if (cacheData == null) {
                MsgCacheData msgCacheData = new MsgCacheData();
                msgCacheData.setIs_show_time(1);
                chatMessage.setCacheData(msgCacheData);
                return;
            }
            cacheData.setIs_show_time(1);
        }
    }

    public void J(View view2, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, view2, chatMessage, str) == null) {
            d9<T> d9Var = this.mContext;
            i47.c((TbPageContext) d9Var, d9Var.getContext(), view2, this.m, chatMessage, str);
        }
    }

    public void L(View view2, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, view2, chatMessage, str) == null) {
            i47.d(this.mContext.getContext(), view2, this.q, chatMessage, this.g, str);
        }
    }

    public void M(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, chatMessage, str) == null) {
            i47.e(this.j, chatMessage, str, this.x);
            if (chatMessage == null || chatMessage.getContent() == null) {
                return;
            }
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.j.setContentDescription(stringBuffer.toString());
            this.j.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    public void N(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, chatMessage) == null) {
            MsgCacheData cacheData = chatMessage.getCacheData();
            if (cacheData == null) {
                MsgCacheData msgCacheData = new MsgCacheData();
                msgCacheData.setVoice_status(1);
                chatMessage.setCacheData(msgCacheData);
            } else if (cacheData.getVoice_status() == 0) {
                cacheData.setVoice_status(1);
            }
            ShareThreadMsgData c2 = a97.c(chatMessage);
            this.r.setVisibility(0);
            this.r.setCurrentCardType((short) 32);
            this.r.a(c2);
        }
    }

    public void O(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, chatMessage, str) == null) {
            i47.f(this.mContext.getContext(), this.k, chatMessage, str);
        }
    }

    public void P(ChatMessage chatMessage) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, chatMessage) == null) {
            if (this.w == null) {
                this.w = new ArrayList<>();
            }
            if (this.v) {
                this.z.setVisibility(0);
                int i2 = 0;
                while (true) {
                    if (i2 >= this.w.size()) {
                        z = false;
                        break;
                    }
                    ReportPrivateMsgData reportPrivateMsgData = this.w.get(i2);
                    if (reportPrivateMsgData != null && TextUtils.equals(String.valueOf(chatMessage.getMsgId()), reportPrivateMsgData.getMsgId())) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                this.z.setTag(Boolean.valueOf(z));
                this.y.setTagData(new r(this));
                this.y.setBackgroundDrawableIdIsWebP(true);
                this.y.setClickable(false);
                this.y.setBackgroundDrawableId(R.drawable.obfuscated_res_0x7f0809b7, R.drawable.obfuscated_res_0x7f0809b6);
                this.y.setChecked(((Boolean) this.z.getTag()).booleanValue());
                this.z.setOnClickListener(new h(this, chatMessage));
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public final String n(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
            if (j2 < 1000) {
                return "";
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2 * 1000);
            Calendar calendar2 = this.e;
            if (calendar2 != null && calendar2.get(1) == calendar.get(1) && this.e.get(6) == calendar.get(6)) {
                return oi.getDateStringHm(calendar.getTime());
            }
            return oi.getDateStringMdHm(calendar.getTime());
        }
        return (String) invokeJ.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.i = (TextView) a(R.id.obfuscated_res_0x7f091fa6);
            TbRichTextView tbRichTextView = (TbRichTextView) a(R.id.obfuscated_res_0x7f091fa5);
            this.j = tbRichTextView;
            tbRichTextView.setLinkTextColor(-14845754);
            this.j.setFaceSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X04));
            this.q = (ChatImageWithTailView) a(R.id.obfuscated_res_0x7f090e90);
            this.y = (TbCheckBox) a(R.id.obfuscated_res_0x7f090612);
            this.z = (LinearLayout) a(R.id.obfuscated_res_0x7f09134c);
            this.m = (Invite2GroupView) a(R.id.obfuscated_res_0x7f091211);
            this.n = (ShareFromPBView) a(R.id.obfuscated_res_0x7f091214);
            this.o = (ShareFromFrsView) a(R.id.obfuscated_res_0x7f091212);
            this.p = (ShareFromGameCenter) a(R.id.obfuscated_res_0x7f091213);
            ChatVoiceView chatVoiceView = (ChatVoiceView) a(R.id.obfuscated_res_0x7f091215);
            this.k = chatVoiceView;
            chatVoiceView.setClickable(true);
            ChatVoiceView chatVoiceView2 = this.k;
            chatVoiceView2.setOnClickListener(chatVoiceView2);
            this.r = (ChatShareCard) a(R.id.obfuscated_res_0x7f091d37);
            q();
            this.j.setOnClickListener(new i(this));
            this.k.setLongClickable(true);
            this.k.setOnLongClickListener(new j(this));
            this.q.getImage().setClickable(true);
            this.q.getImage().setOnClickListener(new k(this));
            this.q.getImage().setLongClickable(true);
            this.q.getImage().setOnLongClickListener(new l(this));
            this.q.getTail().setClickable(true);
            this.q.getTail().setOnClickListener(new m(this));
            this.j.setLongClickable(true);
            this.j.setOnLongClickListener(new n(this));
            GifView gifView = (GifView) a(R.id.obfuscated_res_0x7f09087c);
            this.l = gifView;
            gifView.setSupportNoImage(false);
            this.l.setOnClickListener(new o(this));
            this.l.setLongClickable(true);
            this.l.setOnLongClickListener(new p(this));
            this.n.setClickable(true);
            this.n.setOnClickListener(new q(this));
            this.n.setLongClickable(true);
            this.n.setOnLongClickListener(new a(this));
            this.o.setClickable(true);
            this.o.setOnClickListener(new b(this));
            this.o.setLongClickable(true);
            this.o.setOnLongClickListener(new c(this));
            this.p.getContentBody().setClickable(true);
            this.p.getContentBody().setOnClickListener(new d(this));
            this.p.getTail().setClickable(true);
            this.p.getTail().setOnClickListener(new e(this));
            this.p.getContentBody().setLongClickable(true);
            this.p.getContentBody().setOnLongClickListener(new f(this));
            Invite2GroupView invite2GroupView = this.m;
            if (invite2GroupView != null) {
                invite2GroupView.setOnLongClickListener(new g(this));
            }
        }
    }

    public final boolean p(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j2)) == null) {
            if (j2 < 1000) {
                return false;
            }
            long j3 = this.d;
            return j3 == 0 || j2 - j3 >= 180;
        }
        return invokeJ.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.B = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            Calendar calendar = Calendar.getInstance();
            this.e = calendar;
            calendar.setTimeInMillis(j2 * 1000);
        }
    }

    public void s(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, view2, chatMessage) == null) || chatMessage == null) {
            return;
        }
        chatMessage.setItemView(this);
        this.h = Long.valueOf(chatMessage.getMsgId());
    }

    public void setUpdateListener(AbsMsglistView.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, jVar) == null) {
            this.A = jVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.v = z;
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.q.setVisibility(i2);
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.u = z;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.t = z;
        }
    }

    public void x(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j2) == null) {
            this.d = j2;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.s = z;
        }
    }

    public void z(hf hfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, hfVar) == null) {
            this.b = hfVar;
        }
    }
}
