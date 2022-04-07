package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes5.dex */
public class a57 extends y8<MsglistActivity<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ef b;
    public ff c;
    public long d;
    public Calendar e;
    public int f;
    public long g;
    public TextView h;
    public TbRichTextView i;
    public ChatVoiceView j;
    public GifView k;
    public Invite2GroupView l;
    public ShareFromPBView m;
    public ShareFromFrsView n;
    public ShareFromGameCenter o;
    public ChatImageWithTailView p;
    public boolean q;
    public boolean r;
    public boolean s;
    public ArrayList<ReportPrivateMsgData> t;
    public int u;
    public TbCheckBox v;
    public LinearLayout w;
    public AbsMsglistView.g x;

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public a(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                a57 a57Var = this.a;
                a57Var.c.onItemViewLongClick(view2, 10, a57Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public b(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                a57 a57Var = this.a;
                a57Var.b.onItemViewClick(view2, 15, a57Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public c(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                a57 a57Var = this.a;
                a57Var.c.onItemViewLongClick(view2, 15, a57Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public d(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                a57 a57Var = this.a;
                a57Var.b.onItemViewClick(view2, 11, a57Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public e(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                a57 a57Var = this.a;
                a57Var.b.onItemViewClick(view2, 12, a57Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public f(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                a57 a57Var = this.a;
                a57Var.c.onItemViewLongClick(view2, 11, a57Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public g(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                a57 a57Var = this.a;
                a57Var.c.onItemViewLongClick(view2, 17, a57Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMessage a;
        public final /* synthetic */ a57 b;

        public h(a57 a57Var, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a57Var;
            this.a = chatMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(Boolean.valueOf(!((Boolean) view2.getTag()).booleanValue()));
                if (!((Boolean) view2.getTag()).booleanValue()) {
                    int i = 0;
                    this.b.v.setChecked(false);
                    while (true) {
                        if (i < this.b.t.size()) {
                            if (this.b.t.get(i) != null && TextUtils.equals(String.valueOf(this.a.getMsgId()), this.b.t.get(i).getMsgId())) {
                                this.b.t.remove(i);
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                    if (this.b.x != null) {
                        this.b.x.a(this.b.t, true);
                    }
                } else if (this.b.t.size() < 20) {
                    this.b.v.setChecked(true);
                    this.b.t.add(new ReportPrivateMsgData(String.valueOf(this.a.getMsgId()), zr8.b(this.b.mContext, this.a), String.valueOf(this.a.getTime())));
                    if (this.b.x != null) {
                        this.b.x.a(this.b.t, true);
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_REPORT_PRIVATE_MSG_CHANGE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921670, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public i(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TbRichTextView tbRichTextView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (tbRichTextView = this.a.i) == null || tbRichTextView.getTextView() == null) {
                return;
            }
            CharSequence text = this.a.i.getTextView().getText();
            if (TextUtils.isEmpty(text)) {
                return;
            }
            if (text.toString().contains("删贴") || text.toString().contains("删除")) {
                if (text.toString().contains("http://") || text.toString().contains("https://")) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) f9.a(view2.getContext()), new String[]{"http://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1"});
                    wt4.k().u(wt4.o("key_person_post_recycle_bin_red_tip_show"), false);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SITE_SERVICE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public j(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                a57 a57Var = this.a;
                a57Var.c.onItemViewLongClick(view2, 5, a57Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public k(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                a57 a57Var = this.a;
                a57Var.b.onItemViewClick(view2, 4, a57Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public l(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                a57 a57Var = this.a;
                a57Var.c.onItemViewLongClick(view2, 4, a57Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public m(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                a57 a57Var = this.a;
                a57Var.b.onItemViewClick(view2, 13, a57Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public n(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                a57 a57Var = this.a;
                a57Var.c.onItemViewLongClick(view2, 3, a57Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public o(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                a57 a57Var = this.a;
                a57Var.b.onItemViewClick(view2, 7, a57Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public p(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                a57 a57Var = this.a;
                a57Var.c.onItemViewLongClick(view2, 7, a57Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a57 a;

        public q(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                a57 a57Var = this.a;
                a57Var.b.onItemViewClick(view2, 10, a57Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public r(a57 a57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a57Var};
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
    public a57(TbPageContext<MsglistActivity<?>> tbPageContext, int i2) {
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
                super((b9) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.f = 0;
        this.g = 0L;
        this.q = true;
        this.r = false;
        this.s = false;
        this.d = 0L;
        this.e = null;
        this.mContext = tbPageContext;
    }

    public void A(ChatMessage chatMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, chatMessage, z) == null) {
            d57.a(this.mContext.getContext(), this.k, chatMessage, z);
        }
    }

    public void B(View view2, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, chatMessage, str) == null) {
            d57.b(this.mContext.getContext(), view2, this.m, this.n, this.o, chatMessage, str);
        }
    }

    public void C(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) {
            boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
            boolean l2 = l(chatMessage.getTime());
            if (!z && !l2) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
                this.h.setText(j(chatMessage.getTime()));
            }
            if (z || !l2) {
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

    public void D(View view2, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, view2, chatMessage, str) == null) {
            b9<T> b9Var = this.mContext;
            d57.c((TbPageContext) b9Var, b9Var.getContext(), view2, this.l, chatMessage, str);
        }
    }

    public void E(View view2, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, view2, chatMessage, str) == null) {
            d57.d(this.mContext.getContext(), view2, this.p, chatMessage, this.g, str);
        }
    }

    public void F(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, chatMessage, str) == null) {
            d57.e(this.i, chatMessage, str, this.u);
            if (chatMessage == null || chatMessage.getContent() == null) {
                return;
            }
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.i.setContentDescription(stringBuffer.toString());
            this.i.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    public void G(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, chatMessage, str) == null) {
            d57.f(this.mContext.getContext(), this.j, chatMessage, str);
        }
    }

    public void H(ChatMessage chatMessage) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, chatMessage) == null) {
            if (this.t == null) {
                this.t = new ArrayList<>();
            }
            if (this.s) {
                this.w.setVisibility(0);
                int i2 = 0;
                while (true) {
                    if (i2 >= this.t.size()) {
                        z = false;
                        break;
                    }
                    ReportPrivateMsgData reportPrivateMsgData = this.t.get(i2);
                    if (reportPrivateMsgData != null && TextUtils.equals(String.valueOf(chatMessage.getMsgId()), reportPrivateMsgData.getMsgId())) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                this.w.setTag(Boolean.valueOf(z));
                this.v.setTagData(new r(this));
                this.v.setBackgroundDrawableIdIsWebP(true);
                this.v.setClickable(false);
                this.v.setBackgroundDrawableId(R.drawable.obfuscated_res_0x7f08099e, R.drawable.obfuscated_res_0x7f08099d);
                this.v.setChecked(((Boolean) this.w.getTag()).booleanValue());
                this.w.setOnClickListener(new h(this, chatMessage));
                return;
            }
            this.w.setVisibility(8);
        }
    }

    public final String j(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
            if (j2 < 1000) {
                return "";
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2 * 1000);
            Calendar calendar2 = this.e;
            if (calendar2 != null && calendar2.get(1) == calendar.get(1) && this.e.get(6) == calendar.get(6)) {
                return ni.getDateStringHm(calendar.getTime());
            }
            return ni.getDateStringMdHm(calendar.getTime());
        }
        return (String) invokeJ.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.h = (TextView) e(R.id.obfuscated_res_0x7f091f04);
            TbRichTextView tbRichTextView = (TbRichTextView) e(R.id.obfuscated_res_0x7f091f03);
            this.i = tbRichTextView;
            tbRichTextView.setLinkTextColor(-14845754);
            this.p = (ChatImageWithTailView) e(R.id.obfuscated_res_0x7f090ebd);
            this.v = (TbCheckBox) e(R.id.obfuscated_res_0x7f090657);
            this.w = (LinearLayout) e(R.id.obfuscated_res_0x7f0912de);
            this.l = (Invite2GroupView) e(R.id.obfuscated_res_0x7f0911a9);
            this.m = (ShareFromPBView) e(R.id.obfuscated_res_0x7f0911ac);
            this.n = (ShareFromFrsView) e(R.id.obfuscated_res_0x7f0911aa);
            this.o = (ShareFromGameCenter) e(R.id.obfuscated_res_0x7f0911ab);
            ChatVoiceView chatVoiceView = (ChatVoiceView) e(R.id.obfuscated_res_0x7f0911ad);
            this.j = chatVoiceView;
            chatVoiceView.setClickable(true);
            ChatVoiceView chatVoiceView2 = this.j;
            chatVoiceView2.setOnClickListener(chatVoiceView2);
            this.i.setOnClickListener(new i(this));
            this.j.setLongClickable(true);
            this.j.setOnLongClickListener(new j(this));
            this.p.getImage().setClickable(true);
            this.p.getImage().setOnClickListener(new k(this));
            this.p.getImage().setLongClickable(true);
            this.p.getImage().setOnLongClickListener(new l(this));
            this.p.getTail().setClickable(true);
            this.p.getTail().setOnClickListener(new m(this));
            this.i.setLongClickable(true);
            this.i.setOnLongClickListener(new n(this));
            GifView gifView = (GifView) e(R.id.obfuscated_res_0x7f0908aa);
            this.k = gifView;
            gifView.setSupportNoImage(false);
            this.k.setOnClickListener(new o(this));
            this.k.setLongClickable(true);
            this.k.setOnLongClickListener(new p(this));
            this.m.setClickable(true);
            this.m.setOnClickListener(new q(this));
            this.m.setLongClickable(true);
            this.m.setOnLongClickListener(new a(this));
            this.n.setClickable(true);
            this.n.setOnClickListener(new b(this));
            this.n.setLongClickable(true);
            this.n.setOnLongClickListener(new c(this));
            this.o.getContentBody().setClickable(true);
            this.o.getContentBody().setOnClickListener(new d(this));
            this.o.getTail().setClickable(true);
            this.o.getTail().setOnClickListener(new e(this));
            this.o.getContentBody().setLongClickable(true);
            this.o.getContentBody().setOnLongClickListener(new f(this));
            Invite2GroupView invite2GroupView = this.l;
            if (invite2GroupView != null) {
                invite2GroupView.setOnLongClickListener(new g(this));
            }
        }
    }

    public final boolean l(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
            if (j2 < 1000) {
                return false;
            }
            long j3 = this.d;
            return j3 == 0 || j2 - j3 >= 180;
        }
        return invokeJ.booleanValue;
    }

    public void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            Calendar calendar = Calendar.getInstance();
            this.e = calendar;
            calendar.setTimeInMillis(j2 * 1000);
        }
    }

    public void n(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, view2, chatMessage) == null) || chatMessage == null) {
            return;
        }
        chatMessage.getMsgId();
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.s = z;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.p.setVisibility(i2);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.r = z;
        }
    }

    public void s(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
            this.d = j2;
        }
    }

    public void setUpdateListener(AbsMsglistView.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) {
            this.x = gVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.q = z;
        }
    }

    public void u(ef efVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, efVar) == null) {
            this.b = efVar;
        }
    }

    public void v(ff ffVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, ffVar) == null) {
            this.c = ffVar;
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f = i2;
        }
    }

    public void x(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, view2, chatMessage) == null) {
        }
    }

    public void y(ArrayList<ReportPrivateMsgData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, arrayList) == null) {
            this.t = arrayList;
            AbsMsglistView.g gVar = this.x;
            if (gVar != null) {
                gVar.a(arrayList, false);
            }
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.u = i2;
        }
    }
}
