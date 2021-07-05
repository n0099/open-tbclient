package d.a.s0.i1.s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.im.data.PicMessageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.sendmessage.VoiceSendModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.b0.a;
import d.a.r0.z0.f0;
import d.a.r0.z0.i0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f61852h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Long f61853i;
    public static volatile long j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<ChatMessage> f61854a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, d.a.r0.b0.a<ChatMessage>> f61855b;

    /* renamed from: c  reason: collision with root package name */
    public a.d f61856c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.i1.s.d f61857d;

    /* renamed from: e  reason: collision with root package name */
    public VoiceSendModel f61858e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<a.b<ChatMessage>> f61859f;

    /* renamed from: g  reason: collision with root package name */
    public VoiceSendModel.b f61860g;

    /* renamed from: d.a.s0.i1.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1519a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61861a;

        /* renamed from: d.a.s0.i1.s.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1520a extends f0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f61862a;

            public C1520a(C1519a c1519a, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1519a, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61862a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.r0.z0.f0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.s0.i1.h.c.h().o(this.f61862a.getGroupId(), String.valueOf(this.f61862a.getRecordId()), String.valueOf(this.f61862a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* renamed from: d.a.s0.i1.s.a$a$b */
        /* loaded from: classes9.dex */
        public class b implements d.a.r0.z0.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f61863a;

            public b(C1519a c1519a, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1519a, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61863a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.r0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f61863a);
                }
            }
        }

        /* renamed from: d.a.s0.i1.s.a$a$c */
        /* loaded from: classes9.dex */
        public class c extends f0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f61864a;

            public c(C1519a c1519a, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1519a, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61864a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.r0.z0.f0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.s0.i1.h.m.t().s(this.f61864a.getUserId(), this.f61864a.getToUserId(), String.valueOf(this.f61864a.getRecordId()), String.valueOf(this.f61864a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* renamed from: d.a.s0.i1.s.a$a$d */
        /* loaded from: classes9.dex */
        public class d implements d.a.r0.z0.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f61865a;

            public d(C1519a c1519a, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1519a, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61865a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.r0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f61865a);
                }
            }
        }

        /* renamed from: d.a.s0.i1.s.a$a$e */
        /* loaded from: classes9.dex */
        public class e extends f0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f61866a;

            public e(C1519a c1519a, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1519a, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61866a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.r0.z0.f0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.s0.i1.h.l.t().s(this.f61866a.getUserId(), this.f61866a.getToUserId(), String.valueOf(this.f61866a.getRecordId()), String.valueOf(this.f61866a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* renamed from: d.a.s0.i1.s.a$a$f */
        /* loaded from: classes9.dex */
        public class f implements d.a.r0.z0.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f61867a;

            public f(C1519a c1519a, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1519a, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61867a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.r0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f61867a);
                }
            }
        }

        public C1519a(a aVar) {
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
            this.f61861a = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0094, code lost:
            d.a.r0.r.z.a.a("im", r0.getClientLogID(), r0.getCmd(), "up_pic_ret", r13.error_code, r13.error_msg, new java.lang.Object[0]);
         */
        @Override // d.a.r0.b0.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void a(String str, ImageUploadResult imageUploadResult) {
            d.a.r0.b0.a aVar;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, imageUploadResult) == null) {
                synchronized (this) {
                    synchronized (a.class) {
                        aVar = (d.a.r0.b0.a) this.f61861a.f61855b.remove(str);
                    }
                    if (aVar == null) {
                        return;
                    }
                    ChatMessage chatMessage = (ChatMessage) aVar.f();
                    if (chatMessage == null) {
                        return;
                    }
                    int i3 = 0;
                    if (imageUploadResult != null && imageUploadResult.error_code == 0 && imageUploadResult.picInfo != null) {
                        d.a.r0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", 0, null, new Object[0]);
                        String str2 = null;
                        String str3 = imageUploadResult.picInfo.bigPic == null ? null : imageUploadResult.picInfo.bigPic.picUrl;
                        if (imageUploadResult.picInfo.smallPic != null) {
                            str2 = imageUploadResult.picInfo.smallPic.picUrl;
                            i3 = imageUploadResult.picInfo.smallPic.width;
                            i2 = imageUploadResult.picInfo.smallPic.height;
                            this.f61861a.s(str, str2);
                        } else {
                            i2 = 0;
                        }
                        chatMessage.setContent(a.f(str3, str2, i3, i2));
                        a.j().t(chatMessage);
                        if (this.f61861a.f61857d != null) {
                            this.f61861a.f61857d.a(1);
                        }
                    }
                    d.a.r0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", -1, "result is null", new Object[0]);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        i0.c(new C1520a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
                    } else if (chatMessage instanceof PersonalChatMessage) {
                        PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                        i0.c(new c(this, personalChatMessage), new d(this, personalChatMessage));
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                        i0.c(new e(this, officialChatMessage), new f(this, officialChatMessage));
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f61868a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f61869b;

        public b(a aVar, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, commonGroupChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61868a = commonGroupChatMessage;
            this.f61869b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.r0.z0.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.s0.i1.h.c.h().l(this.f61868a.getGroupId(), this.f61869b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements d.a.r0.z0.n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f61870a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f61871b;

        public c(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, commonGroupChatMessage, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61870a = commonGroupChatMessage;
            this.f61871b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f61870a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.f61870a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.f61870a.getGroupId(), this.f61871b.getCustomGroupType(), this.f61871b, 3)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f61872a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f61873b;

        public d(a aVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, personalChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61872a = personalChatMessage;
            this.f61873b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.r0.z0.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.s0.i1.h.m.t().m(d.a.s0.i1.w.c.m(this.f61872a), this.f61873b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements d.a.r0.z0.n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f61874a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f61875b;

        public e(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, personalChatMessage, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61874a = personalChatMessage;
            this.f61875b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f61874a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.f61874a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f61874a.getToUserId()), 2, this.f61875b, 3)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f61876a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f61877b;

        public f(a aVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, officialChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61876a = officialChatMessage;
            this.f61877b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.r0.z0.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.s0.i1.h.l.t().m(d.a.s0.i1.w.c.m(this.f61876a), this.f61877b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class g implements d.a.r0.z0.n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f61878a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f61879b;

        public g(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, officialChatMessage, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61878a = officialChatMessage;
            this.f61879b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f61878a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.f61878a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f61878a.getToUserId()), 4, this.f61879b, 3)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements VoiceSendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61880a;

        /* renamed from: d.a.s0.i1.s.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1521a extends f0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f61881a;

            public C1521a(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61881a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.r0.z0.f0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.s0.i1.h.c.h().o(this.f61881a.getGroupId(), String.valueOf(this.f61881a.getRecordId()), String.valueOf(this.f61881a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes9.dex */
        public class b implements d.a.r0.z0.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f61882a;

            public b(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61882a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.r0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f61882a);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class c extends f0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f61883a;

            public c(h hVar, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61883a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.r0.z0.f0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.s0.i1.h.m.t().s(this.f61883a.getUserId(), this.f61883a.getToUserId(), String.valueOf(this.f61883a.getRecordId()), String.valueOf(this.f61883a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes9.dex */
        public class d implements d.a.r0.z0.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f61884a;

            public d(h hVar, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61884a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.r0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f61884a);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class e extends f0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f61885a;

            public e(h hVar, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61885a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.r0.z0.f0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.s0.i1.h.l.t().s(this.f61885a.getUserId(), this.f61885a.getToUserId(), String.valueOf(this.f61885a.getRecordId()), String.valueOf(this.f61885a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes9.dex */
        public class f implements d.a.r0.z0.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f61886a;

            public f(h hVar, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61886a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.r0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f61886a);
                }
            }
        }

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
            this.f61880a = aVar;
        }

        @Override // com.baidu.tieba.im.sendmessage.VoiceSendModel.b
        public void a(String str, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, chatMessage) == null) {
                try {
                    a.j().q(chatMessage);
                    if (chatMessage != null) {
                        if (str != null && str.length() > 0) {
                            VoiceMsgData n = d.a.s0.i1.w.c.n(chatMessage);
                            if (n != null) {
                                n.setVoice_md5(str);
                                String jsonStrWithObject = OrmObject.jsonStrWithObject(n);
                                chatMessage.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                            }
                            d.a.r0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", 0, null, new Object[0]);
                            a.j().t(chatMessage);
                            if (this.f61880a.f61857d != null) {
                                this.f61880a.f61857d.a(2);
                                return;
                            }
                            return;
                        }
                        d.a.r0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", -1, "voice http fail", new Object[0]);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                        if (chatMessage instanceof CommonGroupChatMessage) {
                            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                            i0.c(new C1521a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
                        } else if (chatMessage instanceof PersonalChatMessage) {
                            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                            i0.c(new c(this, personalChatMessage), new d(this, personalChatMessage));
                        } else if (chatMessage instanceof OfficialChatMessage) {
                            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                            i0.c(new e(this, officialChatMessage), new f(this, officialChatMessage));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends BdAsyncTask<Void, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f61887a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f61888b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f61889c;

        public i(a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61889c = aVar;
            this.f61887a = str;
            this.f61888b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? BitmapFactory.decodeFile(this.f61887a) : (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                this.f61889c.r(this.f61888b, new d.a.c.k.d.a(bitmap, false));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends f0<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f61890a;

        public j(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61890a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.s0.i1.h.c.h().f(this.f61890a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class k implements d.a.r0.z0.n<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.i1.s.c f61891a;

        public k(a aVar, d.a.s0.i1.s.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61891a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, linkedHashMap) == null) {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (String str : linkedHashMap.keySet()) {
                        arrayList.add(str);
                    }
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        String str3 = linkedHashMap.get(str2);
                        String f2 = d.a.s0.i1.w.c.f(str3, true);
                        if (f2 != null) {
                            linkedHashMap2.put(str2, f2);
                        }
                        String f3 = d.a.s0.i1.w.c.f(str3, false);
                        if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = f3;
                            imageUrlData.urlType = 10;
                            hashMap.put(f2, imageUrlData);
                        }
                    }
                }
                this.f61891a.a(linkedHashMap2, hashMap);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l extends f0<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f61892a;

        public l(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61892a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.s0.i1.h.m.t().f(this.f61892a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class m implements d.a.r0.z0.n<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.i1.s.c f61893a;

        public m(a aVar, d.a.s0.i1.s.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61893a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, linkedHashMap) == null) {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (String str : linkedHashMap.keySet()) {
                        arrayList.add(str);
                    }
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        String str3 = linkedHashMap.get(str2);
                        String f2 = d.a.s0.i1.w.c.f(str3, true);
                        if (f2 != null) {
                            linkedHashMap2.put(str2, f2);
                        }
                        String f3 = d.a.s0.i1.w.c.f(str3, false);
                        if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = f3;
                            imageUrlData.urlType = 10;
                            hashMap.put(f2, imageUrlData);
                        }
                    }
                }
                this.f61893a.a(linkedHashMap2, hashMap);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n extends f0<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f61894a;

        public n(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61894a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.s0.i1.h.l.t().f(this.f61894a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class o implements d.a.r0.z0.n<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.i1.s.c f61895a;

        public o(a aVar, d.a.s0.i1.s.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61895a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, linkedHashMap) == null) {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (String str : linkedHashMap.keySet()) {
                        arrayList.add(str);
                    }
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        String str3 = linkedHashMap.get(str2);
                        String f2 = d.a.s0.i1.w.c.f(str3, true);
                        if (f2 != null) {
                            linkedHashMap2.put(str2, f2);
                        }
                        String f3 = d.a.s0.i1.w.c.f(str3, false);
                        if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = f3;
                            imageUrlData.urlType = 10;
                            hashMap.put(f2, imageUrlData);
                        }
                    }
                }
                this.f61895a.a(linkedHashMap2, hashMap);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1759383696, "Ld/a/s0/i1/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1759383696, "Ld/a/s0/i1/s/a;");
                return;
            }
        }
        f61853i = 0L;
        j = 0L;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61854a = new LinkedList<>();
        this.f61855b = new HashMap<>();
        this.f61860g = new h(this);
        k();
    }

    public static String f(String str, String str2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65543, null, str, str2, i2, i3)) == null) {
            PicMessageData picMessageData = new PicMessageData();
            picMessageData.src = str2;
            picMessageData.big_src = str;
            picMessageData.type = "3";
            if (i2 > 0) {
                picMessageData.bsize = i2 + "," + i3;
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(OrmObject.jsonWithObject(picMessageData));
            return jSONArray.toString();
        }
        return (String) invokeLLII.objValue;
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f61852h == null) {
                synchronized (a.class) {
                    if (f61852h == null) {
                        f61852h = new a();
                    }
                }
            }
            return f61852h;
        }
        return (a) invokeV.objValue;
    }

    public static void m(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, chatMessage) == null) {
            String groupId = chatMessage.getGroupId();
            if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
                groupId = String.valueOf(chatMessage.getToUserId());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(groupId, chatMessage.getCustomGroupType(), chatMessage, 3)));
        }
    }

    public static void w(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65546, null, j2) == null) {
            j = j2;
        }
    }

    public static void x(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65547, null, j2) == null) {
            f61853i = Long.valueOf(j2);
        }
    }

    public boolean g(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chatMessage)) == null) {
            HashMap<String, d.a.r0.b0.a<ChatMessage>> hashMap = this.f61855b;
            if (hashMap != null && chatMessage != null) {
                for (Map.Entry<String, d.a.r0.b0.a<ChatMessage>> entry : hashMap.entrySet()) {
                    d.a.r0.b0.a<ChatMessage> value = entry.getValue();
                    if (value != null && value.f() != null) {
                        ChatMessage f2 = value.f();
                        if (chatMessage.getRecordId() != f2.getRecordId()) {
                            continue;
                        } else if (chatMessage.getCustomGroupType() != 2 && chatMessage.getCustomGroupType() != 4) {
                            if (chatMessage.getGroupId() != null && f2.getGroupId() != null && chatMessage.getGroupId().equals(f2.getGroupId())) {
                                WeakReference<a.b<ChatMessage>> weakReference = this.f61859f;
                                if (weakReference != null && weakReference.get() != null) {
                                    value.m(this.f61859f.get());
                                }
                                return true;
                            }
                        } else if (chatMessage.getToUserId() == f2.getToUserId()) {
                            WeakReference<a.b<ChatMessage>> weakReference2 = this.f61859f;
                            if (weakReference2 != null && weakReference2.get() != null) {
                                value.m(this.f61859f.get());
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean h(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMessage)) == null) ? i(chatMessage, this.f61854a) != -1 : invokeL.booleanValue;
    }

    public final int i(ChatMessage chatMessage, LinkedList<ChatMessage> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, chatMessage, linkedList)) == null) {
            if (chatMessage == null || linkedList == null || linkedList.size() == 0) {
                return -1;
            }
            int size = linkedList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ChatMessage chatMessage2 = linkedList.get(i2);
                if (chatMessage2 != null && chatMessage.getRecordId() == chatMessage2.getRecordId()) {
                    if (chatMessage.getCustomGroupType() != 2 && chatMessage.getCustomGroupType() != 4) {
                        if (chatMessage.getGroupId() != null && chatMessage2.getGroupId() != null && chatMessage.getGroupId().equals(chatMessage2.getGroupId())) {
                            return i2;
                        }
                    } else if (chatMessage.getToUserId() == chatMessage2.getToUserId()) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            VoiceSendModel voiceSendModel = new VoiceSendModel(null);
            this.f61858e = voiceSendModel;
            voiceSendModel.x(this.f61860g);
            this.f61856c = new C1519a(this);
        }
    }

    public final void l(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, chatMessage) == null) || chatMessage == null) {
            return;
        }
        this.f61854a.add(chatMessage);
    }

    public void n(String str, d.a.s0.i1.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, cVar) == null) {
            i0.c(new j(this, str), new k(this, cVar));
        }
    }

    public void o(String str, d.a.s0.i1.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, cVar) == null) {
            i0.c(new n(this, str), new o(this, cVar));
        }
    }

    public void p(String str, d.a.s0.i1.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, cVar) == null) {
            i0.c(new l(this, str), new m(this, cVar));
        }
    }

    public final void q(ChatMessage chatMessage) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatMessage) == null) || (i2 = i(chatMessage, this.f61854a)) < 0) {
            return;
        }
        this.f61854a.remove(i2);
    }

    public final void r(String str, d.a.c.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, aVar) == null) {
            d.a.r0.a0.c.k().d(str, aVar);
            d.a.c.e.a.f.c cVar = new d.a.c.e.a.f.c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
            cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setData(aVar.n());
            cVar.setGif(false);
            d.a.c.e.a.d.g().a(cVar);
        }
    }

    public final void s(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            d.a.c.k.d.a m2 = d.a.r0.a0.c.k().m(str);
            String str3 = str2 + 10;
            if (m2 != null && m2.w()) {
                r(str3, m2);
            } else {
                new i(this, str, str3).execute(new Void[0]);
            }
        }
    }

    public void t(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, chatMessage) == null) {
            if (chatMessage instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
                commonMsgPojo.setRead_flag(0);
                linkedList.add(commonMsgPojo);
                i0.c(new b(this, commonGroupChatMessage, linkedList), new c(this, commonGroupChatMessage, chatMessage));
            } else if (chatMessage instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                i0.c(new d(this, personalChatMessage, linkedList2), new e(this, personalChatMessage, chatMessage));
            } else if (chatMessage instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                LinkedList linkedList3 = new LinkedList();
                CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
                commonMsgPojo3.setRead_flag(0);
                linkedList3.add(commonMsgPojo3);
                i0.c(new f(this, officialChatMessage, linkedList3), new g(this, officialChatMessage, chatMessage));
            }
        }
    }

    public void u(a.b<ChatMessage> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f61859f = new WeakReference<>(bVar);
        }
    }

    public void v(d.a.s0.i1.s.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.f61857d = dVar;
        }
    }

    public void y(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, chatMessage, str) == null) {
            d.a.r0.b0.a<ChatMessage> aVar = this.f61855b.get(str);
            if (aVar == null) {
                aVar = new d.a.r0.b0.a<>(str, "IM");
                aVar.j();
                aVar.i(chatMessage);
                WeakReference<a.b<ChatMessage>> weakReference = this.f61859f;
                if (weakReference != null && weakReference.get() != null) {
                    aVar.m(this.f61859f.get());
                }
                aVar.l(this.f61856c);
                if (chatMessage instanceof CommonGroupChatMessage) {
                    aVar.h(((CommonGroupChatMessage) chatMessage).getGroupId());
                } else if (chatMessage instanceof PersonalChatMessage) {
                    aVar.h(String.valueOf(f61853i));
                } else if (chatMessage instanceof OfficialChatMessage) {
                    aVar.h(String.valueOf(j));
                }
                synchronized (a.class) {
                    this.f61855b.put(str, aVar);
                }
            }
            chatMessage.setLogTime(System.currentTimeMillis());
            m(chatMessage);
            aVar.g(false);
        }
    }

    public void z(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, voiceMsgData, chatMessage) == null) {
            l(chatMessage);
            if (chatMessage != null) {
                chatMessage.getClientLogID();
                chatMessage.getCmd();
            }
            this.f61858e.y(voiceMsgData.getVoice_md5(), chatMessage);
        }
    }
}
