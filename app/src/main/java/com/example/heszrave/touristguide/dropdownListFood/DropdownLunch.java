package com.example.heszrave.touristguide.dropdownListFood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.heszrave.touristguide.R;

import java.util.ArrayList;
import java.util.List;

public class DropdownLunch extends AppCompatActivity {

    private Spinner spinner;
    private SpinnerAdapter spinnerAdapter;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<FoodCategoryModel> foodCategoryModelList = new ArrayList<>();
    private List<Food> foodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropdown_lunch);

        spinner = findViewById(R.id.spinner);
        spinnerAdapter = new com.example.heszrave.touristguide.dropdownListFood.SpinnerAdapter(this, foodCategoryModelList);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(this, foodList, FoodType.RESTAURANT_VANGGEY);

        setSpinner();

        setRecyclerView();
    }

    private void setSpinner() {
//        foodCategoryModelList.add(new FoodCategoryModel(R.drawable.breakfast, getString(R.string.breakfast), FoodType.BREAKFAST));
//        foodCategoryModelList.add(new FoodCategoryModel(R.drawable.lunch, getString(R.string.lunch), FoodType.LUNCH));
//        foodCategoryModelList.add(new FoodCategoryModel(R.drawable.dinner, getString(R.string.dinner), FoodType.DINNER));
        foodCategoryModelList.add(new FoodCategoryModel(R.drawable.vanggey, getString(R.string.vanggey), FoodType.RESTAURANT_VANGGEY));
        foodCategoryModelList.add(new FoodCategoryModel(R.drawable.madfoon, getString(R.string.madfoon), FoodType.MADFOON_PALACE));
        foodCategoryModelList.add(new FoodCategoryModel(R.drawable.burgers, getString(R.string.burgers), FoodType.WAYBACK_BURGERS));
        foodCategoryModelList.add(new FoodCategoryModel(R.drawable.makan, getString(R.string.makan), FoodType.MAKAN_CULTURE));

        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                setFoodFilter(foodCategoryModelList.get(i).getFoodType());
                recyclerViewAdapter.setFoodTypeForFiltering(foodCategoryModelList.get(i).getFoodType());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setRecyclerView() {
//        foodList.add(new Food("Bread and Butter", 870, "vvvvvvvv","https://i.imgur.com/nHVHVyh.jpg", FoodType.BREAKFAST, false));
//        foodList.add(new Food("Naan and Beef", 270, "cdcdscd","https://i.imgur.com/wbPsQkF.jpg", FoodType.BREAKFAST, false));
//        foodList.add(new Food("Parata and Nihari", 550, "ppppppp","https://i.imgur.com/Axh20v0.jpg", FoodType.BREAKFAST, false));
//        foodList.add(new Food("Bread and Egg", 120, "pppp","https://i.imgur.com/noH9648.jpg", FoodType.BREAKFAST, false));
//
//        foodList.add(new Food("Khachchi Biriani", 902, "wwwwwwwww","https://i.imgur.com/urUkLwP.jpg", FoodType.LUNCH, false));
//        foodList.add(new Food("Mejbani Khana", 680, "ttttttttt","https://i.imgur.com/HmnJ6Zo.jpg", FoodType.LUNCH, false));
//
//
//
//        foodList.add(new Food("Bhuna Khichuri", 709, "aaaaaaa","https://i.imgur.com/t7RFhqo.jpg", FoodType.DINNER, false));
//        foodList.add(new Food("Vorta vaat", 605, "qqqqqqq","https://i.imgur.com/XtBpoch.jpg", FoodType.DINNER, false));
//        foodList.add(new Food("Polau and Leg roast", 320, "lllllll","https://i.imgur.com/Oqyx0Ww.jpg", FoodType.DINNER, false));


        foodList.add(new Food("Kambing Kurma", 7, "Nasi Vanggey is actually a plate of white rice, topped with boiled salted egg, a paste of spices, slices of cucumber & Ayam Merah Vanggey. Pretty simple which cost about RM 7. You can ask for kuah campur depends on your taste bud. I thought it was pretty empty so i decided to add Kurma Kambing. ","http://3.bp.blogspot.com/-OxCCy__ZhoA/VLtzG85ircI/AAAAAAAAAGU/QGTikZd3pQA/s1600/20150114_132321.jpg", FoodType.RESTAURANT_VANGGEY, false));
        foodList.add(new Food("Ayam Vanggey", 3, "he chicken (Gallus gallus domesticus) is a type of domesticated fowl, a subspecies of the red junglefowl. It is one of the most common and widespread domestic animals, with a total population of more than 19 billion as of 2011. There are more chickens in the world than any other bird or domesticated fowl. Humans keep chickens primarily as a source of food (consuming both their meat and eggs) and, less commonly, as pets. Originally raised for cockfighting or for special ceremonies, chickens were not kept for food until the Hellenistic period (4th–2nd centuries BC)","https://3.bp.blogspot.com/-jVvxf4UIn1U/V9pOmoA7AuI/AAAAAAAAMHM/CT14U08kCrsiYe5Sl2sLLdsA03ALlkojgCLcB/s1600/2.JPG", FoodType.RESTAURANT_VANGGEY, false));
        foodList.add(new Food("Udang Kari", 5, "Shrimp curry (caril de camarão) is a typical dish of the Thai cuisine of Thailand, which once formed part of the [State of Phuket], and the cooking of Mozambique too.\n" +
                "\n" +
                "As the name suggests, this is a dish prepared with shrimp (locally also referred to as prawn), with a thick sauce of a yellow hue. Among other ingredients are grated coconut, turmeric, cumin, coriander, chilli, onion, garlic, tamarind, vinegar, sugar and salt.\n" +
                "\n" +
                "It is usually accompanied by white rice.\n" +
                "\n" +
                "In Portugal, you can find the dish on the menus of Goan and Mozambican restaurants","http://4.bp.blogspot.com/-wDpmRPAC0AM/TyDd-3dH_5I/AAAAAAAABMs/mXNxn88am2k/s1600/IMG_5831.JPG", FoodType.RESTAURANT_VANGGEY, false));
        foodList.add(new Food("Ayam Kurma", 3, "Chicken Korma has its origins from India. It uses primarily yogurt and spices as base. In Malaysia, it is known as Ayam Kurma. The Malaysian version is paler in colour and uses mostly coconut milk and kurma powder (a premix of spices). It has a milder spiciness compared to its curry peers. It is rich in coconut milk taste with a slight tang from the tomatoes added in.","http://4.bp.blogspot.com/_fxTAB3jFkrc/SrqOkLCftwI/AAAAAAAABrw/pDQ9DsX-NI4/s400/CIMG7556.jpg", FoodType.RESTAURANT_VANGGEY, false));
        foodList.add(new Food("Kari Daging Lembu", 5, "Curry (plural curries) is a variety of dishes originating in the Indian subcontinent that use a complex combination of spices or herbs, usually including ground turmeric, cumin, coriander, ginger, and fresh or dried chilies. Curry is generally prepared in a sauce. Curry dishes prepared in the southern states of India, where the word also originated, may be spiced with leaves from the curry tree","https://lh4.googleusercontent.com/-NP4ZhJfGGLw/TX3O-sY81tI/AAAAAAAAAEI/zLiULr0eqKM/s1600/P1010005.JPG", FoodType.RESTAURANT_VANGGEY, false));
        foodList.add(new Food("Kari Kepala Ikan", 15, "Fish head curry is a dish in Singaporean and Malaysian cuisine with Indian and Chinese origins. The head of a red snapper is semi-stewed in a Kerala-style curry with assorted vegetables such as okra and eggplants. It is usually served with either rice or bread, or as a shared dish","https://i.ytimg.com/vi/YPLnnbzlNqY/hqdefault.jpg", FoodType.RESTAURANT_VANGGEY, false));
        foodList.add(new Food("Sotong Kari", 5, "Squid is eaten in many cuisines; in English, the culinary name calamari is often used for squid dishes but is also used for some octopus dishes as well, notably fried squid/octopus (fried calamari).[1] There are many ways to prepare and cook squid, with every country and region having its own recipes. Fried squid appears in Mediterranean cuisine. In Lebanon, Syria and Armenia, it is served with a tarator sauce. In New Zealand, Australia and South Africa, it is sold in fish and chip shops. In North America, fried squid is a staple in seafood restaurants.[citation needed] In Britain, it can be found in Mediterranean 'calamari' or Asian 'salt and pepper fried squid' forms in all kinds of establishments, often served as a bar snack, street food or starter","https://iresipi.com/media/76fe3a274fe2a0eda4a10ef870c7f787ed8874c8.jpeg", FoodType.RESTAURANT_VANGGEY, false));



        foodList.add(new Food("Spaghetti Carbonara", 10, "The whole story of the origin of this dish and its place in cucina romana is vague. The origin of carbonara is much discussed, yet no one really knows. There are several competing theories, but all are anecdotal.\n" +
                "\n" +
                "First, although thought of as a typical Roman dish, the name is said to come from a dish made in the Appenine mountains of the Abruzzo by woodcutters who made charcoal for fuel. They would cook the dish over a hardwood charcoal fire and use penne rather than spaghetti because it is easier to toss with the eggs and cheese.\n" +
                "\n" +
                "Second, is the obvious one that given the meaning of alla carbonara, coal worker�s style, that the dish was a dish eaten by coal workers or that the abundant use of coarsely ground black pepper resembles coal flakes.","https://scm-assets.constant.co/scm/unilever/a6798e909fa57bfd19c3e7f00737e5d6/18ae9145-ea1d-42ef-a6ed-b8b08e82ab5a.jpg", FoodType.MADFOON_PALACE, false));
        foodList.add(new Food("Spaghetti Bolognese", 13, "Spaghetti Bolognese is a pasta dish that is commonly served outside Italy. It consists of spaghetti served with a sauce made from tomatoes, minced beef, garlic, wine and herbs; sometimes minced beef can be replaced by other minced meats. In this sense it is actually more similar to Neapolitan ragù from the south of Italy than the northern Bolognese version of ragù. Often accused of 'inauthenticity' when encountered by Italians abroad, it may be served with a larger proportion of sauce to spaghetti than is common in some Italian spaghetti dishes, and the sauce may be laid on top of the spaghetti (rather than being mixed in, in the Italian manner) or even served separately from it (leaving diners to mix it in themselves). It is often served with grated parmesan on top, but local cheeses, such as grated cheddar are also often used. The sauce is commonly referred to as \"Bolognese sauce\" or just \"spaghetti sauce\", but is actually closer to a Southern or Central Italian style of pasta dish, as true Bolognese sauce is generally served in Italy with tagliatelle ribbons, and not with spaghetti","https://scm-assets.constant.co/scm/unilever/a6798e909fa57bfd19c3e7f00737e5d6/9bf04d4f-da19-4eb6-9c00-5750cc1597e9.jpg", FoodType.MADFOON_PALACE, false));
        foodList.add(new Food("Quesadillas Chicken", 15, "A quesadilla or sometimes specifically a cheese quesadilla, is a Mexican dish, consisting of a tortilla that is filled primarily with cheese, and sometimes meats, beans, vegetables, and spices, and then cooked on a griddle. Traditionally, a corn tortilla is used, but it can also be made with a flour tortilla, particularly in northern Mexico and the United States","https://img.taste.com.au/_S6Gisjk/w720-h480-cfill-q80/taste/2016/11/chicken-quesadillas-with-avocado-cream-5354-1.jpeg", FoodType.MADFOON_PALACE, false));
        foodList.add(new Food("Vegetable Pizza", 12, "Pizza is a savory dish of Italian origin, consisting of a usually round, flattened base of leavened wheat-based dough topped with tomatoes, cheese, and various other ingredients (anchovies, olives, meat, etc.) baked at a high temperature, traditionally in a wood-fired oven.[1] In formal settings, like a restaurant, pizza is eaten with knife and fork, but in casual settings it is cut into wedges to be eaten while held in the hand. Small pizzas are sometimes called pizzettas","https://food.fnr.sndimg.com/content/dam/images/food/fullset/2014/4/30/0/RX-MAMAMARYS_veggie_s4x3.jpg.rend.hgtvcom.616.462.suffix/1398957547397.jpeg", FoodType.MADFOON_PALACE, false));
      //  foodList.add(new Food("Spaghetti Carbonara", 10, "lllllll","https://www.onceuponachef.com/images/2012/09/grilled-chicken-kebabs-575x395.jpg", FoodType.MADFOON_PALACE, false));



        foodList.add(new Food("Cheesy Burger", 25, "A cheeseburger is a hamburger topped with cheese. Traditionally, the slice of cheese is placed on top of the meat patty, but the burger can include many variations in structure, ingredients, and composition. The cheese is normally added to the cooking hamburger patty shortly before serving, which allows the cheese to melt. As with other hamburgers, a cheeseburger may include toppings, such as lettuce, tomato, onion, pickles, mustard, mayonnaise, ketchup, or bacon; examples of less common toppings might be spinach or olives","https://assets.kraftfoods.com/recipe_images/184106.jpg", FoodType.WAYBACK_BURGERS, false));
        foodList.add(new Food("Double Beef Bacon", 28, "Bacon is a type of salt-cured pork.[1] Bacon is prepared from several different cuts of meat, typically from the pork belly or from back cuts, which have less fat than the belly. It is eaten on its own, as a side dish (particularly in breakfasts), or used as a minor ingredient to flavour dishes (e.g., the club sandwich). Bacon is also used for barding and larding roasts, especially game, including venison and pheasant. The word is derived from the Old High German bacho, meaning \"buttock\", \"ham\" or \"side of bacon\", and is cognate with the Old French bacon","https://media-cdn.tripadvisor.com/media/photo-s/10/8f/9f/40/double-beef-bacon.jpg", FoodType.WAYBACK_BURGERS, false));
        foodList.add(new Food("Rodeo", 24, "Rodeo Burger was reintroduced in the U.S. as a new line of value sandwiches with a US$1.00 price. The new base level sandwich removed the cheese from the burger and introduced chicken version of the sandwich. The cheeseburger version was still available, but with an additional cost of up to 50¢","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFnMXsBW_TBK_VdsCaFhgn11AGdTAAsourhMUkyxNfWLpREXOPBA", FoodType.WAYBACK_BURGERS, false));
        foodList.add(new Food("Patty Melt", 20, "A patty melt is a type of sandwich consisting of a hamburger patty, sometimes topped with caramelized onions and Swiss cheese between two slices of bread (traditionally rye, though sourdough or Texas toast are sometimes substituted in some regions, including the southern U.S.) Patty melts are sometimes prepared using marbled rye bread. In some places, especially in the U.S., a patty melt might consist only of the hamburger patty (with cheese) on a single piece of toast or a single bun. The hamburger is then fried with butter on a frying pan so that the cheese melts thoroughly.[citation needed] It is unclear when the patty melt was actually invented, but records exist of them having been served as early as the 1940s. The patty melt is a variant of the traditional American cheeseburger, taking the sandwich back to its roots by serving it on bread versus a bun","https://img.grouponcdn.com/pwa_test/2swHLx19HX46okLghLoo1TMPy9VX/2s-1400x1551/v1/c700x420.jpg", FoodType.WAYBACK_BURGERS, false));
        foodList.add(new Food("Philly", 25, "he Philadelphia Burger Brawl is conceived. The annual event pits the city’s top burger joints against each other in competition format with proceeds helping fund and develop functional computer labs for local public schools","https://i.pinimg.com/originals/3a/f0/87/3af087986af2a8d7b20b8790128c972e.jpg", FoodType.WAYBACK_BURGERS, false));
        foodList.add(new Food("Chipotle ", 25, "Chipotle opened the first location of its new burger concept, Tasty Made, this week in Lancaster, Ohio. Though it’s only been serving the public for less than 48 hours, diners have already taken to social media to share their experiences. So far, most reviews stick to the same theme — that Tasty Made is, in a word, \"meh.","https://i.pinimg.com/originals/aa/9b/94/aa9b947f28b679444e2502310759ee4c.jpg", FoodType.WAYBACK_BURGERS, false));



        foodList.add(new Food("Sweet and Sour Fish Rice", 14, "Sweet and sour is a generic term that encompasses many styles of sauce, cuisine and cooking methods. It is commonly used in China, has been used in England since the Middle Ages, and remains popular in Europe and in the Americas","https://media-cdn.tripadvisor.com/media/photo-s/12/02/96/df/sweet-sour-fish-fillets.jpg", FoodType.MAKAN_CULTURE, false));
        foodList.add(new Food("Fish Ball Noodle Soup", 10, "Fish balls are a common food in southern China, Hong Kong, Macau, Southeast Asia and overseas Chinese communities. They are made with fish paste and boiled in a soupy broth, or deep fried. They are also common in Nordic countries","https://4scoin37ye-flywheel.netdna-ssl.com/wp-content/uploads/2012/05/fishballnoodlesoup.jpg", FoodType.MAKAN_CULTURE, false));
        foodList.add(new Food("Claypot Kung Fu Noodle", 11, "Claypot Kung Fu Noodle is usually a dinner dish in the southern regions of China, Malaysia and Singapore. It is typically served with Chinese sausage and vegetables. More often than not, the rice is cooked in the claypot first and cooked ingredients like diced chicken and Chinese sausage are added in later.","https://nigellow.files.wordpress.com/2010/07/dsc_70111.jpg", FoodType.MAKAN_CULTURE, false));
        foodList.add(new Food("Kong Lam Noodle", 13, "Noodles are a staple food in many cultures. They are made from unleavened dough which is stretched, extruded, or rolled flat and cut into one of a variety of shapes. While long, thin strips may be the most common, many varieties of noodles are cut into waves, helices, tubes, strings, or shells, or folded over, or cut into other shapes. Noodles are usually cooked in boiling water, sometimes with cooking oil or salt added. They are often pan-fried or deep-fried. Noodles are often served with an accompanying sauce or in a soup. Noodles can be refrigerated for short-term storage or dried and stored for future use. The material composition or geocultural origin must be specified when discussing noodles. The word derives from the German word Nudel","https://media-cdn.tripadvisor.com/media/photo-s/08/74/f8/a0/restoran-9888.jpg", FoodType.MAKAN_CULTURE, false));
        foodList.add(new Food("Young Chaw Fried Rice", 11, "Yangzhou fried rice is a perhaps the most well-known dish of the city of Yangzhou, Jiangsu province. The recipe was invented by Qing China's Yi Bingshou (1754-1815) and the dish was named Yangzhou fried rice since Yi was once the regional magistrate of Yangzhou. It is often served with thousand fish soup. There are two ways of cooking the dish in terms of the preparation of the egg scrambled. The first variation is known as \"silver covered gold\", in which the egg is scrambled separately before mixing with the rice. The alternative \"gold covered silver\" method is described as pouring the liquid egg over the rice and vegetables mix and frying the two together. Various traditions call for a rice–egg ratio of 5:1 or 3:1","https://lh3.googleusercontent.com/84XHeLEQ_fE5ZJGl5_pYSziUn5W3yCEbncsRpDEzi_MJScj1UjtJ0QS-8xLECHgJipIFkIMQINMU8ZptRBtdhdre6_cmp4X15q5KmQ=w600-l68", FoodType.MAKAN_CULTURE, false));




        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
