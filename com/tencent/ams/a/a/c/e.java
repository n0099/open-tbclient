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
/* loaded from: classes4.dex */
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
                            gVar.f13570a = new f();
                        }
                        if (gVar.f13570a != null) {
                            if ("length".equals(name)) {
                                gVar.f13570a.f13568a = newPullParser.nextText();
                            }
                            if ("queueExpirationSecs".equals(name)) {
                                gVar.f13570a.f13569b = newPullParser.nextText();
                            }
                            if ("timeout".equals(name)) {
                                gVar.f13570a.c = newPullParser.nextText();
                            }
                        }
                        if ("companies".equals(name)) {
                            gVar.f13571b = new ArrayList();
                        }
                        if (gVar.f13571b != null && "company".equals(name)) {
                            bVar = new com.tencent.ams.a.a.b.b();
                        }
                        if (bVar == null) {
                            continue;
                        } else {
                            if ("name".equals(name) && bVar.f13561a == null) {
                                bVar.f13561a = newPullParser.nextText();
                            }
                            if ("encryptType".equals(name)) {
                                String nextText = newPullParser.nextText();
                                if (a(nextText)) {
                                    bVar.i = Integer.parseInt(nextText);
                                }
                            }
                            if ("domain".equals(name)) {
                                bVar.f13562b = new com.tencent.ams.a.a.b.d();
                            }
                            if (bVar.f13562b != null && "url".equals(name)) {
                                bVar.f13562b.f13565a = newPullParser.nextText();
                            }
                            if (SocialOperation.GAME_SIGNATURE.equals(name)) {
                                bVar.c = new h();
                            }
                            if (bVar.c != null) {
                                if ("publicKey".equals(name)) {
                                    bVar.c.f13572a = newPullParser.nextText();
                                }
                                if ("paramKey".equals(name)) {
                                    bVar.c.f13573b = newPullParser.nextText();
                                }
                            }
                            if ("switch".equals(name)) {
                                bVar.d = new i();
                            }
                            if (bVar.d != null) {
                                if ("isTrackLocation".equals(name)) {
                                    bVar.d.f13574a = Boolean.parseBoolean(newPullParser.nextText());
                                }
                                if ("offlineCacheExpiration".equals(name)) {
                                    bVar.d.f13575b = newPullParser.nextText();
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
                                    bVar.e.f13563a = new ArrayList();
                                }
                                if (bVar.e.f13563a != null && "argument".equals(name)) {
                                    aVar = new com.tencent.ams.a.a.b.a();
                                }
                                if (aVar != null) {
                                    if ("key".equals(name)) {
                                        aVar.f13559a = newPullParser.nextText();
                                    }
                                    if ("value".equals(name)) {
                                        aVar.f13560b = newPullParser.nextText();
                                    }
                                    if ("urlEncode".equals(name)) {
                                        aVar.c = Boolean.parseBoolean(newPullParser.nextText());
                                    }
                                    if ("isRequired".equals(name)) {
                                        aVar.d = Boolean.parseBoolean(newPullParser.nextText());
                                    }
                                }
                                if ("events".equals(name)) {
                                    bVar.e.f13564b = new ArrayList();
                                }
                                if (bVar.e.f13564b != null && "event".equals(name)) {
                                    eVar = new com.tencent.ams.a.a.b.e();
                                }
                                if (eVar != null) {
                                    if ("key".equals(name)) {
                                        eVar.f13566a = newPullParser.nextText();
                                    }
                                    if ("value".equals(name)) {
                                        eVar.f13567b = newPullParser.nextText();
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
                            gVar.f13571b.add(bVar);
                            bVar = null;
                            continue;
                        } else if ("argument".equals(name2)) {
                            bVar.e.f13563a.add(aVar);
                            aVar = null;
                            continue;
                        } else if ("event".equals(name2)) {
                            bVar.e.f13564b.add(eVar);
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
