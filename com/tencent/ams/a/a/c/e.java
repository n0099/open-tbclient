package com.tencent.ams.a.a.c;

import android.util.Xml;
import com.tencent.ams.a.a.b.f;
import com.tencent.ams.a.a.b.g;
import com.tencent.ams.a.a.b.h;
import com.tencent.ams.a.a.b.i;
import com.tencent.open.SocialOperation;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes15.dex */
public class e {
    public static g a(InputStream inputStream) {
        g gVar;
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(inputStream, "UTF-8");
            gVar = null;
            com.tencent.ams.a.a.b.a aVar = null;
            com.tencent.ams.a.a.b.b bVar = null;
            com.tencent.ams.a.a.b.e eVar = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 0:
                        try {
                            gVar = new g();
                            continue;
                        } catch (Throwable th) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th2) {
                                }
                            }
                            return gVar;
                        }
                    case 2:
                        String name = newPullParser.getName();
                        if ("offlineCache".equals(name)) {
                            gVar.f13272a = new f();
                        }
                        if (gVar.f13272a != null) {
                            if ("length".equals(name)) {
                                gVar.f13272a.f13270a = newPullParser.nextText();
                            }
                            if ("queueExpirationSecs".equals(name)) {
                                gVar.f13272a.f13271b = newPullParser.nextText();
                            }
                            if ("timeout".equals(name)) {
                                gVar.f13272a.c = newPullParser.nextText();
                            }
                        }
                        if ("companies".equals(name)) {
                            gVar.f13273b = new ArrayList();
                        }
                        if (gVar.f13273b != null && "company".equals(name)) {
                            bVar = new com.tencent.ams.a.a.b.b();
                        }
                        if (bVar == null) {
                            continue;
                        } else {
                            if ("name".equals(name) && bVar.f13263a == null) {
                                bVar.f13263a = newPullParser.nextText();
                            }
                            if ("encryptType".equals(name)) {
                                String nextText = newPullParser.nextText();
                                if (a(nextText)) {
                                    bVar.i = Integer.parseInt(nextText);
                                }
                            }
                            if ("domain".equals(name)) {
                                bVar.f13264b = new com.tencent.ams.a.a.b.d();
                            }
                            if (bVar.f13264b != null && "url".equals(name)) {
                                bVar.f13264b.f13267a = newPullParser.nextText();
                            }
                            if (SocialOperation.GAME_SIGNATURE.equals(name)) {
                                bVar.c = new h();
                            }
                            if (bVar.c != null) {
                                if ("publicKey".equals(name)) {
                                    bVar.c.f13274a = newPullParser.nextText();
                                }
                                if ("paramKey".equals(name)) {
                                    bVar.c.f13275b = newPullParser.nextText();
                                }
                            }
                            if ("switch".equals(name)) {
                                bVar.d = new i();
                            }
                            if (bVar.d != null) {
                                if ("isTrackLocation".equals(name)) {
                                    bVar.d.f13276a = Boolean.parseBoolean(newPullParser.nextText());
                                }
                                if ("offlineCacheExpiration".equals(name)) {
                                    bVar.d.f13277b = newPullParser.nextText();
                                }
                                if ("encrypt".equals(name)) {
                                    bVar.d.c = new HashMap();
                                }
                                if (bVar.d.c != null && ("MAC".equals(name) || "IDA".equals(name) || "IMEI".equals(name) || "ANDROID".equals(name))) {
                                    bVar.d.c.put(name, newPullParser.nextText());
                                }
                            }
                            if ("config".equals(name)) {
                                bVar.e = new com.tencent.ams.a.a.b.c();
                            }
                            if (bVar.e != null) {
                                if ("arguments".equals(name)) {
                                    bVar.e.f13265a = new ArrayList();
                                }
                                if (bVar.e.f13265a != null && "argument".equals(name)) {
                                    aVar = new com.tencent.ams.a.a.b.a();
                                }
                                if (aVar != null) {
                                    if ("key".equals(name)) {
                                        aVar.f13261a = newPullParser.nextText();
                                    }
                                    if ("value".equals(name)) {
                                        aVar.f13262b = newPullParser.nextText();
                                    }
                                    if ("urlEncode".equals(name)) {
                                        aVar.c = Boolean.parseBoolean(newPullParser.nextText());
                                    }
                                    if ("isRequired".equals(name)) {
                                        aVar.d = Boolean.parseBoolean(newPullParser.nextText());
                                    }
                                }
                                if ("events".equals(name)) {
                                    bVar.e.f13266b = new ArrayList();
                                }
                                if (bVar.e.f13266b != null && "event".equals(name)) {
                                    eVar = new com.tencent.ams.a.a.b.e();
                                }
                                if (eVar != null) {
                                    if ("key".equals(name)) {
                                        eVar.f13268a = newPullParser.nextText();
                                    }
                                    if ("value".equals(name)) {
                                        eVar.f13269b = newPullParser.nextText();
                                    }
                                    if ("urlEncode".equals(name)) {
                                        eVar.c = Boolean.parseBoolean(newPullParser.nextText());
                                    }
                                }
                            }
                            if ("separator".equals(name)) {
                                bVar.f = newPullParser.nextText();
                            }
                            if ("equalizer".equals(name)) {
                                bVar.g = newPullParser.nextText();
                            }
                            if ("timeStampUseSecond".equals(name)) {
                                bVar.h = Boolean.parseBoolean(newPullParser.nextText());
                                continue;
                            } else {
                                continue;
                            }
                        }
                    case 3:
                        String name2 = newPullParser.getName();
                        if ("company".equals(name2)) {
                            gVar.f13273b.add(bVar);
                            bVar = null;
                            continue;
                        } else if ("argument".equals(name2)) {
                            bVar.e.f13265a.add(aVar);
                            aVar = null;
                            continue;
                        } else if ("event".equals(name2)) {
                            bVar.e.f13266b.add(eVar);
                            eVar = null;
                            continue;
                        } else {
                            continue;
                        }
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th3) {
                }
            }
        } catch (Throwable th4) {
            gVar = null;
        }
        return gVar;
    }

    public static boolean a(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }
}
