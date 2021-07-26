package d.a.q0.i1.s;

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
import d.a.p0.b1.f0;
import d.a.p0.b1.i0;
import d.a.p0.c0.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f59231h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Long f59232i;
    public static volatile long j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<ChatMessage> f59233a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, d.a.p0.c0.a<ChatMessage>> f59234b;

    /* renamed from: c  reason: collision with root package name */
    public a.d f59235c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.i1.s.d f59236d;

    /* renamed from: e  reason: collision with root package name */
    public VoiceSendModel f59237e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<a.b<ChatMessage>> f59238f;

    /* renamed from: g  reason: collision with root package name */
    public VoiceSendModel.b f59239g;

    /* renamed from: d.a.q0.i1.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1480a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59240a;

        /* renamed from: d.a.q0.i1.s.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1481a extends f0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f59241a;

            public C1481a(C1480a c1480a, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1480a, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59241a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.p0.b1.f0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.q0.i1.h.c.h().o(this.f59241a.getGroupId(), String.valueOf(this.f59241a.getRecordId()), String.valueOf(this.f59241a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* renamed from: d.a.q0.i1.s.a$a$b */
        /* loaded from: classes8.dex */
        public class b implements d.a.p0.b1.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f59242a;

            public b(C1480a c1480a, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1480a, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59242a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.p0.b1.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f59242a);
                }
            }
        }

        /* renamed from: d.a.q0.i1.s.a$a$c */
        /* loaded from: classes8.dex */
        public class c extends f0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f59243a;

            public c(C1480a c1480a, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1480a, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59243a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.p0.b1.f0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.q0.i1.h.m.t().s(this.f59243a.getUserId(), this.f59243a.getToUserId(), String.valueOf(this.f59243a.getRecordId()), String.valueOf(this.f59243a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* renamed from: d.a.q0.i1.s.a$a$d */
        /* loaded from: classes8.dex */
        public class d implements d.a.p0.b1.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f59244a;

            public d(C1480a c1480a, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1480a, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59244a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.p0.b1.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f59244a);
                }
            }
        }

        /* renamed from: d.a.q0.i1.s.a$a$e */
        /* loaded from: classes8.dex */
        public class e extends f0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f59245a;

            public e(C1480a c1480a, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1480a, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59245a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.p0.b1.f0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.q0.i1.h.l.t().s(this.f59245a.getUserId(), this.f59245a.getToUserId(), String.valueOf(this.f59245a.getRecordId()), String.valueOf(this.f59245a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* renamed from: d.a.q0.i1.s.a$a$f */
        /* loaded from: classes8.dex */
        public class f implements d.a.p0.b1.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f59246a;

            public f(C1480a c1480a, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1480a, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59246a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.p0.b1.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f59246a);
                }
            }
        }

        public C1480a(a aVar) {
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
            this.f59240a = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0094, code lost:
            d.a.p0.s.z.a.a("im", r0.getClientLogID(), r0.getCmd(), "up_pic_ret", r13.error_code, r13.error_msg, new java.lang.Object[0]);
         */
        @Override // d.a.p0.c0.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void a(String str, ImageUploadResult imageUploadResult) {
            d.a.p0.c0.a aVar;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, imageUploadResult) == null) {
                synchronized (this) {
                    synchronized (a.class) {
                        aVar = (d.a.p0.c0.a) this.f59240a.f59234b.remove(str);
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
                        d.a.p0.s.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", 0, null, new Object[0]);
                        String str2 = null;
                        String str3 = imageUploadResult.picInfo.bigPic == null ? null : imageUploadResult.picInfo.bigPic.picUrl;
                        if (imageUploadResult.picInfo.smallPic != null) {
                            str2 = imageUploadResult.picInfo.smallPic.picUrl;
                            i3 = imageUploadResult.picInfo.smallPic.width;
                            i2 = imageUploadResult.picInfo.smallPic.height;
                            this.f59240a.s(str, str2);
                        } else {
                            i2 = 0;
                        }
                        chatMessage.setContent(a.f(str3, str2, i3, i2));
                        a.j().t(chatMessage);
                        if (this.f59240a.f59236d != null) {
                            this.f59240a.f59236d.a(1);
                        }
                    }
                    d.a.p0.s.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", -1, "result is null", new Object[0]);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        i0.c(new C1481a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
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

    /* loaded from: classes8.dex */
    public class b extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f59247a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f59248b;

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
            this.f59247a = commonGroupChatMessage;
            this.f59248b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.p0.b1.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.q0.i1.h.c.h().l(this.f59247a.getGroupId(), this.f59248b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.p0.b1.n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f59249a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f59250b;

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
            this.f59249a = commonGroupChatMessage;
            this.f59250b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f59249a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.f59249a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.f59249a.getGroupId(), this.f59250b.getCustomGroupType(), this.f59250b, 3)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f59251a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f59252b;

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
            this.f59251a = personalChatMessage;
            this.f59252b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.p0.b1.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.q0.i1.h.m.t().m(d.a.q0.i1.w.c.m(this.f59251a), this.f59252b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a.p0.b1.n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f59253a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f59254b;

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
            this.f59253a = personalChatMessage;
            this.f59254b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f59253a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.f59253a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f59253a.getToUserId()), 2, this.f59254b, 3)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f59255a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f59256b;

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
            this.f59255a = officialChatMessage;
            this.f59256b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.p0.b1.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.q0.i1.h.l.t().m(d.a.q0.i1.w.c.m(this.f59255a), this.f59256b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements d.a.p0.b1.n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f59257a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f59258b;

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
            this.f59257a = officialChatMessage;
            this.f59258b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f59257a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.f59257a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f59257a.getToUserId()), 4, this.f59258b, 3)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements VoiceSendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59259a;

        /* renamed from: d.a.q0.i1.s.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1482a extends f0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f59260a;

            public C1482a(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
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
                this.f59260a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.p0.b1.f0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.q0.i1.h.c.h().o(this.f59260a.getGroupId(), String.valueOf(this.f59260a.getRecordId()), String.valueOf(this.f59260a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes8.dex */
        public class b implements d.a.p0.b1.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f59261a;

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
                this.f59261a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.p0.b1.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f59261a);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c extends f0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f59262a;

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
                this.f59262a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.p0.b1.f0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.q0.i1.h.m.t().s(this.f59262a.getUserId(), this.f59262a.getToUserId(), String.valueOf(this.f59262a.getRecordId()), String.valueOf(this.f59262a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes8.dex */
        public class d implements d.a.p0.b1.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f59263a;

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
                this.f59263a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.p0.b1.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f59263a);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class e extends f0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f59264a;

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
                this.f59264a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.p0.b1.f0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.q0.i1.h.l.t().s(this.f59264a.getUserId(), this.f59264a.getToUserId(), String.valueOf(this.f59264a.getRecordId()), String.valueOf(this.f59264a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes8.dex */
        public class f implements d.a.p0.b1.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f59265a;

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
                this.f59265a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.p0.b1.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f59265a);
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
            this.f59259a = aVar;
        }

        @Override // com.baidu.tieba.im.sendmessage.VoiceSendModel.b
        public void a(String str, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, chatMessage) == null) {
                try {
                    a.j().q(chatMessage);
                    if (chatMessage != null) {
                        if (str != null && str.length() > 0) {
                            VoiceMsgData n = d.a.q0.i1.w.c.n(chatMessage);
                            if (n != null) {
                                n.setVoice_md5(str);
                                String jsonStrWithObject = OrmObject.jsonStrWithObject(n);
                                chatMessage.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                            }
                            d.a.p0.s.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", 0, null, new Object[0]);
                            a.j().t(chatMessage);
                            if (this.f59259a.f59236d != null) {
                                this.f59259a.f59236d.a(2);
                                return;
                            }
                            return;
                        }
                        d.a.p0.s.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", -1, "voice http fail", new Object[0]);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                        if (chatMessage instanceof CommonGroupChatMessage) {
                            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                            i0.c(new C1482a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
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

    /* loaded from: classes8.dex */
    public class i extends BdAsyncTask<Void, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f59266a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f59267b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f59268c;

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
            this.f59268c = aVar;
            this.f59266a = str;
            this.f59267b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? BitmapFactory.decodeFile(this.f59266a) : (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                this.f59268c.r(this.f59267b, new d.a.d.k.d.a(bitmap, false));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends f0<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f59269a;

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
            this.f59269a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.q0.i1.h.c.h().f(this.f59269a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class k implements d.a.p0.b1.n<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.i1.s.c f59270a;

        public k(a aVar, d.a.q0.i1.s.c cVar) {
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
            this.f59270a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
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
                        String f2 = d.a.q0.i1.w.c.f(str3, true);
                        if (f2 != null) {
                            linkedHashMap2.put(str2, f2);
                        }
                        String f3 = d.a.q0.i1.w.c.f(str3, false);
                        if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = f3;
                            imageUrlData.urlType = 10;
                            hashMap.put(f2, imageUrlData);
                        }
                    }
                }
                this.f59270a.a(linkedHashMap2, hashMap);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l extends f0<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f59271a;

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
            this.f59271a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.q0.i1.h.m.t().f(this.f59271a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class m implements d.a.p0.b1.n<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.i1.s.c f59272a;

        public m(a aVar, d.a.q0.i1.s.c cVar) {
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
            this.f59272a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
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
                        String f2 = d.a.q0.i1.w.c.f(str3, true);
                        if (f2 != null) {
                            linkedHashMap2.put(str2, f2);
                        }
                        String f3 = d.a.q0.i1.w.c.f(str3, false);
                        if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = f3;
                            imageUrlData.urlType = 10;
                            hashMap.put(f2, imageUrlData);
                        }
                    }
                }
                this.f59272a.a(linkedHashMap2, hashMap);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends f0<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f59273a;

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
            this.f59273a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.q0.i1.h.l.t().f(this.f59273a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class o implements d.a.p0.b1.n<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.i1.s.c f59274a;

        public o(a aVar, d.a.q0.i1.s.c cVar) {
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
            this.f59274a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
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
                        String f2 = d.a.q0.i1.w.c.f(str3, true);
                        if (f2 != null) {
                            linkedHashMap2.put(str2, f2);
                        }
                        String f3 = d.a.q0.i1.w.c.f(str3, false);
                        if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = f3;
                            imageUrlData.urlType = 10;
                            hashMap.put(f2, imageUrlData);
                        }
                    }
                }
                this.f59274a.a(linkedHashMap2, hashMap);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366356686, "Ld/a/q0/i1/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366356686, "Ld/a/q0/i1/s/a;");
                return;
            }
        }
        f59232i = 0L;
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
        this.f59233a = new LinkedList<>();
        this.f59234b = new HashMap<>();
        this.f59239g = new h(this);
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
            if (f59231h == null) {
                synchronized (a.class) {
                    if (f59231h == null) {
                        f59231h = new a();
                    }
                }
            }
            return f59231h;
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
            f59232i = Long.valueOf(j2);
        }
    }

    public boolean g(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chatMessage)) == null) {
            HashMap<String, d.a.p0.c0.a<ChatMessage>> hashMap = this.f59234b;
            if (hashMap != null && chatMessage != null) {
                for (Map.Entry<String, d.a.p0.c0.a<ChatMessage>> entry : hashMap.entrySet()) {
                    d.a.p0.c0.a<ChatMessage> value = entry.getValue();
                    if (value != null && value.f() != null) {
                        ChatMessage f2 = value.f();
                        if (chatMessage.getRecordId() != f2.getRecordId()) {
                            continue;
                        } else if (chatMessage.getCustomGroupType() != 2 && chatMessage.getCustomGroupType() != 4) {
                            if (chatMessage.getGroupId() != null && f2.getGroupId() != null && chatMessage.getGroupId().equals(f2.getGroupId())) {
                                WeakReference<a.b<ChatMessage>> weakReference = this.f59238f;
                                if (weakReference != null && weakReference.get() != null) {
                                    value.m(this.f59238f.get());
                                }
                                return true;
                            }
                        } else if (chatMessage.getToUserId() == f2.getToUserId()) {
                            WeakReference<a.b<ChatMessage>> weakReference2 = this.f59238f;
                            if (weakReference2 != null && weakReference2.get() != null) {
                                value.m(this.f59238f.get());
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMessage)) == null) ? i(chatMessage, this.f59233a) != -1 : invokeL.booleanValue;
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
            this.f59237e = voiceSendModel;
            voiceSendModel.x(this.f59239g);
            this.f59235c = new C1480a(this);
        }
    }

    public final void l(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, chatMessage) == null) || chatMessage == null) {
            return;
        }
        this.f59233a.add(chatMessage);
    }

    public void n(String str, d.a.q0.i1.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, cVar) == null) {
            i0.c(new j(this, str), new k(this, cVar));
        }
    }

    public void o(String str, d.a.q0.i1.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, cVar) == null) {
            i0.c(new n(this, str), new o(this, cVar));
        }
    }

    public void p(String str, d.a.q0.i1.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, cVar) == null) {
            i0.c(new l(this, str), new m(this, cVar));
        }
    }

    public final void q(ChatMessage chatMessage) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatMessage) == null) || (i2 = i(chatMessage, this.f59233a)) < 0) {
            return;
        }
        this.f59233a.remove(i2);
    }

    public final void r(String str, d.a.d.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, aVar) == null) {
            d.a.p0.b0.c.k().d(str, aVar);
            d.a.d.e.a.f.c cVar = new d.a.d.e.a.f.c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
            cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setData(aVar.n());
            cVar.setGif(false);
            d.a.d.e.a.d.g().a(cVar);
        }
    }

    public final void s(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            d.a.d.k.d.a m2 = d.a.p0.b0.c.k().m(str);
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
            this.f59238f = new WeakReference<>(bVar);
        }
    }

    public void v(d.a.q0.i1.s.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.f59236d = dVar;
        }
    }

    public void y(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, chatMessage, str) == null) {
            d.a.p0.c0.a<ChatMessage> aVar = this.f59234b.get(str);
            if (aVar == null) {
                aVar = new d.a.p0.c0.a<>(str, "IM");
                aVar.j();
                aVar.i(chatMessage);
                WeakReference<a.b<ChatMessage>> weakReference = this.f59238f;
                if (weakReference != null && weakReference.get() != null) {
                    aVar.m(this.f59238f.get());
                }
                aVar.l(this.f59235c);
                if (chatMessage instanceof CommonGroupChatMessage) {
                    aVar.h(((CommonGroupChatMessage) chatMessage).getGroupId());
                } else if (chatMessage instanceof PersonalChatMessage) {
                    aVar.h(String.valueOf(f59232i));
                } else if (chatMessage instanceof OfficialChatMessage) {
                    aVar.h(String.valueOf(j));
                }
                synchronized (a.class) {
                    this.f59234b.put(str, aVar);
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
            this.f59237e.y(voiceMsgData.getVoice_md5(), chatMessage);
        }
    }
}
