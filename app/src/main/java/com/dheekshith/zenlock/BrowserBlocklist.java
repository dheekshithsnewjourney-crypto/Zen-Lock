package com.dheekshith.zenlock;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowserBlocklist.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/dheekshith/zenlock/BrowserBlocklist;", "", "()V", "KNOWN_BROWSERS", "", "", "getKNOWN_BROWSERS", "()Ljava/util/Set;", "isBrowser", "", "packageName", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BrowserBlocklist {
    public static final BrowserBlocklist INSTANCE = new BrowserBlocklist();
    private static final Set<String> KNOWN_BROWSERS = SetsKt.setOf((Object[]) new String[]{"com.android.chrome", "com.chrome.beta", "com.chrome.dev", "com.chrome.canary", "com.google.android.apps.chrome", "org.mozilla.firefox", "org.mozilla.firefox_beta", "org.mozilla.fenix", "org.mozilla.focus", "org.mozilla.klar", "org.mozilla.rocket", "org.mozilla.tv.firefox", "org.mozilla.reference.browser", "com.brave.browser", "com.brave.browser_beta", "com.brave.browser_nightly", "com.brave.browser_default", "com.opera.browser", "com.opera.browser.beta", "com.opera.mini.native", "com.opera.mini.native.beta", "com.opera.gx", "com.opera.touch", "com.opera.crypto", "com.microsoft.emmx", "com.microsoft.emmx.beta", "com.microsoft.emmx.canary", "com.microsoft.emmx.dev", "com.duckduckgo.mobile.android", "com.duckduckgo.mobile.android.debug", "org.torproject.torbrowser", "org.torproject.torbrowser_alpha", "info.guardianproject.orfox", "com.stoutner.privacybrowser.standard", "com.stoutner.privacybrowser.free", "browser.privacy.protector", "com.perigee.privacybrowser", "com.cookiegames.smartcookie", "com.sec.android.app.sbrowser", "com.sec.android.app.sbrowser.beta", "com.miui.browser", "com.mi.globalbrowser", "com.mi.globalbrowser.mini", "com.heytap.browser", "com.oppo.browser", "com.vivo.browser", "com.transsion.phoenix", "com.UCMobile.intl", "com.UCMobile.x86", "com.ucweb.browser", "com.uc.browser.en", "com.yandex.browser", "com.yandex.browser.beta", "com.yandex.browser.alpha", "com.vivaldi.browser", "com.ecosia.android", "com.naver.whale", "com.qwant.liberty", "mark.via.gp", "mark.via", "com.jio.web", "acr.browser.lightning", "acr.browser.barebones", "acr.browser.raisebrowserfull", "com.kiwibrowser.browser", "com.iebrowser.fast", "com.mycompany.app.soulbrowser", "com.appsverse.photon", "com.mmbox.xbrowser", "com.mib.privatebrowser", "com.oh.bro", "org.adblockplus.browser", "com.tvbrowser.browser", "org.chromium.chrome", "net.dezor.browser", "com.aloha.browser", "com.mx.browser", "com.mx.browser.tablet", "com.cloudmosa.puffinFree", "com.CloudMosa.puffin", "com.puffin.web.browser", "com.ksmobile.cb", "com.ijinshan.browser_fast", "com.nubelacorp.stark", "com.oceanhero.search", "com.armorfly.browser", "com.finfin.browser", "com.jamal2367.styx", "org.lineageos.jelly", "com.amazon.cloud9", "com.freeit.mobile", "net.onecook.browser", "com.avira.android.browser", "com.avast.android.secure.browser", "com.mcafee.security.browser", "org.gnu.icecat", "com.craxiom.networksurvey"});

    private BrowserBlocklist() {
    }

    public final Set<String> getKNOWN_BROWSERS() {
        return KNOWN_BROWSERS;
    }

    public final boolean isBrowser(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return KNOWN_BROWSERS.contains(packageName);
    }
}
