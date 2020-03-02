package com.kascend.chushou.player;

import com.kascend.chushou.constants.ChatInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class a {
    private C0692a mPZ = new C0692a();
    private LinkedList<ChatInfo> a = new LinkedList<>();
    private LinkedList<ChatInfo> b = new LinkedList<>();

    public void a() {
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
        if (this.b != null) {
            this.b.clear();
            this.b = null;
        }
    }

    public void b() {
        if (this.a != null) {
            synchronized (this.a) {
                this.a.clear();
            }
        }
    }

    public void a(ArrayList<ChatInfo> arrayList) {
        if (this.a != null) {
            synchronized (this.a) {
                c(arrayList);
                this.a.addAll(arrayList);
                Collections.sort(this.a, this.mPZ);
            }
        }
    }

    private void c(ArrayList<ChatInfo> arrayList) {
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                break;
            }
            ChatInfo chatInfo = arrayList.get(i);
            if (chatInfo.mAnimationStage > 1 && !h.isEmpty(chatInfo.mUserID)) {
                a(this.a, chatInfo);
                if (a(arrayList.subList(0, i), chatInfo)) {
                    z = true;
                    break;
                }
            }
            i++;
        }
        if (z) {
            c(arrayList);
        }
    }

    public ChatInfo dCC() {
        if (this.a != null) {
            synchronized (this.a) {
                if (this.a.size() > 0) {
                    return this.a.removeFirst();
                }
            }
        }
        return null;
    }

    public boolean d() {
        if (this.a != null) {
            synchronized (this.a) {
                r0 = this.a.size() > 0;
            }
        }
        return r0;
    }

    public void e() {
        if (this.b != null) {
            synchronized (this.b) {
                this.b.clear();
            }
        }
    }

    public void b(ArrayList<ChatInfo> arrayList) {
        if (this.b != null) {
            synchronized (this.b) {
                this.b.addAll(arrayList);
            }
        }
    }

    public ChatInfo dCD() {
        if (this.b != null) {
            synchronized (this.b) {
                if (this.b.size() > 0) {
                    return this.b.removeFirst();
                }
            }
        }
        return null;
    }

    public int g() {
        if (this.b != null) {
            return this.b.size();
        }
        return 0;
    }

    public boolean h() {
        if (this.b != null) {
            synchronized (this.b) {
                r0 = this.b.size() > 0;
            }
        }
        return r0;
    }

    private boolean a(List<ChatInfo> list, ChatInfo chatInfo) {
        boolean z = false;
        Iterator<ChatInfo> it = list.iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                ChatInfo next = it.next();
                if (chatInfo.mUserID.equals(next.mUserID) && chatInfo.mGift.id == next.mGift.id && next.mAnimationStage < chatInfo.mAnimationStage) {
                    it.remove();
                    z2 = true;
                }
                z = z2;
            } else {
                return z2;
            }
        }
    }

    /* renamed from: com.kascend.chushou.player.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0692a implements Comparator<ChatInfo> {
        private C0692a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ChatInfo chatInfo, ChatInfo chatInfo2) {
            return chatInfo.mAnimationPriority == chatInfo2.mAnimationPriority ? (int) (chatInfo.mCreatedTime - chatInfo2.mCreatedTime) : -(chatInfo.mAnimationPriority - chatInfo2.mAnimationPriority);
        }
    }
}
