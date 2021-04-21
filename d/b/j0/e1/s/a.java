package d.b.j0.e1.s;

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
import d.b.i0.b0.a;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
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
    public static volatile a f55931h;
    public static volatile Long i = 0L;
    public static volatile long j = 0;

    /* renamed from: c  reason: collision with root package name */
    public a.d f55934c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.e1.s.d f55935d;

    /* renamed from: e  reason: collision with root package name */
    public VoiceSendModel f55936e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<a.b<ChatMessage>> f55937f;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<ChatMessage> f55932a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, d.b.i0.b0.a<ChatMessage>> f55933b = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public VoiceSendModel.b f55938g = new h();

    /* renamed from: d.b.j0.e1.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1296a implements a.d {

        /* renamed from: d.b.j0.e1.s.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1297a extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f55940a;

            public C1297a(C1296a c1296a, CommonGroupChatMessage commonGroupChatMessage) {
                this.f55940a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.j0.e1.h.c.h().o(this.f55940a.getGroupId(), String.valueOf(this.f55940a.getRecordId()), String.valueOf(this.f55940a.getMsgId()), 2));
            }
        }

        /* renamed from: d.b.j0.e1.s.a$a$b */
        /* loaded from: classes4.dex */
        public class b implements d.b.i0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f55941a;

            public b(C1296a c1296a, CommonGroupChatMessage commonGroupChatMessage) {
                this.f55941a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f55941a);
            }
        }

        /* renamed from: d.b.j0.e1.s.a$a$c */
        /* loaded from: classes4.dex */
        public class c extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f55942a;

            public c(C1296a c1296a, PersonalChatMessage personalChatMessage) {
                this.f55942a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.j0.e1.h.m.t().s(this.f55942a.getUserId(), this.f55942a.getToUserId(), String.valueOf(this.f55942a.getRecordId()), String.valueOf(this.f55942a.getMsgId()), 2));
            }
        }

        /* renamed from: d.b.j0.e1.s.a$a$d */
        /* loaded from: classes4.dex */
        public class d implements d.b.i0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f55943a;

            public d(C1296a c1296a, PersonalChatMessage personalChatMessage) {
                this.f55943a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f55943a);
            }
        }

        /* renamed from: d.b.j0.e1.s.a$a$e */
        /* loaded from: classes4.dex */
        public class e extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f55944a;

            public e(C1296a c1296a, OfficialChatMessage officialChatMessage) {
                this.f55944a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.j0.e1.h.l.t().s(this.f55944a.getUserId(), this.f55944a.getToUserId(), String.valueOf(this.f55944a.getRecordId()), String.valueOf(this.f55944a.getMsgId()), 2));
            }
        }

        /* renamed from: d.b.j0.e1.s.a$a$f */
        /* loaded from: classes4.dex */
        public class f implements d.b.i0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f55945a;

            public f(C1296a c1296a, OfficialChatMessage officialChatMessage) {
                this.f55945a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f55945a);
            }
        }

        public C1296a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0090, code lost:
            d.b.i0.r.z.a.a("im", r0.getClientLogID(), r0.getCmd(), "up_pic_ret", r13.error_code, r13.error_msg, new java.lang.Object[0]);
         */
        @Override // d.b.i0.b0.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void a(String str, ImageUploadResult imageUploadResult) {
            d.b.i0.b0.a aVar;
            int i;
            synchronized (a.class) {
                aVar = (d.b.i0.b0.a) a.this.f55933b.remove(str);
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
                d.b.i0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", 0, null, new Object[0]);
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
                if (a.this.f55935d != null) {
                    a.this.f55935d.a(1);
                }
            }
            d.b.i0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", -1, "result is null", new Object[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
            if (chatMessage instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                h0.c(new C1297a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
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
        public final /* synthetic */ CommonGroupChatMessage f55946a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f55947b;

        public b(a aVar, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            this.f55946a = commonGroupChatMessage;
            this.f55947b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.b.j0.e1.h.c.h().l(this.f55946a.getGroupId(), this.f55947b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.i0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f55948a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f55949b;

        public c(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
            this.f55948a = commonGroupChatMessage;
            this.f55949b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f55948a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f55948a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.f55948a.getGroupId(), this.f55949b.getCustomGroupType(), this.f55949b, 3)));
        }
    }

    /* loaded from: classes4.dex */
    public class d extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f55950a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f55951b;

        public d(a aVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
            this.f55950a = personalChatMessage;
            this.f55951b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.b.j0.e1.h.m.t().m(d.b.j0.e1.w.c.m(this.f55950a), this.f55951b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.b.i0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f55952a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f55953b;

        public e(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
            this.f55952a = personalChatMessage;
            this.f55953b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f55952a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f55952a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f55952a.getToUserId()), 2, this.f55953b, 3)));
        }
    }

    /* loaded from: classes4.dex */
    public class f extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f55954a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f55955b;

        public f(a aVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
            this.f55954a = officialChatMessage;
            this.f55955b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.b.j0.e1.h.l.t().m(d.b.j0.e1.w.c.m(this.f55954a), this.f55955b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.b.i0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f55956a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f55957b;

        public g(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
            this.f55956a = officialChatMessage;
            this.f55957b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f55956a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f55956a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f55956a.getToUserId()), 4, this.f55957b, 3)));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements VoiceSendModel.b {

        /* renamed from: d.b.j0.e1.s.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1298a extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f55959a;

            public C1298a(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                this.f55959a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.j0.e1.h.c.h().o(this.f55959a.getGroupId(), String.valueOf(this.f55959a.getRecordId()), String.valueOf(this.f55959a.getMsgId()), 2));
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.b.i0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f55960a;

            public b(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                this.f55960a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f55960a);
            }
        }

        /* loaded from: classes4.dex */
        public class c extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f55961a;

            public c(h hVar, PersonalChatMessage personalChatMessage) {
                this.f55961a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.j0.e1.h.m.t().s(this.f55961a.getUserId(), this.f55961a.getToUserId(), String.valueOf(this.f55961a.getRecordId()), String.valueOf(this.f55961a.getMsgId()), 2));
            }
        }

        /* loaded from: classes4.dex */
        public class d implements d.b.i0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f55962a;

            public d(h hVar, PersonalChatMessage personalChatMessage) {
                this.f55962a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f55962a);
            }
        }

        /* loaded from: classes4.dex */
        public class e extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f55963a;

            public e(h hVar, OfficialChatMessage officialChatMessage) {
                this.f55963a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.j0.e1.h.l.t().s(this.f55963a.getUserId(), this.f55963a.getToUserId(), String.valueOf(this.f55963a.getRecordId()), String.valueOf(this.f55963a.getMsgId()), 2));
            }
        }

        /* loaded from: classes4.dex */
        public class f implements d.b.i0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f55964a;

            public f(h hVar, OfficialChatMessage officialChatMessage) {
                this.f55964a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f55964a);
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
                        VoiceMsgData n = d.b.j0.e1.w.c.n(chatMessage);
                        if (n != null) {
                            n.setVoice_md5(str);
                            String jsonStrWithObject = OrmObject.jsonStrWithObject(n);
                            chatMessage.setContent("[" + jsonStrWithObject + "]");
                        }
                        d.b.i0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", 0, null, new Object[0]);
                        a.j().t(chatMessage);
                        if (a.this.f55935d != null) {
                            a.this.f55935d.a(2);
                            return;
                        }
                        return;
                    }
                    d.b.i0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", -1, "voice http fail", new Object[0]);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        h0.c(new C1298a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
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
        public final /* synthetic */ String f55965a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f55966b;

        public i(String str, String str2) {
            this.f55965a = str;
            this.f55966b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            return BitmapFactory.decodeFile(this.f55965a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            a.this.r(this.f55966b, new d.b.c.j.d.a(bitmap, false));
        }
    }

    /* loaded from: classes4.dex */
    public class j extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55968a;

        public j(a aVar, String str) {
            this.f55968a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.b.j0.e1.h.c.h().f(this.f55968a, 2, null, 1000);
        }
    }

    /* loaded from: classes4.dex */
    public class k implements d.b.i0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.e1.s.c f55969a;

        public k(a aVar, d.b.j0.e1.s.c cVar) {
            this.f55969a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
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
                    String f2 = d.b.j0.e1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.b.j0.e1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f55969a.a(linkedHashMap2, hashMap);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55970a;

        public l(a aVar, String str) {
            this.f55970a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.b.j0.e1.h.m.t().f(this.f55970a, 2, null, 1000);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements d.b.i0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.e1.s.c f55971a;

        public m(a aVar, d.b.j0.e1.s.c cVar) {
            this.f55971a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
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
                    String f2 = d.b.j0.e1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.b.j0.e1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f55971a.a(linkedHashMap2, hashMap);
        }
    }

    /* loaded from: classes4.dex */
    public class n extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55972a;

        public n(a aVar, String str) {
            this.f55972a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.b.j0.e1.h.l.t().f(this.f55972a, 2, null, 1000);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements d.b.i0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.e1.s.c f55973a;

        public o(a aVar, d.b.j0.e1.s.c cVar) {
            this.f55973a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
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
                    String f2 = d.b.j0.e1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.b.j0.e1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f55973a.a(linkedHashMap2, hashMap);
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
        if (f55931h == null) {
            synchronized (a.class) {
                if (f55931h == null) {
                    f55931h = new a();
                }
            }
        }
        return f55931h;
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
        HashMap<String, d.b.i0.b0.a<ChatMessage>> hashMap = this.f55933b;
        if (hashMap != null && chatMessage != null) {
            for (Map.Entry<String, d.b.i0.b0.a<ChatMessage>> entry : hashMap.entrySet()) {
                d.b.i0.b0.a<ChatMessage> value = entry.getValue();
                if (value != null && value.f() != null) {
                    ChatMessage f2 = value.f();
                    if (chatMessage.getRecordId() != f2.getRecordId()) {
                        continue;
                    } else if (chatMessage.getCustomGroupType() != 2 && chatMessage.getCustomGroupType() != 4) {
                        if (chatMessage.getGroupId() != null && f2.getGroupId() != null && chatMessage.getGroupId().equals(f2.getGroupId())) {
                            WeakReference<a.b<ChatMessage>> weakReference = this.f55937f;
                            if (weakReference != null && weakReference.get() != null) {
                                value.m(this.f55937f.get());
                            }
                            return true;
                        }
                    } else if (chatMessage.getToUserId() == f2.getToUserId()) {
                        WeakReference<a.b<ChatMessage>> weakReference2 = this.f55937f;
                        if (weakReference2 != null && weakReference2.get() != null) {
                            value.m(this.f55937f.get());
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean h(ChatMessage chatMessage) {
        return i(chatMessage, this.f55932a) != -1;
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
        this.f55936e = voiceSendModel;
        voiceSendModel.t(this.f55938g);
        this.f55934c = new C1296a();
    }

    public final void l(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return;
        }
        this.f55932a.add(chatMessage);
    }

    public void n(String str, d.b.j0.e1.s.c cVar) {
        h0.c(new j(this, str), new k(this, cVar));
    }

    public void o(String str, d.b.j0.e1.s.c cVar) {
        h0.c(new n(this, str), new o(this, cVar));
    }

    public void p(String str, d.b.j0.e1.s.c cVar) {
        h0.c(new l(this, str), new m(this, cVar));
    }

    public final void q(ChatMessage chatMessage) {
        int i2 = i(chatMessage, this.f55932a);
        if (i2 >= 0) {
            this.f55932a.remove(i2);
        }
    }

    public final void r(String str, d.b.c.j.d.a aVar) {
        d.b.i0.a0.c.k().d(str, aVar);
        d.b.c.e.a.f.c cVar = new d.b.c.e.a.f.c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setData(aVar.n());
        cVar.setGif(false);
        d.b.c.e.a.d.g().a(cVar);
    }

    public final void s(String str, String str2) {
        d.b.c.j.d.a m2 = d.b.i0.a0.c.k().m(str);
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
        this.f55937f = new WeakReference<>(bVar);
    }

    public void v(d.b.j0.e1.s.d dVar) {
        this.f55935d = dVar;
    }

    public void y(ChatMessage chatMessage, String str) {
        d.b.i0.b0.a<ChatMessage> aVar = this.f55933b.get(str);
        if (aVar == null) {
            aVar = new d.b.i0.b0.a<>(str, "IM");
            aVar.j();
            aVar.i(chatMessage);
            WeakReference<a.b<ChatMessage>> weakReference = this.f55937f;
            if (weakReference != null && weakReference.get() != null) {
                aVar.m(this.f55937f.get());
            }
            aVar.l(this.f55934c);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar.h(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar.h(String.valueOf(i));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar.h(String.valueOf(j));
            }
            synchronized (a.class) {
                this.f55933b.put(str, aVar);
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
        this.f55936e.u(voiceMsgData.getVoice_md5(), chatMessage);
    }
}
