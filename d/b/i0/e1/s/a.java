package d.b.i0.e1.s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
import d.b.h0.b0.a;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f55510h;
    public static volatile Long i = 0L;
    public static volatile long j = 0;

    /* renamed from: c  reason: collision with root package name */
    public a.d f55513c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.e1.s.d f55514d;

    /* renamed from: e  reason: collision with root package name */
    public VoiceSendModel f55515e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<a.b<ChatMessage>> f55516f;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<ChatMessage> f55511a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, d.b.h0.b0.a<ChatMessage>> f55512b = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public VoiceSendModel.b f55517g = new h();

    /* renamed from: d.b.i0.e1.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1273a implements a.d {

        /* renamed from: d.b.i0.e1.s.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1274a extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f55519a;

            public C1274a(C1273a c1273a, CommonGroupChatMessage commonGroupChatMessage) {
                this.f55519a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.h0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.i0.e1.h.c.h().o(this.f55519a.getGroupId(), String.valueOf(this.f55519a.getRecordId()), String.valueOf(this.f55519a.getMsgId()), 2));
            }
        }

        /* renamed from: d.b.i0.e1.s.a$a$b */
        /* loaded from: classes4.dex */
        public class b implements d.b.h0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f55520a;

            public b(C1273a c1273a, CommonGroupChatMessage commonGroupChatMessage) {
                this.f55520a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f55520a);
            }
        }

        /* renamed from: d.b.i0.e1.s.a$a$c */
        /* loaded from: classes4.dex */
        public class c extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f55521a;

            public c(C1273a c1273a, PersonalChatMessage personalChatMessage) {
                this.f55521a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.h0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.i0.e1.h.m.t().s(this.f55521a.getUserId(), this.f55521a.getToUserId(), String.valueOf(this.f55521a.getRecordId()), String.valueOf(this.f55521a.getMsgId()), 2));
            }
        }

        /* renamed from: d.b.i0.e1.s.a$a$d */
        /* loaded from: classes4.dex */
        public class d implements d.b.h0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f55522a;

            public d(C1273a c1273a, PersonalChatMessage personalChatMessage) {
                this.f55522a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f55522a);
            }
        }

        /* renamed from: d.b.i0.e1.s.a$a$e */
        /* loaded from: classes4.dex */
        public class e extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f55523a;

            public e(C1273a c1273a, OfficialChatMessage officialChatMessage) {
                this.f55523a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.h0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.i0.e1.h.l.t().s(this.f55523a.getUserId(), this.f55523a.getToUserId(), String.valueOf(this.f55523a.getRecordId()), String.valueOf(this.f55523a.getMsgId()), 2));
            }
        }

        /* renamed from: d.b.i0.e1.s.a$a$f */
        /* loaded from: classes4.dex */
        public class f implements d.b.h0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f55524a;

            public f(C1273a c1273a, OfficialChatMessage officialChatMessage) {
                this.f55524a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f55524a);
            }
        }

        public C1273a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0090, code lost:
            d.b.h0.r.z.a.a("im", r0.getClientLogID(), r0.getCmd(), "up_pic_ret", r13.error_code, r13.error_msg, new java.lang.Object[0]);
         */
        @Override // d.b.h0.b0.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void a(String str, ImageUploadResult imageUploadResult) {
            d.b.h0.b0.a aVar;
            int i;
            synchronized (a.class) {
                aVar = (d.b.h0.b0.a) a.this.f55512b.remove(str);
            }
            if (aVar == null) {
                return;
            }
            ChatMessage chatMessage = (ChatMessage) aVar.f();
            if (chatMessage == null) {
                return;
            }
            int i2 = 0;
            if (imageUploadResult != null && imageUploadResult.error_code == 0 && imageUploadResult.picInfo != null) {
                d.b.h0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", 0, null, new Object[0]);
                String str2 = null;
                String str3 = imageUploadResult.picInfo.bigPic == null ? null : imageUploadResult.picInfo.bigPic.picUrl;
                if (imageUploadResult.picInfo.smallPic != null) {
                    str2 = imageUploadResult.picInfo.smallPic.picUrl;
                    i2 = imageUploadResult.picInfo.smallPic.width;
                    i = imageUploadResult.picInfo.smallPic.height;
                    a.this.s(str, str2);
                } else {
                    i = 0;
                }
                chatMessage.setContent(a.f(str3, str2, i2, i));
                a.j().t(chatMessage);
                if (a.this.f55514d != null) {
                    a.this.f55514d.a(1);
                }
            }
            d.b.h0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", -1, "result is null", new Object[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
            if (chatMessage instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                h0.c(new C1274a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
            } else if (chatMessage instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                h0.c(new c(this, personalChatMessage), new d(this, personalChatMessage));
            } else if (chatMessage instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                h0.c(new e(this, officialChatMessage), new f(this, officialChatMessage));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f55525a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f55526b;

        public b(a aVar, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            this.f55525a = commonGroupChatMessage;
            this.f55526b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.h0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.b.i0.e1.h.c.h().l(this.f55525a.getGroupId(), this.f55526b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.h0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f55527a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f55528b;

        public c(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
            this.f55527a = commonGroupChatMessage;
            this.f55528b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f55527a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f55527a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.f55527a.getGroupId(), this.f55528b.getCustomGroupType(), this.f55528b, 3)));
        }
    }

    /* loaded from: classes4.dex */
    public class d extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f55529a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f55530b;

        public d(a aVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
            this.f55529a = personalChatMessage;
            this.f55530b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.h0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.b.i0.e1.h.m.t().m(d.b.i0.e1.w.c.m(this.f55529a), this.f55530b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.b.h0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f55531a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f55532b;

        public e(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
            this.f55531a = personalChatMessage;
            this.f55532b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f55531a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f55531a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f55531a.getToUserId()), 2, this.f55532b, 3)));
        }
    }

    /* loaded from: classes4.dex */
    public class f extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f55533a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f55534b;

        public f(a aVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
            this.f55533a = officialChatMessage;
            this.f55534b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.h0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.b.i0.e1.h.l.t().m(d.b.i0.e1.w.c.m(this.f55533a), this.f55534b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.b.h0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f55535a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f55536b;

        public g(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
            this.f55535a = officialChatMessage;
            this.f55536b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f55535a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f55535a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f55535a.getToUserId()), 4, this.f55536b, 3)));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements VoiceSendModel.b {

        /* renamed from: d.b.i0.e1.s.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1275a extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f55538a;

            public C1275a(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                this.f55538a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.h0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.i0.e1.h.c.h().o(this.f55538a.getGroupId(), String.valueOf(this.f55538a.getRecordId()), String.valueOf(this.f55538a.getMsgId()), 2));
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.b.h0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f55539a;

            public b(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                this.f55539a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f55539a);
            }
        }

        /* loaded from: classes4.dex */
        public class c extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f55540a;

            public c(h hVar, PersonalChatMessage personalChatMessage) {
                this.f55540a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.h0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.i0.e1.h.m.t().s(this.f55540a.getUserId(), this.f55540a.getToUserId(), String.valueOf(this.f55540a.getRecordId()), String.valueOf(this.f55540a.getMsgId()), 2));
            }
        }

        /* loaded from: classes4.dex */
        public class d implements d.b.h0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f55541a;

            public d(h hVar, PersonalChatMessage personalChatMessage) {
                this.f55541a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f55541a);
            }
        }

        /* loaded from: classes4.dex */
        public class e extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f55542a;

            public e(h hVar, OfficialChatMessage officialChatMessage) {
                this.f55542a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.h0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.i0.e1.h.l.t().s(this.f55542a.getUserId(), this.f55542a.getToUserId(), String.valueOf(this.f55542a.getRecordId()), String.valueOf(this.f55542a.getMsgId()), 2));
            }
        }

        /* loaded from: classes4.dex */
        public class f implements d.b.h0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f55543a;

            public f(h hVar, OfficialChatMessage officialChatMessage) {
                this.f55543a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f55543a);
            }
        }

        public h() {
        }

        @Override // com.baidu.tieba.im.sendmessage.VoiceSendModel.b
        public void a(String str, ChatMessage chatMessage) {
            try {
                a.j().q(chatMessage);
                if (chatMessage != null) {
                    if (str != null && str.length() > 0) {
                        VoiceMsgData n = d.b.i0.e1.w.c.n(chatMessage);
                        if (n != null) {
                            n.setVoice_md5(str);
                            String jsonStrWithObject = OrmObject.jsonStrWithObject(n);
                            chatMessage.setContent("[" + jsonStrWithObject + "]");
                        }
                        d.b.h0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", 0, null, new Object[0]);
                        a.j().t(chatMessage);
                        if (a.this.f55514d != null) {
                            a.this.f55514d.a(2);
                            return;
                        }
                        return;
                    }
                    d.b.h0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", -1, "voice http fail", new Object[0]);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        h0.c(new C1275a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
                    } else if (chatMessage instanceof PersonalChatMessage) {
                        PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                        h0.c(new c(this, personalChatMessage), new d(this, personalChatMessage));
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                        h0.c(new e(this, officialChatMessage), new f(this, officialChatMessage));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends BdAsyncTask<Void, Void, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55544a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f55545b;

        public i(String str, String str2) {
            this.f55544a = str;
            this.f55545b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            return BitmapFactory.decodeFile(this.f55544a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            a.this.r(this.f55545b, new d.b.c.j.d.a(bitmap, false));
        }
    }

    /* loaded from: classes4.dex */
    public class j extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55547a;

        public j(a aVar, String str) {
            this.f55547a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.b.i0.e1.h.c.h().f(this.f55547a, 2, null, 1000);
        }
    }

    /* loaded from: classes4.dex */
    public class k implements d.b.h0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.e1.s.c f55548a;

        public k(a aVar, d.b.i0.e1.s.c cVar) {
            this.f55548a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
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
                    String f2 = d.b.i0.e1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.b.i0.e1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f55548a.a(linkedHashMap2, hashMap);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55549a;

        public l(a aVar, String str) {
            this.f55549a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.b.i0.e1.h.m.t().f(this.f55549a, 2, null, 1000);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements d.b.h0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.e1.s.c f55550a;

        public m(a aVar, d.b.i0.e1.s.c cVar) {
            this.f55550a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
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
                    String f2 = d.b.i0.e1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.b.i0.e1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f55550a.a(linkedHashMap2, hashMap);
        }
    }

    /* loaded from: classes4.dex */
    public class n extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55551a;

        public n(a aVar, String str) {
            this.f55551a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.b.i0.e1.h.l.t().f(this.f55551a, 2, null, 1000);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements d.b.h0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.e1.s.c f55552a;

        public o(a aVar, d.b.i0.e1.s.c cVar) {
            this.f55552a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
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
                    String f2 = d.b.i0.e1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.b.i0.e1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f55552a.a(linkedHashMap2, hashMap);
        }
    }

    public a() {
        k();
    }

    public static String f(String str, String str2, int i2, int i3) {
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

    public static a j() {
        if (f55510h == null) {
            synchronized (a.class) {
                if (f55510h == null) {
                    f55510h = new a();
                }
            }
        }
        return f55510h;
    }

    public static void m(ChatMessage chatMessage) {
        String groupId = chatMessage.getGroupId();
        if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
            groupId = String.valueOf(chatMessage.getToUserId());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(groupId, chatMessage.getCustomGroupType(), chatMessage, 3)));
    }

    public static void w(long j2) {
        j = j2;
    }

    public static void x(long j2) {
        i = Long.valueOf(j2);
    }

    public boolean g(ChatMessage chatMessage) {
        HashMap<String, d.b.h0.b0.a<ChatMessage>> hashMap = this.f55512b;
        if (hashMap != null && chatMessage != null) {
            for (Map.Entry<String, d.b.h0.b0.a<ChatMessage>> entry : hashMap.entrySet()) {
                d.b.h0.b0.a<ChatMessage> value = entry.getValue();
                if (value != null && value.f() != null) {
                    ChatMessage f2 = value.f();
                    if (chatMessage.getRecordId() != f2.getRecordId()) {
                        continue;
                    } else if (chatMessage.getCustomGroupType() != 2 && chatMessage.getCustomGroupType() != 4) {
                        if (chatMessage.getGroupId() != null && f2.getGroupId() != null && chatMessage.getGroupId().equals(f2.getGroupId())) {
                            WeakReference<a.b<ChatMessage>> weakReference = this.f55516f;
                            if (weakReference != null && weakReference.get() != null) {
                                value.m(this.f55516f.get());
                            }
                            return true;
                        }
                    } else if (chatMessage.getToUserId() == f2.getToUserId()) {
                        WeakReference<a.b<ChatMessage>> weakReference2 = this.f55516f;
                        if (weakReference2 != null && weakReference2.get() != null) {
                            value.m(this.f55516f.get());
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean h(ChatMessage chatMessage) {
        return i(chatMessage, this.f55511a) != -1;
    }

    public final int i(ChatMessage chatMessage, LinkedList<ChatMessage> linkedList) {
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

    public final void k() {
        VoiceSendModel voiceSendModel = new VoiceSendModel(null);
        this.f55515e = voiceSendModel;
        voiceSendModel.t(this.f55517g);
        this.f55513c = new C1273a();
    }

    public final void l(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return;
        }
        this.f55511a.add(chatMessage);
    }

    public void n(String str, d.b.i0.e1.s.c cVar) {
        h0.c(new j(this, str), new k(this, cVar));
    }

    public void o(String str, d.b.i0.e1.s.c cVar) {
        h0.c(new n(this, str), new o(this, cVar));
    }

    public void p(String str, d.b.i0.e1.s.c cVar) {
        h0.c(new l(this, str), new m(this, cVar));
    }

    public final void q(ChatMessage chatMessage) {
        int i2 = i(chatMessage, this.f55511a);
        if (i2 >= 0) {
            this.f55511a.remove(i2);
        }
    }

    public final void r(String str, d.b.c.j.d.a aVar) {
        d.b.h0.a0.c.k().d(str, aVar);
        d.b.c.e.a.f.c cVar = new d.b.c.e.a.f.c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setData(aVar.n());
        cVar.setGif(false);
        d.b.c.e.a.d.g().a(cVar);
    }

    public final void s(String str, String str2) {
        d.b.c.j.d.a m2 = d.b.h0.a0.c.k().m(str);
        String str3 = str2 + 10;
        if (m2 != null && m2.w()) {
            r(str3, m2);
        } else {
            new i(str, str3).execute(new Void[0]);
        }
    }

    public void t(ChatMessage chatMessage) {
        if (chatMessage instanceof CommonGroupChatMessage) {
            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            h0.c(new b(this, commonGroupChatMessage, linkedList), new c(this, commonGroupChatMessage, chatMessage));
        } else if (chatMessage instanceof PersonalChatMessage) {
            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            h0.c(new d(this, personalChatMessage, linkedList2), new e(this, personalChatMessage, chatMessage));
        } else if (chatMessage instanceof OfficialChatMessage) {
            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
            LinkedList linkedList3 = new LinkedList();
            CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
            commonMsgPojo3.setRead_flag(0);
            linkedList3.add(commonMsgPojo3);
            h0.c(new f(this, officialChatMessage, linkedList3), new g(this, officialChatMessage, chatMessage));
        }
    }

    public void u(a.b<ChatMessage> bVar) {
        this.f55516f = new WeakReference<>(bVar);
    }

    public void v(d.b.i0.e1.s.d dVar) {
        this.f55514d = dVar;
    }

    public void y(ChatMessage chatMessage, String str) {
        d.b.h0.b0.a<ChatMessage> aVar = this.f55512b.get(str);
        if (aVar == null) {
            aVar = new d.b.h0.b0.a<>(str, "IM");
            aVar.j();
            aVar.i(chatMessage);
            WeakReference<a.b<ChatMessage>> weakReference = this.f55516f;
            if (weakReference != null && weakReference.get() != null) {
                aVar.m(this.f55516f.get());
            }
            aVar.l(this.f55513c);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar.h(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar.h(String.valueOf(i));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar.h(String.valueOf(j));
            }
            synchronized (a.class) {
                this.f55512b.put(str, aVar);
            }
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        m(chatMessage);
        aVar.g(false);
    }

    public void z(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        l(chatMessage);
        if (chatMessage != null) {
            chatMessage.getClientLogID();
            chatMessage.getCmd();
        }
        this.f55515e.u(voiceMsgData.getVoice_md5(), chatMessage);
    }
}
